package ch.makery.address.util;

import java.time.LocalDate;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	//Define uma variável formatoData e a forma como quero que a data seja tratada
	private static final String formatoData = "dd.MM.yyyy";

	//agora eu defino uma variável do tipo DateTimeFormatter e passo o parâmetro do formato que defini
	private static final DateTimeFormatter formatarData = DateTimeFormatter.ofPattern(formatoData);

	//método que verifica se a data foi informada, senão retorna null
	public static String format(LocalDate date){
		if (date == null){
			return null;
		}
		return formatarData.format(date);
	}


	//Tenta realizar a troca da data por String
	public static LocalDate parse(String stringData){
		try {
			return formatarData.parse(stringData, LocalDate::from );

		} catch (DateTimeException e) {
			return null;
		}
	}

	public static boolean testaData(String stringData){
		return DateUtil.parse(stringData) != null;
	}

}
