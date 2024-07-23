import locale

class ShoppingCart:
    # Assuming ShoppingCart class is defined elsewhere
    pass

class PurchasingBackend:
    cart = ShoppingCart()
    yen_format = None
    dollar_format = None
    yen_per_dollar = 135.21

    def __init__(self):
        pass

    @staticmethod
    def price_format(price):
        new_price = price / 1000000.0
        if new_price < 10.0:
            return f"{PurchasingBackend.dollar_format.format(price / 1000000.0).replace('.00', '')}M/{PurchasingBackend.yen_format.format((price / 1000000.0) * 135.21).replace('.00', '')}M"
        else:
            return f"{PurchasingBackend.dollar_format.format(price / 1000000.0).replace('.00', '')}M/{PurchasingBackend.yen_format.format((price / 1000000.0) * 135.21).replace('.00', '')}M"

# Static block equivalent in Python
locale.setlocale(locale.LC_ALL, 'ja_JP.UTF-8')
PurchasingBackend.yen_format = locale.currency
locale.setlocale(locale.LC_ALL, 'en_US.UTF-8')
PurchasingBackend.dollar_format = locale.currency

