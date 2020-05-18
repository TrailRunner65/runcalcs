package au.com.abstractcs.runcalcs.calcs;

import java.time.LocalTime;

public class PaceCalcs {
    public LocalTime getRacePace(Float distance, LocalTime totalTime, Unit resultUnits) {
        int seconds = totalTime.toSecondOfDay();
        float pace = (seconds / distance) * resultUnits.getUnitValue();
        return LocalTime.ofSecondOfDay((int)Math.ceil(pace));
    }

    public LocalTime getFinishTime(float distance, LocalTime pace, Unit resultUnits) {
        int seconds = pace.toSecondOfDay();
        float resultInSeconds = (distance * seconds) * resultUnits.getUnitValue();

        return LocalTime.ofSecondOfDay((int)resultInSeconds);
    }
}
