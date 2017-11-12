package prv.dudekre.testwarez2017.hoteladvisor.app;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("!contractTest")
public class HotelsService {
    public List<Hotel> adviseHotels(String location) {
        return null;
    }
}
