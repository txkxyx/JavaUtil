package util.check;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import util.ComUtil;

public class CheckUtil {

	/**
	 *
	 * @param object
	 * @return
	 */
	public static boolean isNull(Object object){
		return object == null;
	}

	/**
	 *
	 * @param object
	 * @return
	 */
	public static boolean isEmpty(Object object){
		if (isNull(object)) {
			return true;
		}

		if (ComUtil.anyIfOr(object.getClass(), Arrays.asList(List.class,ArrayList.class,LinkedList.class))) {
			List<?> list = (List<?>)object;
			return list.isEmpty();
		}

		if (ComUtil.anyIfOr(object.getClass(), Arrays.asList(Set.class,HashSet.class,TreeSet.class))) {
			Set<?> set = (Set<?>)object;
			return set.isEmpty();
		}

		if (ComUtil.anyIfOr(object.getClass(), Arrays.asList(Map.class,HashMap.class,TreeMap.class,LinkedHashMap.class))) {
			Map<?, ?> map = (Map<?, ?>)object;
			return map.isEmpty();
		}

		return ( object.toString().length() == 0 || object.equals("undefined") );
	}

	/**
	 *
	 * @param object
	 * @return
	 */
	public static boolean isNotEmpty(Object object){
		return !isEmpty(object);
	}

}
