package au.com.abstractcs.runcalcs.calcs;

public enum Unit {
    IMPERIAL(1.60934f),
    METRIC(0.621371f);

    private float unitValue;

    Unit(float value) {
        unitValue = value;
    }

    float getUnitValue() {
        return unitValue;
    }
}
