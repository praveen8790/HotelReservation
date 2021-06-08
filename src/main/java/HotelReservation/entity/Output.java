package HotelReservation.entity;

import java.util.Objects;

public class Output {
    String hotelname;
    Integer rating;
    Integer cost;

    public Output(String hotelname, Integer rating) {
        this.hotelname = hotelname;
        this.rating = rating;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Output{" +
                "hotelname='" + hotelname + '\'' +
                ", rating=" + rating +
                ", cost=" + cost +
                '}';
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Output output = (Output) o;
        return Objects.equals(hotelname.toLowerCase(), output.hotelname.toLowerCase()) && Objects.equals(rating, output.rating) && Objects.equals(cost, output.cost);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
