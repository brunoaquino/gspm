package br.com.jsbse.gspm.mvc.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class UtilJava8 {
	
	
	public static LocalDate getLocalDate(Date date){
		Instant instant = Instant.ofEpochMilli(date.getTime());
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	}

	public static Date getDate(LocalDate date){
		return  Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public static String getMes(Date date){
		LocalDate localDate = getLocalDate(date);
		Locale pt = new Locale("pt");
		Month month = localDate.getMonth();
		return month.getDisplayName(TextStyle.FULL, pt);
	}

	public static String getMes(LocalDate localDate){
		Locale pt = new Locale("pt");
		Month month = localDate.getMonth();
		return month.getDisplayName(TextStyle.FULL, pt);
	}

	public static LocalDate getUltimoDiaMes(LocalDate data) {
		LocalDate dt = data.plusMonths(1);
		LocalDate dateFim = LocalDate.of(dt.getYear(), dt.getMonth(), 1);
		return dateFim.minusDays(1);
	}

	public static LocalDate getPrimeiraDiaMes(LocalDate data) {
		return  LocalDate.of(data.getYear(), data.getMonth(), 1);
	}
	
	public static long getDiferencaEntreDatasEmDias(Date dataAnterior, Date dataPosterior) {
		LocalDate localDateAnterior = getLocalDate(dataAnterior);
		LocalDate localDatePosterior = getLocalDate(dataPosterior);
		
		return ChronoUnit.DAYS.between(localDateAnterior, localDatePosterior);
	}

}
