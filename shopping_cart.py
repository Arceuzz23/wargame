class ShoppingCart(object):
    """ generated source for class ShoppingCart """
    MQ4C = Asset("MQ-4C", "Triton", "Northrop Grumman", "Northrop Grumman\u2019s MQ-4C Triton unmanned aircraft system (UAS) provides real-time ISR&T over vast ocean and coastal regions.\n\nBased on the proven Global Hawk UAS, Triton\u2019s autonomous operations are supported by land-based command and control mission planners and sensor operators. Triton will be equipped with a unique and robust mission sensor suite that provides 360-degree coverage on all sensors, providing maritime domain awareness for the U.S. Navy.\n\nTriton also incorporates a reinforced airframe, for increased internal payload, and wing for hail, bird strike, and gust load protection, along with de-icing and lightning protection systems.", 450000000L, 150000000L, 25000000L, 27500000L, 83, 8200, 270)
    MQ9B = Asset("MQ-9B", "SeaGuardian", "GA Aeronautical", "MQ-9B SeaGuardian is the maritime-focused sibling of the SkyGuardian remotely piloted aircraft system (RPAS) that has been missionized using \u201cbolt-on/bolt-off\u201d maritime sensors. SeaGuardian is designed to fly over the horizon via SATCOM for up to 30 hours (depending on configuration) in all types of weather and safely integrate into civil airspace, enabling joint forces and civil authorities to deliver real-time situational awareness.\n\nIn addition to its Lynx Multi-Mode Radar, advanced electro-optical/infrared sensor, automatic takeoff and landing capability, and the same 79 ft (24m) wingspan as SkyGuardian, SeaGuardian includes a centerline wide-area maritime radar mission kit, automatic identification system, and an optional self-contained anti-submarine warfare (ASW) mission kit.", 576400000L, 26446290L, 15000000L, 9900000L, 36, 3887, 169)
    integrator = Asset("Integrator ER", "", "Boeing Insitu", "The latest variant of the Integrator unmanned aircraft system (UAS) builds upon more than one million hours of operational experience and innovation to deliver Group 4 and 5 capabilities in a Group 3 UAS. With added satellite-enabled beyond line of sight (SATCOM BLOS) communications, the Integrator UAS delivers extended ranges to reduce logistical challenges and increase safety for fielded personnel.\n\nIntegrator ER can operate from a small forward operating base, no runway necessary, to support downrange base consolidation drawdown efforts with long-range options that guarantee oversight of target areas not accessible by tactical UAS.", 9000000L, 3000000L, 7000000L, 2300000L, 12, 1420, 55)
    P1 = Asset("P-1", "", "Kawasaki", "The P-1, the successor to the P-3C, is a patrol aircraft used for prolonged and extensive surveillance and patrol over the seas around Japan.\n\nNewly-developed and manufactured domestically, including its airframe, engines, and patrol systems, the P-1 presents improved features compared to the P-3C: faster speed, longer range, and greater loading capacity made possible by the latest technologies. These features enable patrolling of the extensive seas around Japan for long hours.", 0L, 191646000L, 0L, 16700000L, 89, 4300, 450)
    RQ58 = Asset("RQ-58", "Valkyrie", "Kratos", "The XQ-58A Valkyrie is a low cost, high performance unmanned air vehicle developed through an Air Force Research Laboratory partnership with Kratos Defense & Security Solutions, Inc. The XQ-58A was developed through low-cost procurement and designed to be significantly less expensive to operate than traditional piloted or unpiloted vehicles. It is the first example of a class of unmanned air vehicles developed through this cost- and time-saving process.\n\nThis low-maintenance, reusable vehicle is an example of an \u201cattritable\u201d aircraft designed to be used for several missions, but built at a cost that permits it to be a combat loss. This long range aircraft is designed for high speeds and agile maneuverability, enabling it to perform a variety of missions, including electromagnetic spectrum operations and kinetic attacks. It is runway-independent, offering operational flexibility.", 88700000L, 5090000L, 14000000L, 6600000L, 24, 4014, 386)
    thunderhead = Asset("Thunderhead", "", "Raven Aerostar", "Thunderhead Balloon Systems have made long duration and navigational stratospheric missions a proven reality for commercial, scientific, and national security customers. By leveraging directional wind patterns at high altitudes, Raven Aerostar's Thunderhead Balloon Systems offer capabilities for navigation and persistence over areas of interest. With Thunderhead Balloon Systems, controlled flight and long duration capabilities can be planned and executed at a fraction of the cost and time of traditional stratospheric platforms.\n\nThunderhead Balloon Systems can be flown in constellations or individually to support a wide range of mission requirements. Affording users land-based and maritime launch options, applications are dynamic and diverse.", 6000000L, 2500000L, 7000000L, 300000L, 2, 17280, 8)
    assetList = []
    initialBudget = long()

    def __init__(self):
        """ generated source for method __init__ """
        self.assetList = [None]*
        self.initialBudget = 2871976000L

    def getTotalUAV(self):
        """ generated source for method getTotalUAV """
        return self.MQ4C.UAVPurchased + self.MQ9B.UAVPurchased + self.integrator.UAVPurchased + self.P1.UAVPurchased + self.RQ58.UAVPurchased + self.thunderhead.UAVPurchased

    def getTotalGCS(self):
        """ generated source for method getTotalGCS """
        return self.MQ4C.GCSPurchased + self.MQ9B.GCSPurchased + self.integrator.GCSPurchased + self.RQ58.GCSPurchased + self.thunderhead.GCSPurchased

    def getTotalSpend(self):
        """ generated source for method getTotalSpend """
        return self.MQ4C.getTotalCost() + self.MQ9B.getTotalCost() + self.integrator.getTotalCost() + self.P1.getTotalCost() + self.RQ58.getTotalCost() + self.thunderhead.getTotalCost()

    def getOAndSSpend(self):
        """ generated source for method getOAndSSpend """
        return self.MQ4C.getOAndSCost() + self.MQ9B.getOAndSCost() + self.integrator.getOAndSCost() + self.P1.getOAndSCost() + self.RQ58.getOAndSCost() + self.thunderhead.getOAndSCost()

    def getGroundInfrastructureSpend(self):
        """ generated source for method getGroundInfrastructureSpend """
        return self.MQ4C.getGroundInfrastructureCost() + self.MQ9B.getGroundInfrastructureCost() + self.integrator.getGroundInfrastructureCost() + self.P1.getGroundInfrastructureCost() + self.RQ58.getGroundInfrastructureCost() + self.thunderhead.getGroundInfrastructureCost()

    def getPersonnelRequirement(self):
        """ generated source for method getPersonnelRequirement """
        return self.MQ4C.getPersonnelRequirement() + self.MQ9B.getPersonnelRequirement() + self.integrator.getPersonnelRequirement() + self.P1.getPersonnelRequirement() + self.RQ58.getPersonnelRequirement() + self.thunderhead.getPersonnelRequirement()

