package au.com.abstractcs.runcalcs.calcs;

public enum Unit {
    METRIC(1.0f),
    IMPERIAL(1.6f);

    private float unitValue;

    Unit(float value) {
        unitValue = value;
    }

    float getUnitValue() {
        return unitValue;
    }
}
