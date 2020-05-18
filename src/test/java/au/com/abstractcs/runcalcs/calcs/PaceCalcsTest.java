package au.com.abstractcs.runcalcs.calcs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class PaceCalcsTest {

    private PaceCalcs paceCalcs = new PaceCalcs();

    @Test
    public void shouldCalculateRacePaceFor10k() {
        final float distance = 10.0f; // 10k
        final LocalTime targetTime = LocalTime.of(0, 40, 0);  // 40 min
        LocalTime result = paceCalcs.getRacePace(distance, targetTime, Unit.METRIC, Unit.METRIC);

        assertEquals(0, result.getHour());
        assertEquals(4, result.getMinute());
        assertEquals(0, result.getSecond());
    }

    @Test
    public void shouldCalculateRacePaceForHalfMarathonImperial() {
        final float distance = 13.1f; // 13.1 miles
        final LocalTime targetTime = LocalTime.of(1, 15, 0);  // 40 min

        LocalTime result = paceCalcs.getRacePace(distance, targetTime, Unit.IMPERIAL, Unit.IMPERIAL);

        assertEquals(0, result.getHour());
        assertEquals(5, result.getMinute());
        assertEquals(44, result.getSecond());
    }

    @Test
    public void shouldCalculateRacePaceForHalfMarathonImperialToMetric() {
        final float distance = 13.1f; // 13.1 miles
        final LocalTime targetTime = LocalTime.of(1, 15, 0);  // 40 min

        LocalTime result = paceCalcs.getRacePace(distance, targetTime, Unit.IMPERIAL, Unit.METRIC);

        assertEquals(0, result.getHour());
        assertEquals(3, result.getMinute());
        assertEquals(33, result.getSecond());
    }

    @Test
    public void shouldCalculateRacePaceForHalfMarathonMetricToImperial() {
        final float distance = 21.1f;
        final LocalTime targetTime = LocalTime.of(1, 15, 0); 

        LocalTime result = paceCalcs.getRacePace(distance, targetTime, Unit.METRIC, Unit.IMPERIAL);

        assertEquals(0, result.getHour());
        assertEquals(5, result.getMinute());
        assertEquals(43, result.getSecond());
    }

    @Test
    public void shouldCalculateFinishTimeFor10k() {
        final float distance = 10.0f; // 10k
        final int pace = 4 * 60; // 4 min per km
        LocalTime result = paceCalcs.getFinishTime(distance, LocalTime.ofSecondOfDay(pace), Unit.METRIC, Unit.METRIC);

        assertEquals(0, result.getHour());
        assertEquals(40, result.getMinute());
        assertEquals(0, result.getSecond());
    }

    @Test
    public void shouldCalculateFinishTimeFor13MilestoMetric() {
        final float distance = 13.1f;
        LocalTime pace = LocalTime.of(0, 4, 0);
        LocalTime result = paceCalcs.getFinishTime(distance, pace, Unit.METRIC, Unit.IMPERIAL);

        assertEquals(1, result.getHour());
        assertEquals(24, result.getMinute());
        assertEquals(20, result.getSecond());
    }

    @Test
    public void shouldCalculateFinishTimeFor21kmToImperial() {
        final float distance = 21.1f;
        LocalTime pace = LocalTime.of(0, 5, 33);
        LocalTime result = paceCalcs.getFinishTime(distance, pace, Unit.IMPERIAL, Unit.METRIC);

        assertEquals(1, result.getHour());
        assertEquals(12, result.getMinute());
        assertEquals(46, result.getSecond());
    }
}