package HotelReservation.contoller;

import HotelReservation.entity.Hotel;
import HotelReservation.entity.Output;
import HotelReservation.services.HotelServices;

import java.text.ParseException;

public class Controller {
    public Output control(Integer customertype,String date1,String date2,Integer searchtype) throws ParseException {
        HotelServices query = new HotelServices(customertype);
        return switch (searchtype) {
            case 1 -> //for  cheapest hotel
                    query.findCheapestHotel(query.searchAndCalculateCostForHotels(query.setDate(date1, date2)));
            case 2 -> // for cheapest and high rated hotel
                    query.findCheapestAndBestRatedHotel(query.searchAndCalculateCostForHotels(query.setDate(date1, date2)));
            case 3 -> // for high rates hotel
                    query.findHighRatedHotel(query.searchAndCalculateCostForHotels(query.setDate(date1, date2)));
            default -> //return cheapest hotel
                    query.findCheapestHotel(query.searchAndCalculateCostForHotels(query.setDate(date1, date2)));
        };
    }
}
