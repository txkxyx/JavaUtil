import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import util.ComUtil;
import util.collection.ComparableClass;
import util.collection.ListUtil;
import util.date.DateUtil;

public class Sample {
	public static void main(String[] args) {
		System.out.println("--* Stream Demo *--");
		Stream<String> stream = Arrays.asList("AAAAA", "BBB", "CCCCC").stream();
		stream.map(str -> str.toLowerCase()).peek(System.out::println).filter(str -> str.length() > 4)
				.peek(System.out::println).allMatch(str -> str.length() == 5);
		System.out.println();

		System.out.println("--* 2つのリストから、共通の要素のリストを作成する *--");
		List<String> firstList = Arrays.asList("A", "B", "C", "D", "E");
		List<String> secondList = Arrays.asList("D", "E", "F", "G", "H");
		System.out.println(ListUtil.match(firstList, secondList));

		System.out.println("--* 2つのリストで共通する要素を削除する *--");
		List<String> copyFirstList = new ArrayList<>(firstList);
		List<String> copySecondList = new ArrayList<>(secondList);
		firstList = ListUtil.paraListDelete(copyFirstList, copySecondList);
		secondList = ListUtil.paraListDelete(copySecondList, copyFirstList);
		System.out.println(firstList);
		System.out.println(secondList);

		List<Integer> firsInttList = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> secondIntList = Arrays.asList(4, 5, 6, 7, 8);
		List<Integer> copyFirstIntList = new ArrayList<>(firsInttList);
		List<Integer> copySecondSecondList = new ArrayList<>(secondIntList);
		firsInttList = ListUtil.paraListDelete(copyFirstIntList, copySecondSecondList);
		secondIntList = ListUtil.paraListDelete(copySecondSecondList, copyFirstIntList);
		System.out.println(firsInttList);
		System.out.println(secondIntList);

		System.out.println("--* 複数or条件 *--");
		List<String> strConditions = Arrays.asList("A", "B", "C", "D", "E");
		System.out.println(ComUtil.anyIfOr("C", strConditions));

		List<Integer> intConditions = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(ComUtil.anyIfOr(6, intConditions));

		System.out.println("--* 月末日を求める *--");
		System.out.println(DateUtil.endDayOfMonth(LocalDate.now()));
		System.out.println(DateUtil.endDayOfMonth(LocalDate.now().toString()));

		System.out.println("--* 月初日を求める *--");
		System.out.println(DateUtil.firstDayOfMonth(LocalDate.now()));
		System.out.println(DateUtil.firstDayOfMonth(LocalDate.now().toString()));

		System.out.println("--* 日付文字列を別の書式に変換 *--");
		System.out.println(DateUtil.cnvDateFormat("2019-10-07", "yyyy-MM-dd", "yyyy/MM/dd"));

		System.out.println("--* 日時文字列を別の書式に変換");
		System.out.println(
				DateUtil.cnvDateTimeFormat("2019-10-16 09:32:40", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH-mm-ss"));

		System.out.println("--* 複数条件でリストを並び替える *--");
		List<ComparableClass> list = Arrays.asList(new ComparableClass("ABC", 1), new ComparableClass("ABCD", 2),
				new ComparableClass("ABC", 8), new ComparableClass("A", 5), new ComparableClass("ABCDEF", 3),
				new ComparableClass("ABCDEF", 1));
		System.out.println();
	}

}
