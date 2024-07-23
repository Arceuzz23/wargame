package com.example.demo;
import javafx.scene.image.Image;

import java.text.NumberFormat;
import java.util.Locale;

class Asset {
    String name;
    String nickname;
    String manufacturer;
    String flavorText;
    int UAVPurchased;
    int GCSPurchased;
    long baseCost;
    long UAVCost;
    long GCSCost;
    long OAndSCost;
    int personnelRequired;
    int maxRange;
    int cruiseSpeed;
    int averageOpposingWind;
    int cruiseAltitudeFt;
    final double feetPerMeter = 3.281;
    int availabilityRate;
    int rangeToSweepWidthConversion;
    int revisitRate;
    int areaOfRegard;
    Image image;
    public Asset(String name, String nickname, String manufacturer, String flavorText, long baseCost, long UAVCost, long GCSCost, long OAndSCost, int personnelRequired, int maxRange, int cruisingSpeed) {
        this.name = name;
        this.nickname = nickname;
        this.manufacturer = manufacturer;
        this.flavorText = flavorText;
        this.UAVPurchased = 0;
        this.GCSPurchased = 0;
        this.baseCost = baseCost;
        this.UAVCost = UAVCost;
        this.GCSCost = GCSCost;
        this.OAndSCost = OAndSCost;
        this.personnelRequired = personnelRequired;
        this.maxRange = maxRange;
        this.cruiseSpeed = cruisingSpeed;
        this.averageOpposingWind = 0;
        this.cruiseAltitudeFt = 0;
        this.availabilityRate = 7;
        this.rangeToSweepWidthConversion = 9;
        this.revisitRate = 2;
        this.areaOfRegard = 600000;
        this.image = new Image(AssetApplication.class.getResourceAsStream(name.replace(' ', '_') + ".png"));
    }
    public long getTotalCost() {
        int purchased = (UAVPurchased > 0) ? 1 : 0;
        return baseCost * purchased + UAVPurchased * UAVCost + GCSPurchased * GCSCost;
    }
    public long getProcurementCost() {
        return UAVCost * UAVPurchased + baseCost;
    }
    public long getGroundInfrastructureCost() {
        long answer = GCSCost * (GCSPurchased - 2);
        return answer > 0 ? answer : 0;
    }
    public long getOAndSCost() {
        if(this.name.equals("Thunderhead")) {
            if(this.UAVPurchased > 0) return 8000000 + OAndSCost * UAVPurchased;
        }
        return OAndSCost * UAVPurchased;
    }
    public int getPersonnelRequirement() {
        if(this.name.equals("Thunderhead")) {
            if(this.UAVPurchased > 0) return 24 + personnelRequired * UAVPurchased;
        }
        return personnelRequired * UAVPurchased;
    }
    public String toString() {
        return this.name;
    }
    public int getAverageNetSpeed() {
        return this.cruiseSpeed - this.averageOpposingWind;
    }
    public double getTotalEndurance() {
        return (double) this.maxRange/(double) this.cruiseSpeed - 1;
    }
    public int getCruiseAltitudeM() {
        return (int) (cruiseAltitudeFt/feetPerMeter);
    }
    public double getRangeToHorizon() {
        return 1.22 * 0.87 * Math.sqrt(this.cruiseAltitudeFt);
    }
    public double getAreaSweepPerHour() {
        return getAverageNetSpeed() * 2 * getRangeToHorizon() * this.rangeToSweepWidthConversion/10.0;
    }
    public double getAverageTimeOnStation(int r) {
        double answer = ((this.maxRange * ((double) this.getAverageNetSpeed()/ (double) this.cruiseSpeed)-(r * 2))/(double) this.getAverageNetSpeed())-1;
        return this.name.equals("Thunderhead") ? answer * 0.55 : answer;
    }
    public double getDutyCycle(int r) {
        return this.getAverageTimeOnStation(r) / this.getTotalEndurance();
    }
    public int getAreaSearchArea(int r) {
        return (int) (((int) ((this.availabilityRate/10.0) * this.UAVPurchased)) * this.getDutyCycle(r) * this.getAreaSweepPerHour() * this.revisitRate);
    }
    public int getAreaSearchAssets(int r) {
        int numerator = (int) (this.areaOfRegard/(this.getAreaSweepPerHour() * (double) this.revisitRate)/this.getDutyCycle(r) + 1);
        double denominator = this.availabilityRate/10.0;
        int answer = (int) (numerator/denominator + 1);
        return answer;
    }
    public double getFocusSearchArea(int r) {
        return (UAVPurchased * (this.availabilityRate/10.0) * this.getDutyCycle(r));
    }
    public int getFocusSearchAssets(int r) {
        //TODO
        int answer = (int) (this.areaOfRegard / (Math.PI * (Math.pow(2 * (this.rangeToSweepWidthConversion/10.0) * this.getRangeToHorizon(), 2.0)) * this.getDutyCycle(r) / (this.availabilityRate/10.0))) + 1;
        return answer;
    }

}
class ShoppingCart {
    public Asset MQ4C = new Asset(
            "MQ-4C",
            "Triton",
            "Northrop Grumman",
            "Northrop Grumman’s MQ-4C Triton unmanned aircraft system (UAS) provides real-time ISR&T over vast ocean and coastal regions.\n" + "\n" + "Based on the proven Global Hawk UAS, Triton’s autonomous operations are supported by land-based command and control mission planners and sensor operators. Triton will be equipped with a unique and robust mission sensor suite that provides 360-degree coverage on all sensors, providing maritime domain awareness for the U.S. Navy.\n" + "\n" + "Triton also incorporates a reinforced airframe, for increased internal payload, and wing for hail, bird strike, and gust load protection, along with de-icing and lightning protection systems.",
            450000000L,
            150000000L,
            25000000L,
            27500000L,
            83,
            8200,
            270);
    public Asset MQ9B = new Asset(
            "MQ-9B",
            "SeaGuardian",
            "GA Aeronautical",
            "MQ-9B SeaGuardian is the maritime-focused sibling of the SkyGuardian remotely piloted aircraft system (RPAS) that has been missionized using “bolt-on/bolt-off” maritime sensors. SeaGuardian is designed to fly over the horizon via SATCOM for up to 30 hours (depending on configuration) in all types of weather and safely integrate into civil airspace, enabling joint forces and civil authorities to deliver real-time situational awareness.\n\nIn addition to its Lynx Multi-Mode Radar, advanced electro-optical/infrared sensor, automatic takeoff and landing capability, and the same 79 ft (24m) wingspan as SkyGuardian, SeaGuardian includes a centerline wide-area maritime radar mission kit, automatic identification system, and an optional self-contained anti-submarine warfare (ASW) mission kit.",
            576400000L,
            26446290L,
            15000000L,
            9900000L,
            36,
            3887,
            169);
    public Asset integrator = new Asset(
            "Integrator ER",
            "",
            "Boeing Insitu",
            "The latest variant of the Integrator unmanned aircraft system (UAS) builds upon more than one million hours of operational experience and innovation to deliver Group 4 and 5 capabilities in a Group 3 UAS. With added satellite-enabled beyond line of sight (SATCOM BLOS) communications, the Integrator UAS delivers extended ranges to reduce logistical challenges and increase safety for fielded personnel.\n\nIntegrator ER can operate from a small forward operating base, no runway necessary, to support downrange base consolidation drawdown efforts with long-range options that guarantee oversight of target areas not accessible by tactical UAS.",
            9000000L,
            3000000L,
            7000000L,
            2300000L,
            12,
            1420,
            55);
    public Asset P1 = new Asset(
            "P-1",
            "",
            "Kawasaki",
            "The P-1, the successor to the P-3C, is a patrol aircraft used for prolonged and extensive surveillance and patrol over the seas around Japan.\n\nNewly-developed and manufactured domestically, including its airframe, engines, and patrol systems, the P-1 presents improved features compared to the P-3C: faster speed, longer range, and greater loading capacity made possible by the latest technologies. These features enable patrolling of the extensive seas around Japan for long hours.",
            0L,
            191646000L,
            0L,
            16700000L,
            89,
            4300,
            450);
    public Asset RQ58 = new Asset(
            "RQ-58",
            "Valkyrie",
            "Kratos",
            "The XQ-58A Valkyrie is a low cost, high performance unmanned air vehicle developed through an Air Force Research Laboratory partnership with Kratos Defense & Security Solutions, Inc. The XQ-58A was developed through low-cost procurement and designed to be significantly less expensive to operate than traditional piloted or unpiloted vehicles. It is the first example of a class of unmanned air vehicles developed through this cost- and time-saving process.\n\nThis low-maintenance, reusable vehicle is an example of an “attritable” aircraft designed to be used for several missions, but built at a cost that permits it to be a combat loss. This long range aircraft is designed for high speeds and agile maneuverability, enabling it to perform a variety of missions, including electromagnetic spectrum operations and kinetic attacks. It is runway-independent, offering operational flexibility.",
            88700000L,
            5090000L,
            14000000L,
            6600000L,
            24,
            4014,
            386);
    public Asset thunderhead = new Asset(
            "Thunderhead",
            "",
            "Raven Aerostar",
            "Thunderhead Balloon Systems have made long duration and navigational stratospheric missions a proven reality for commercial, scientific, and national security customers. By leveraging directional wind patterns at high altitudes, Raven Aerostar's Thunderhead Balloon Systems offer capabilities for navigation and persistence over areas of interest. With Thunderhead Balloon Systems, controlled flight and long duration capabilities can be planned and executed at a fraction of the cost and time of traditional stratospheric platforms.\n\nThunderhead Balloon Systems can be flown in constellations or individually to support a wide range of mission requirements. Affording users land-based and maritime launch options, applications are dynamic and diverse.",
            6000000L,
            2500000L,
            7000000L,
            300000L,
            2,
            17280,
            8);
    public final Asset[] assetList = {MQ4C, MQ9B, integrator, P1, RQ58, thunderhead};
    public long initialBudget = 2871976000L;
    public int getTotalUAV() {
        return MQ4C.UAVPurchased + MQ9B.UAVPurchased + integrator.UAVPurchased + P1.UAVPurchased + RQ58.UAVPurchased + thunderhead.UAVPurchased;
    }
    public int getTotalGCS() {
        return MQ4C.GCSPurchased + MQ9B.GCSPurchased + integrator.GCSPurchased + RQ58.GCSPurchased + thunderhead.GCSPurchased;
    }
    public long getTotalSpend() {
        return MQ4C.getTotalCost() + MQ9B.getTotalCost() + integrator.getTotalCost() + P1.getTotalCost() + RQ58.getTotalCost() + thunderhead.getTotalCost();
    }
    public long getOAndSSpend() {
        return MQ4C.getOAndSCost() + MQ9B.getOAndSCost() + integrator.getOAndSCost() + P1.getOAndSCost() + RQ58.getOAndSCost() + thunderhead.getOAndSCost();
    }
    public long getGroundInfrastructureSpend() {
        return MQ4C.getGroundInfrastructureCost() + MQ9B.getGroundInfrastructureCost() + integrator.getGroundInfrastructureCost() + P1.getGroundInfrastructureCost() + RQ58.getGroundInfrastructureCost() + thunderhead.getGroundInfrastructureCost();
    }
    public int getPersonnelRequirement() {
        return MQ4C.getPersonnelRequirement() + MQ9B.getPersonnelRequirement() + integrator.getPersonnelRequirement() + P1.getPersonnelRequirement() + RQ58.getPersonnelRequirement() + thunderhead.getPersonnelRequirement();
    }

}
public class PurchasingBackend {
    public static ShoppingCart cart = new ShoppingCart();
    public static NumberFormat yenFormat = NumberFormat.getCurrencyInstance(Locale.JAPAN);
    public static NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(Locale.US);
    public static final double yenPerDollar = 135.21;
    public static String priceFormat(long price) {
        double newPrice = price/1000000;
        if(newPrice < 10) return dollarFormat.format(price/1000000.0).replace(".00", "") + "M/" + yenFormat.format((price/1000000) * yenPerDollar).replace(".00", "") + "M";
        return dollarFormat.format(price/1000000).replace(".00", "") + "M/" + yenFormat.format((price/1000000) * yenPerDollar).replace(".00", "") + "M";
    }
}
