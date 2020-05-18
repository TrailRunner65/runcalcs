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
        LocalTime result = paceCalcs.getRacePace(distance, targetTime, Unit.METRIC);

        assertEquals(0, result.getHour());
        assertEquals(4, result.getMinute());
        assertEquals(0, result.getSecond());
    }

    @Test
    public void shouldCalculateRacePaceForHalfMarathonImperial() {
        final float distance = 13.1f; // 13.1 miles
        final LocalTime targetTime = LocalTime.of(1, 15, 0);  // 40 min

        LocalTime result = paceCalcs.getRacePace(distance, targetTime, Unit.IMPERIAL);

        assertEquals(0, result.getHour());
        assertEquals(5, result.getMinute());
        assertEquals(44, result.getSecond());
    }

    @Test
    public void shouldCalculateFinishTimeFor10k() {
        final float distance = 10.0f; // 10k
        final int pace = 4 * 60; // 4 min per km
        LocalTime result = paceCalcs.getFinishTime(distance, LocalTime.ofSecondOfDay(pace), Unit.METRIC);

        assertEquals(0, result.getHour());
        assertEquals(40, result.getMinute());
        assertEquals(0, result.getSecond());
    }

    @Test
    public void shouldCalculateFinishTimeFor13Miles() {
        final float distance = 13.1f;
        LocalTime pace = LocalTime.of(0, 5, 44);
        LocalTime result = paceCalcs.getFinishTime(distance, pace, Unit.IMPERIAL);

        assertEquals(1, result.getHour());
        assertEquals(15, result.getMinute());
        assertEquals(6, result.getSecond());
    }
}