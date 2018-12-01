package web.Entities.utilEntities;

import java.util.InvalidPropertiesFormatException;

public class FiveDayWeather {

    private int day;
    private double maxTmp;
    private double minTmp;
    private double pressure;
    private long humidity;
    private String state;
    private String dayInString;

    public FiveDayWeather() {
    }

    public FiveDayWeather(int day, double maxTmp, double minTmp, double pressure, long humidity, String state) {
        this.day = day;
        this.maxTmp = maxTmp;
        this.minTmp = minTmp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.state = state;
    }

    public String getDayInString() {
        return dayInString;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) throws InvalidPropertiesFormatException {
        switch (day) {
            case 1:
                this.dayInString = "Monday";
                break;
            case 2:
                this.dayInString = "Tuesday";
                break;
            case 3:
                this.dayInString = "Wednesday";
                break;
            case 4:
                this.dayInString = "Thursday";
                break;
            case 5:
                this.dayInString = "Friday";
                break;
            case 6:
                this.dayInString = "Saturday";
                break;
            case 7:
                this.dayInString = "Sunday";
                break;
            default:
                throw new InvalidPropertiesFormatException("No such day");
        }

        this.day = day;
    }

    public double getMaxTmp() {
        return maxTmp;
    }

    public void setMaxTmp(double maxTmp) {
        this.maxTmp = maxTmp;
    }

    public double getMinTmp() {
        return minTmp;
    }

    public void setMinTmp(double minTmp) {
        this.minTmp = minTmp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "FiveDayWeather{" +
                "day=" + day +
                ", maxTmp=" + maxTmp +
                ", minTmp=" + minTmp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", state='" + state + '\'' +
                '}';
    }
}
