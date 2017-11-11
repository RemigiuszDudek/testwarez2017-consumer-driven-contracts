package prv.dudekre.testwarez2017.infra;

import java.util.List;
import java.util.Objects;

public class AdvisedTrip {
    private final String location;
    private final List<Hotel> advisedHotels;

    public AdvisedTrip(String location, List<Hotel> advisedHotels) {
        this.location = location;
        this.advisedHotels = advisedHotels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvisedTrip other = (AdvisedTrip) o;

        return Objects.equals(this.location, other.location)
                && Objects.equals(this.advisedHotels, other.advisedHotels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, advisedHotels);
    }

    @Override
    public String toString() {
        return "AdvisedTrip{" +
                "location='" + location + '\'' +
                ", advisedHotels=" + advisedHotels +
                '}';
    }
}
