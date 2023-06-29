package libreria;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ayudantes {
	
	public static Date StringToDateExample(String dateString) {
		String pattern = "dd/MM/yyyy";
		Date date = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			date = dateFormat.parse(dateString);
		} catch (Exception e) {
			System.out.println(e);
		}
		return date;
	}
}
