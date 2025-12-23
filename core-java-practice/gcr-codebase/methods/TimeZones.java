import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZones {
	
	public static void main(String[] args) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
		ZonedDateTime gmt = ZonedDateTime.now(ZoneId.of("GMT"));
		ZonedDateTime ist = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		ZonedDateTime pst = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
		
		System.out.println("current time in GMT is : " + gmt.format(fmt));
		System.out.println("current time in IST is : " + ist.format(fmt));
		System.out.println("current time in PST is : " + pst.format(fmt));
	}

}