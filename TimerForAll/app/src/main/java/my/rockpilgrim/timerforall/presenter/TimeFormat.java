package my.rockpilgrim.timerforall.presenter;

public class TimeFormat {


    public static String getTime(long millis) {
        float time = ((float) millis) / 1000;
        if (time >= 10) {
            return String.format("%.0f", time);
        } else if (time < 10) {
            return (String.format("%.1f", time));
        } else {
            return "0.0";
        }
    }
}
