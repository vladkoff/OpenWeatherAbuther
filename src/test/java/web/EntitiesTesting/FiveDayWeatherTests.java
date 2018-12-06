package web.EntitiesTesting;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import web.Entities.utilEntities.FiveDayWeather;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FiveDayWeatherTests {

    private FiveDayWeather fiveDayWeather;

    @Test
    public void init() throws Exception {
        fiveDayWeather = new FiveDayWeather();

        assertThat(fiveDayWeather).isNotNull();
    }

    @Test
    public void checkDayNumberToNameConversion() throws Exception {
        fiveDayWeather = new FiveDayWeather();

        fiveDayWeather.setDay(1);
        assertThat(fiveDayWeather.getDayInString()).contains("Monday");
    }

}
