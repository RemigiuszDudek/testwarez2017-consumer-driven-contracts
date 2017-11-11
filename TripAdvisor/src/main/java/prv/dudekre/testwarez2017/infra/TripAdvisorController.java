package prv.dudekre.testwarez2017.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import prv.dudekre.testwarez2017.infra.hoteladvisor.AdvisedHotels;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class TripAdvisorController {
    private static final String PROTOCOL = "http://";
    private final RestTemplate restTemplate;
    @Value("${hotelAdvisor.url.host}") String host;
    @Value("${hotelAdvisor.url.port}") int port;

    @Autowired
    public TripAdvisorController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "advise", method = GET)
    public AdvisedTrip adviseTripTo(@RequestParam String location) {
        String url = PROTOCOL + host + ":" + port;
        AdvisedHotels advisedHotels = restTemplate
                .getForObject(url + "/hotels?location=" + location, AdvisedHotels.class);
        return new AdvisedTrip(location, Hotel.fromAdvisedHotels(advisedHotels));
    }
}
