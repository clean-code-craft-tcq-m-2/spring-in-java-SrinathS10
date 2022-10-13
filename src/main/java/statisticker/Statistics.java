package statisticker;

import java.util.List;

public class Statistics 
{   public static class Stats {
        public Float max;
        public Float min;
        public Float average;
    }
    public static Stats getStatistics(List<Float> numbers) {
        //implement the computation of statistics here
        Stats stats = new Stats();
        final int n = numbers.size();
        if (n >= 1) {
            float sum = 0.0f;
            sum = stats.max = stats.min = numbers.get(0);
            for (int i=1; i<n; i++){
                float num = numbers.get(i);
                if (num>stats.max){
                    stats.max = num;
                }
                if(num<stats.min) {
                    stats.min = num;
                }
                sum = sum + num;
            }
            stats.average =  sum/n;
        }
        else {
            stats.max = stats.min = stats.average = Float.NaN;
        }
        return stats;
    }

}
