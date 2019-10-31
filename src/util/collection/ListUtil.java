package util.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.naming.ldap.SortControl;

public class ListUtil {

	/**
	 * 2つのリストから、共通の要素のリストを作成する
	 *
	 * @param firstList
	 * @param secondList
	 * @return
	 */
	public static <T> List<T> match(Collection<T> firstList, Collection<T> secondList) {
		Predicate<T> predicate = str -> secondList.stream().anyMatch(element -> str.equals(element));
		List<T> result = firstList.stream().filter(predicate).collect(Collectors.toList());
		return result;
	}

	/**
	 * 2つのリストで共通する要素を削除する
	 *
	 * @param firstList
	 * @param secondList
	 * @return
	 */
	public static <T> List<T> paraListDelete(List<T> firstList, List<T> secondList) {
		List<T> matchList = match(firstList, secondList);
		Predicate<T> predicate = str -> matchList.parallelStream().noneMatch(element -> str.equals(element));
		return firstList.stream().filter(predicate).collect(Collectors.toList());
	}

}
