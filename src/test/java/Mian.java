import HotelReservation.contoller.Controller;
import HotelReservation.entity.Output;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class Mian {
    @Test
    public void test() throws ParseException {
        Controller controller = new Controller();
        Output test = new Output("lakewood",3);
        test.setCost(220);
        Assertions.assertTrue(test.equals(controller.control(1,"10Sep2020","11Sep2020",1)));
    }
}
