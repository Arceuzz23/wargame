from math import sqrt
from PIL import Image

class Asset:
    feet_per_meter = 3.281

    def __init__(self, name, nickname, manufacturer, flavor_text, base_cost, uav_cost, gcs_cost, o_and_s_cost, personnel_required, max_range, cruising_speed):
        self.name = name
        self.nickname = nickname
        self.manufacturer = manufacturer
        self.flavor_text = flavor_text
        self.uav_purchased = 0
        self.gcs_purchased = 0
        self.base_cost = base_cost
        self.uav_cost = uav_cost
        self.gcs_cost = gcs_cost
        self.o_and_s_cost = o_and_s_cost
        self.personnel_required = personnel_required
        self.max_range = max_range
        self.cruise_speed = cruising_speed
        self.average_opposing_wind = 0
        self.cruise_altitude_ft = 0
        self.availability_rate = 7
        self.range_to_sweep_width_conversion = 9
        self.revisit_rate = 2
        self.area_of_regard = 600000
        self.image = Image.open(f"{name.replace(' ', '_')}.png")

    def get_total_cost(self):
        purchased = 1 if self.uav_purchased > 0 else 0
        return self.base_cost * purchased + self.uav_purchased * self.uav_cost + self.gcs_purchased * self.gcs_cost

    def get_procurement_cost(self):
        return self.uav_cost * self.uav_purchased + self.base_cost

    def get_ground_infrastructure_cost(self):
        answer = self.gcs_cost * (self.gcs_purchased - 2)
        return max(answer, 0)

    def get_o_and_s_cost(self):
        if self.name == "Thunderhead" and self.uav_purchased > 0:
            return 8000000 + self.o_and_s_cost * self.uav_purchased
        return self.o_and_s_cost * self.uav_purchased

    def get_personnel_requirement(self):
        if self.name == "Thunderhead" and self.uav_purchased > 0:
            return 24 + self.personnel_required * self.uav_purchased
        return self.personnel_required * self.uav_purchased

    def __str__(self):
        return self.name

    def get_average_net_speed(self):
        return self.cruise_speed - self.average_opposing_wind

    def get_total_endurance(self):
        return self.max_range / self.cruise_speed - 1.0

    def get_cruise_altitude_m(self):
        return int(self.cruise_altitude_ft / self.feet_per_meter)

    def get_range_to_horizon(self):
        return 1.0614 * sqrt(self.cruise_altitude_ft)

    def get_area_sweep_per_hour(self):
        return (self.get_average_net_speed() * 2) * self.get_range_to_horizon() * self.range_to_sweep_width_conversion / 10.0

    def get_average_time_on_station(self, r):
        answer = (self.max_range * (self.get_average_net_speed() / self.cruise_speed) - (r * 2)) / self.get_average_net_speed() - 1.0
        return answer * 0.55 if self.name == "Thunderhead" else answer

    def get_duty_cycle(self, r):
        return self.get_average_time_on_station(r) / self.get_total_endurance()

    def get_area_search_area(self, r):
        return int((self.availability_rate / 10.0 * self.uav_purchased) * self.get_duty_cycle(r) * self.get_area_sweep_per_hour() * self.revisit_rate)

    def get_area_search_assets(self, r):
        numerator = int(self.area_of_regard / (self.get_area_sweep_per_hour() * self.revisit_rate) / self.get_duty_cycle(r))
        return numerator


