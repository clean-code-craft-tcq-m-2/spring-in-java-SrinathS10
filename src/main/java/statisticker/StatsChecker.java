package statisticker;

import java.util.List;

public class StatsChecker {

    float maxThreshold;
    IAlerter[] alerts;

    public StatsChecker(float maxThreshold, IAlerter[] alerts){
        this.maxThreshold = maxThreshold;
        this.alerts = alerts;
    }

    public void checkAndAlert(List<Float> numbers){
        Statistics.Stats s = Statistics.getStatistics(numbers);
        if(s.max > this.maxThreshold) {
            for(IAlerter alert : this.alerts){
                alert.trigger();
            }
        }
    }
}
