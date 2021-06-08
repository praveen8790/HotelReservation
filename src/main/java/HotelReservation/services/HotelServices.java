package HotelReservation.services;

import HotelReservation.entity.Hotel;
import HotelReservation.entity.Output;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class HotelServices {
    ArrayList<Hotel> hotel = new ArrayList<>();
    public HotelServices(Integer customertype) {
        switch (customertype) {
            case 1 -> { // regular
                hotel.add(new Hotel("Lakewood", 110, 90, 3));
                hotel.add(new Hotel("Bridgewood", 150, 50, 4));
                hotel.add(new Hotel("Ridgewood", 220, 150, 5));
            }
            case 2 -> { // loyalty
                hotel.add(new Hotel("Lakewood", 80, 80, 3));
                hotel.add(new Hotel("Bridgewood", 110, 50, 4));
                hotel.add(new Hotel("Ridgewood", 100, 40, 5));
            }
        }
    }
    public Output findCheapestHotel(ArrayList<Output> result){
        result.sort(Comparator.comparing(Output::getCost));
        return result.get(0);
    }
    public Output findCheapestAndBestRatedHotel(ArrayList<Output> result){
        result.sort(Comparator.comparing(Output::getCost).thenComparing(Comparator.comparing(Output::getRating).reversed()));
        return result.get(0);
    }
    public Output findHighRatedHotel(ArrayList<Output> result){
        result.sort(Comparator.comparing(Output::getRating).reversed());
        return result.get(0);
    }



    public ArrayList<Output> searchAndCalculateCostForHotels(ArrayList<Integer> datearray){
        ArrayList<Output> hotelcosts = new ArrayList<>();
         hotel.stream().forEach(hotel1 -> {
             Output hotel = new Output(hotel1.getHotelname(),hotel1.getRating());
             AtomicReference<Integer> wholecost= new AtomicReference<>(0);
             datearray.forEach(day->{

                 switch (day) {
                     case 1 -> //weekday
                             wholecost.set(wholecost.get() + hotel1.getNormal());
                     case 2 -> wholecost.set(wholecost.get() + hotel1.getWeekend());
                 }
             });
             hotel.setCost(wholecost.get());
            hotelcosts.add(hotel);
         });
        System.out.println(hotelcosts.toString());
         return hotelcosts;
    }
    public ArrayList<Integer> setDate(String sdate1, String sdate2) throws ParseException {
        SimpleDateFormat formatter=new SimpleDateFormat("ddMMMyyyy");
        Date date1 = formatter.parse(sdate1);
        Date date2 = formatter.parse(sdate2);
        int days = date2.compareTo(date1);
        ArrayList<Integer> day = new ArrayList<>();
        for(Date date = date1;date2.compareTo(date)>=0;date=HotelServices.findNextDay(date))
            day.add(this.dayCalculator(date));
        return day;
    }
    private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;

    private static Date findNextDay(Date date)
    {
        return new Date(date.getTime() + MILLIS_IN_A_DAY);
    }

    public Integer dayCalculator(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek=cal.get(Calendar.DAY_OF_WEEK);
        if(dayofweek != 1 && dayofweek != 7)
            return 1;
        else
            return 2;
    }

    @Override
    public String toString() {
        return "HotelReservation.services.HotelServices{" +
                "hotel=" + hotel.toString()+
                '}';
    }
}
