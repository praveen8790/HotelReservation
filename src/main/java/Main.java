import HotelReservation.contoller.Controller;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        Controller controller =new Controller();
        System.out.println(controller.control(1,"10Sep2020","11Sep2020",1).toString());
    }
}
