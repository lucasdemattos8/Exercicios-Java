package date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ConvertendoDataHoraParaTexto {

	public static void main(String[] args) {

		LocalDate d01 = LocalDate.parse("2024-05-02");                  // D04
		LocalDateTime d02 = LocalDateTime.parse("2024-05-02T10:01:20"); // D05
		Instant d03 = Instant.parse("2024-05-02T01:30:26Z");            // D06
		
		LocalDate r1 = LocalDate.ofInstant(d03, ZoneId.systemDefault());
		LocalDate r2 = LocalDate.ofInstant(d03, ZoneId.of("Portugal"));
		LocalDateTime r3 = LocalDateTime.ofInstant(d03, ZoneId.systemDefault());
		LocalDateTime r4 = LocalDateTime.ofInstant(d03, ZoneId.of("Portugal"));
		
		System.out.println("r1 = " + r1);
		System.out.println("r2 = " + r2);
		System.out.println("r3 = " + r3);
		System.out.println("r4 = " + r4);
		
		System.out.println("d04 dia = " + d01.getDayOfMonth());
		System.out.println("d04 mês = " + d01.getMonthValue());
		System.out.println("d04 ano = " + d01.getYear());
		
		System.out.println("d05 hora  = " + d02.getHour());
		System.out.println("d05 minutos  = " + d02.getMinute());


		
	}

}
