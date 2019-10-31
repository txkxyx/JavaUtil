package util.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	/**
	 * 月末日を求める
	 *
	 * @param date
	 * @return
	 */
	public static LocalDate endDayOfMonth(LocalDate date) {
		return LocalDate.of(date.getYear(), date.getMonth(), date.lengthOfMonth());
	}

	/**
	 * 月末日を求める
	 *
	 * @param strDate
	 * @param format
	 * @return
	 */
	public static LocalDate endDayOfMonth(String strDate) {
		return endDayOfMonth(LocalDate.parse(strDate));
	}

	/**
	 * 月初日を求める
	 *
	 * @param date
	 * @return
	 */
	public static LocalDate firstDayOfMonth(LocalDate date) {
		return LocalDate.of(date.getYear(), date.getMonth(), endDayOfMonth(date.minusMonths(1)).plusDays(1).getDayOfMonth());
	}

	/**
	 * 月初日を求める
	 *
	 * @param strDate
	 * @param format
	 * @return
	 */
	public static LocalDate firstDayOfMonth(String strDate) {
		LocalDate date = LocalDate.parse(strDate);
		return firstDayOfMonth(date);
	}

	/**
	 * 日付文字列を別の書式に変換
	 *
	 * @param strDate
	 * @param formatFm
	 * @param formatTo
	 * @return
	 */
	public static String cnvDateFormat(String strDate, String formatFm, String formatTo) {
		LocalDate dateFm = LocalDate.parse(strDate, DateTimeFormatter.ofPattern(formatFm));
		return dateFm.format(DateTimeFormatter.ofPattern(formatTo));
	}

	/**
	 * 日次文字列を別の書式に変換
	 *
	 * @param strDateTime
	 * @param formatFm
	 * @param formatTo
	 * @return
	 */
	public static String cnvDateTimeFormat(String strDateTime, String formatFm, String formatTo) {
		LocalDateTime dateTimeFm = LocalDateTime.parse(strDateTime, DateTimeFormatter.ofPattern(formatFm));
		return dateTimeFm.format(DateTimeFormatter.ofPattern(formatTo));
	}

}
