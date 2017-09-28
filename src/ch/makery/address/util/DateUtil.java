package ch.makery.address.util;

import java.time.LocalDate;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	//Define uma vari�vel formatoData e a forma como quero que a data seja tratada
	private static final String formatoData = "dd.MM.yyyy";

	//agora eu defino uma vari�vel do tipo DateTimeFormatter e passo o par�metro do formato que defini
	private static final DateTimeFormatter formatarData = DateTimeFormatter.ofPattern(formatoData);

	//m�todo que verifica se a data foi informada, sen�o retorna null
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
