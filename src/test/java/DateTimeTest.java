import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DateTimeTest {

   hello.DateTime var = new hello.DateTime();

   @Test
   public void testPrintMessage() {
      GregorianCalendar time = new GregorianCalendar();
      int hour = time.get(Calendar.HOUR_OF_DAY);
      assertEquals(hour, var.dateTime());

      
   }
}