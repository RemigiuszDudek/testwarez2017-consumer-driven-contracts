package prv.dudekre.testwarez2017.infra;

import prv.dudekre.testwarez2017.infra.hoteladvisor.AdvisedHotels;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Hotel {
    private final int id;
    private final String name;
    private final String address;

    public Hotel(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public static List<Hotel> fromAdvisedHotels(AdvisedHotels advisedHotels) {
        return advisedHotels.getAvailableHotels().stream()
                .map((hotel) -> new Hotel(hotel.getId(), hotel.getName(), hotel.getAddress()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel other = (Hotel) o;

        return Objects.equals(this.id, other.id)
                && Objects.equals(this.name, other.name)
                && Objects.equals(this.address, other.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
