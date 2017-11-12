package prv.dudekre.testwarez2017.hoteladvisor.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prv.dudekre.testwarez2017.hoteladvisor.app.Hotel;
import prv.dudekre.testwarez2017.hoteladvisor.app.HotelsService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class HotelAdvisorController {
    private final HotelsService hotelsService;

    @Autowired
    public HotelAdvisorController(HotelsService hotelsService) {
        this.hotelsService = hotelsService;
    }

    @RequestMapping(value = "/hotels", method = GET)
    public AdvisedHotels hotels(@RequestParam String location) {
        List<Hotel> hotels = hotelsService.adviseHotels(location);
        return new AdvisedHotels(hotels);
    }
}
