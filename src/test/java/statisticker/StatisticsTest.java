package statisticker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StatisticsTest 
{
    @Test
    public void reportsAverageMinMax()
    {
        Float[] numbers = {1.5f, 8.9f, 3.2f, 4.5f};
        List<Float> numberList = Arrays.asList(numbers);

        Statistics.Stats s = Statistics.getStatistics(numberList);

        float epsilon = 0.001f;
        assertEquals(s.average, 4.525f, epsilon);
        assertEquals(s.min, 1.5f, epsilon);
        assertEquals(s.max, 8.9f, epsilon);
    }
    @Test
    public void reportsNaNForEmptyInput()
    {
        List<Float> emptyList = new ArrayList<Float>();

        Statistics.Stats s = Statistics.getStatistics(emptyList);
        assertTrue(s.max.isNaN());
        assertTrue(s.min.isNaN());
        assertTrue(s.average.isNaN());
    }
    @Test
    public void reportsAlertsIfMaxIsMoreThanThreshold()
    {
        EmailAlert emailAlerter = new EmailAlert();
        LEDAlert ledAlerter = new LEDAlert();
        IAlerter alerters[] = {emailAlerter, ledAlerter};
        float maxThreshold = 10.2f;
        StatsChecker checker = new StatsChecker(maxThreshold, alerters);

        Float[] numbers = {11.5f, 6.9f, 7.5f, 6.6f};
        List<Float> numberList = Arrays.asList(numbers);
        checker.checkAndAlert(numberList);
        
        assertTrue(emailAlerter.emailSent);
        assertTrue(ledAlerter.ledGlows);
    }
}
