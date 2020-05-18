package au.com.abstractcs.runcalcs.calcs;

import java.time.LocalTime;

public class PaceCalcs {
    public LocalTime getRacePace(Float distance, LocalTime totalTime, Unit totalTimeUnits, Unit resultUnits) {
        int seconds = totalTime.toSecondOfDay();

        float resultInSeconds;

        if (!totalTimeUnits.equals(resultUnits)) {
            resultInSeconds = (seconds / distance) * resultUnits.getUnitValue();
        } else {
            resultInSeconds = seconds / distance;
        }
        return LocalTime.ofSecondOfDay(Math.round(resultInSeconds));
    }

    public LocalTime getFinishTime(float distance, LocalTime pace, Unit paceUnits, Unit distanceUnits) {
        int seconds = pace.toSecondOfDay();

        float resultInSeconds;

        if (!paceUnits.equals(distanceUnits)) {
            resultInSeconds = (distance * seconds) * distanceUnits.getUnitValue();
        } else {
            resultInSeconds = distance * seconds;
        }

        return LocalTime.ofSecondOfDay(Math.round(resultInSeconds));
    }
}
