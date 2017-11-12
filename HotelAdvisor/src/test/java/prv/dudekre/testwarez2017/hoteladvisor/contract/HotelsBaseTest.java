package prv.dudekre.testwarez2017.hoteladvisor.contract;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import prv.dudekre.testwarez2017.hoteladvisor.HotelAdvisorApplication;
import prv.dudekre.testwarez2017.hoteladvisor.app.Hotel;
import prv.dudekre.testwarez2017.hoteladvisor.app.HotelsService;
import prv.dudekre.testwarez2017.hoteladvisor.infra.HotelAdvisorController;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HotelAdvisorApplication.class, HotelsBaseTest.class})
@Profile("contractTest")
@ActiveProfiles("contractTest")
@Configuration
public abstract class HotelsBaseTest {
    @Autowired HotelAdvisorController hotelAdvisorController;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(hotelAdvisorController);
    }

    @Bean
    public HotelsService hotelsServiceForTripAdvisor() {
        return new HotelsService() {
            @Override
            public List<Hotel> adviseHotels(String location) {
                return Arrays.asList(
                        new Hotel(1, "Sheraton", "ul. Jana Nowaka 1"),
                        new Hotel(2, "Novotel", "ul. Marii Konopnickej 2")
                );
            }
        };
    }
}
