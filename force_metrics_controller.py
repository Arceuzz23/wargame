import matplotlib.pyplot as plt

class ForceMetricsController:
    def __init__(self):
        self.area_search_area_chart = plt.figure()
        self.area_search_assets_chart = plt.figure()
        self.focus_search_area_chart = plt.figure()
        self.focus_search_assets_chart = plt.figure()

    def populate(self):
        self.populate_area_search_area_chart()
        self.populate_area_search_assets_chart()
        self.populate_focus_search_area_chart()
        self.populate_focus_search_assets_chart()

    def populate_area_search_area_chart(self):
        self.area_search_area_chart.clf()
        radii = [100, 500, 1000, 1500]
        for r in radii:
            series_name = f"{r}nm"
            x_data = []
            y_data = []
            for asset in PurchasingBackend.cart.asset_list:
                area = asset.get_area_search_area(r)
                if area >= 0:
                    x_data.append(asset.name)
                    y_data.append(area)
            plt.bar(x_data, y_data, label=series_name)
        plt.legend()
        plt.title("Area Search Area Chart")
        plt.show()

    def populate_area_search_assets_chart(self):
        self.area_search_assets_chart.clf()
        radii = [100, 500, 1000, 1500]
        for r in radii:
            series_name = f"{r}nm"
            x_data = []
            y_data = []
            for asset in PurchasingBackend.cart.asset_list:
                assets = asset.get_area_search_assets(r)
                if assets >= 0:
                    x_data.append(asset.name)
                    y_data.append(assets)
            plt.bar(x_data, y_data, label=series_name)
        plt.legend()
        plt.title("Area Search Assets Chart")
        plt.show()

    def populate_focus_search_area_chart(self):
        self.focus_search_area_chart.clf()
        radii = [100, 500, 1000, 1500]
        for r in radii:
            series_name = f"{r}nm"
            x_data = []
            y_data = []
            for asset in PurchasingBackend.cart.asset_list:
                area = asset.get_focus_search_area(r)
                if area >= 0.0:
                    x_data.append(asset.name)
                    y_data.append(area)
            plt.bar(x_data, y_data, label=series_name)
        plt.legend()
        plt.title("Focus Search Area Chart")
        plt.show()

    def populate_focus_search_assets_chart(self):
        self.focus_search_assets_chart.clf()
        radii = [100, 500, 1000, 1500]
        for r in radii:
            series_name = f"{r}nm"
            x_data = []
            y_data = []
            for asset in PurchasingBackend.cart.asset_list:
                assets = asset.get_focus_search_assets(r)
                if assets >= 0:
                    x_data.append(asset.name)
                    y_data.append(assets)
            plt.bar(x_data, y_data, label=series_name)
        plt.legend()
        plt.title("Focus Search Assets Chart")
        plt.show()


