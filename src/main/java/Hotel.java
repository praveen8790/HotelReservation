public class Hotel {
    private final String hotelname;
    private Integer rating;
    private final Integer normalday;
    private final Integer weekend;

    public Hotel(String hotelname, Integer normal,Integer weekend, Integer rating) {
        this.hotelname = hotelname;
        this.rating = rating;
        this.weekend = weekend;
        this.normalday = normal;
    }
    public String getHotelname() {
        return hotelname;
    }
    public Integer getRating() {
        return rating;
    }
    public Integer getWeekend() {
        return weekend;
    }
    public Integer getNormal() {
        return normalday;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    @Override
    public String toString() {
        return "Hotel{" +
                "hotelname='" + hotelname + '\'' +
                ", rating=" + rating +
                ", normalday=" + normalday +
                ", weekend=" + weekend +
                '}'+'\n';
    }
}
