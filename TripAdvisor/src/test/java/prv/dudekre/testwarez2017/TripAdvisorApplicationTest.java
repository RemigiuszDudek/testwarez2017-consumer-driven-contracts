package prv.dudekre.testwarez2017;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;
import prv.dudekre.testwarez2017.infra.AdvisedTrip;
import prv.dudekre.testwarez2017.infra.Hotel;
import prv.dudekre.testwarez2017.infra.TripAdvisorController;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static prv.dudekre.testwarez2017.TripAdvisorApplicationTest.HOTEL_ADVISORPORT;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = TripAdvisorApplication.class,
        properties = {"hotelAdvisor.url.host=localhost", "hotelAdvisor.url.port=" + HOTEL_ADVISORPORT})
@AutoConfigureStubRunner(
        ids = "prv.dudekre.testwarez2017:HotelAdvisorContract:1.0-SNAPSHOT:stubs:" + HOTEL_ADVISORPORT,
        workOffline = true,
        stubsPerConsumer = true,
        consumerName = "tripAdvisor"
)
public class TripAdvisorApplicationTest {
    public final static String HOTEL_ADVISORPORT = "7272";
    @Autowired TripAdvisorController tripAdvisorController;

    @Test
    public void shouldAdviseTripsToKrakow() {
        //given
        String location = "Kraków";
        AdvisedTrip expectedAdvice = new AdvisedTrip(location, asList(
                new Hotel(1, "Sheraton", "ul. Jana Nowaka 1"),
                new Hotel(2, "Novotel", "ul. Marii Konopnickej 2")
        ));
        //when
        AdvisedTrip advisedTrip = tripAdvisorController.adviseTripTo(location);
        //then
        assertThat(advisedTrip).isEqualTo(expectedAdvice);
    }
}
