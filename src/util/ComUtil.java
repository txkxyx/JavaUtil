package util;

import java.util.List;

public class ComUtil {

	/**
	 * 複数or条件
	 * @param t
	 * @param conditions
	 * @return
	 */
	public static <T> Boolean anyIfOr(T t, List<T> conditions) {
		return conditions.stream().anyMatch(condition -> condition.equals(t));
	}
}
