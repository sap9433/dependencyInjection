
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class ExpediaJsonFormatterTest {
    @Test
    public void checkPrintFormat() throws PrintingException {
        Booking booking = new Booking(21   , "My Booking", Arrays.asList("Pass", "Secret"));
        ExpediaJsonFormatter customFormatter = new ExpediaJsonFormatter();
        String jsonString = customFormatter.expediaJsonString(booking);
        assertEquals(
                "{\"description\":\"My Booking\",\"bookingId\":\"21\"}",
                jsonString);
    }
}
