/**
 *  Proyecto del primer parcial
 */

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
  public static void main(String[] args) {
    int hour, minute, second;
    Calendar cal = GregorianCalendar.getInstance();

    // Set time
    hour = cal.get(Calendar.HOUR);
    minute = cal.get(Calendar.MINUTE);
    second = cal.get(Calendar.SECOND);

    // Create clock
    MyClock clock = new MyClock("Reloj", 600, 600);
    clock.setTime(hour, minute, second);
    clock.visible(true);
  }
}
