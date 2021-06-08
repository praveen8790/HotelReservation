import java.util.ArrayList;

public class HotelServices {
    ArrayList<Hotel> hotel = new ArrayList<>();
    public HotelServices(Integer customertype) {
        switch (customertype){
            case 1: // regular
              hotel.add(new Hotel("Lakewood",110,90,3));
              hotel.add(new Hotel("Bridgewood",160,60,4));
              hotel.add(new Hotel("Ridgewood",220,150,5));
              break;
            case 2: // loyalty
                hotel.add(new Hotel("Lakewood",80,80,3));
                hotel.add(new Hotel("Bridgewood",110,50,4));
                hotel.add(new Hotel("Ridgewood",100,40,5));
                break;
        }
    }


    @Override
    public String toString() {
        return "HotelServices{" +
                "hotel=" + hotel.toString()+
                '}';
    }
}
