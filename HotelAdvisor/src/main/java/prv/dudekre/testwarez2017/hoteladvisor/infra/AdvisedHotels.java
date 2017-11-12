package prv.dudekre.testwarez2017.hoteladvisor.infra;

import prv.dudekre.testwarez2017.hoteladvisor.app.Hotel;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.hash;

public class AdvisedHotels {
    private final List<Hotel> availableHotels;

    public AdvisedHotels(List<Hotel> availableHotels) {
        this.availableHotels = availableHotels;
    }

    public List<Hotel> getAvailableHotels() {
        return availableHotels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvisedHotels other = (AdvisedHotels) o;

        return Objects.equals(this.availableHotels, other.availableHotels);
    }

    @Override
    public int hashCode() {
        return hash(availableHotels);
    }
}
