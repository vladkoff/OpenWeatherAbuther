package web.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private double temperature;
    private double pressure;
    private long humidity;
    private String state;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    public Weather(double temperature, double pressure, long humidity, String state, Date date, City city) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.state = state;
        this.date = date;
        this.city = city;
    }

    public Weather() {
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
