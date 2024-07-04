package date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class ManipulandoDatasComCalendarJava8_Menos {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date d = Date.from(Instant.parse("2024-05-03T15:19:07Z"));
		
		System.out.println(sdf.format(d));
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		int minutos = cal.get(Calendar.MINUTE);
		int meses = 1 + cal.get(Calendar.MONTH);
		// Month começa em Janeiro 0, por isso + 1;
		
		System.out.println("Minutos: " + minutos);
		System.out.println("Meses: " + meses);
		
		// [Ajustar o GMT-3]
				//cal.add(Calendar.HOUR_OF_DAY, 4);
				//d = cal.getTime();
				//System.out.println(sdf.format(d));
	}

}
