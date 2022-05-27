
import java.time.*;
import java.util.Date;

public class MoskowTime {

    public static void main(String[] args) {
        MoskowTime moskowTime = new MoskowTime();
        System.out.println(ZonedDateTime.now(ZoneId.of("GMT+3")));
        Date date = Date.from(2001, 6);
        //System.out.println(date.plusDays(4));

        LocalTime time = LocalTime.of(16, 30);
        Duration duration = Duration.ofMinutes(15);
        //LocalTime newTime = time.withHour(14).plusMinutes(15);;
        System.out.println(time);
        System.out.println(time.plus(duration).isAfter(LocalTime.now()));


        Instant instant = date.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime.toLocalTime());
    }
}





