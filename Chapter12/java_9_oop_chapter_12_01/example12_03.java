public interface Testable {
    boolean test(int number);
}

public class TestDivisibleBy5 implements Testable {
    @Override
    public boolean test(int number) {
        return ((number % 5) == 0);
    }
}

public class TestGreaterThan10 implements Testable {
    @Override
    public boolean test(int number) {
        return (number > 10);
    }
}

public List<Integer> filterNumbersWithTestable(final List<Integer> numbers,
    Testable tester) {
    List<Integer> filteredNumbers = new ArrayList<>();
    for (Integer number : numbers) {
        if (tester.test(number)) {
            filteredNumbers.add(number);
        }
    }
    return filteredNumbers; 
}

import java.util.stream.Collectors;
import java.util.stream.IntStream;

List<Integer> range1to20 = 
    IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());

TestDivisibleBy5 testDivisibleBy5 = new TestDivisibleBy5();
List<Integer> divisibleBy5Numbers = 
filterNumbersWithTestable(range1to20, testDivisibleBy5);
System.out.println(divisibleBy5Numbers);

TestGreaterThan10 testGreaterThan10 = new TestGreaterThan10();
List<Integer> greaterThan10Numbers = 
    filterNumbersWithTestable(range1to20, testGreaterThan10);
System.out.println(greaterThan10Numbers);

import java.util.function.IntPredicate;

public List<Integer> filterNumbersWithPredicate(final List<Integer> numbers,
    IntPredicate predicate) {
    List<Integer> filteredNumbers = new ArrayList<>();
    for (Integer number : numbers) {
        if (predicate.test(number)) {
            filteredNumbers.add(number);
        }
    }
    return filteredNumbers; 
}

IntPredicate divisibleBy5 = n -> n % 5 == 0;

List<Integer> divisibleBy5Numbers2 = 
    filterNumbersWithPredicate(range1to20, divisibleBy5);
System.out.println(divisibleBy5Numbers2);

List<Integer> greaterThan10Numbers2 = 
    filterNumbersWithPredicate(range1to20, n -> n > 10);
System.out.println(greaterThan10Numbers2);

import java.util.function.Function;

public List<Integer> filterNumbersWithFunction(final List<Integer> numbers,
    Function<Integer, Boolean> function) {
    List<Integer> filteredNumbers = new ArrayList<>();
    for (Integer number : numbers) {
        if (function.apply(number)) {
            filteredNumbers.add(number);
        }
    }
    return filteredNumbers; 
}

List<Integer> divisibleBy3Numbers = 
    filterNumbersWithFunction(range1to20, n -> n % 3 == 0);


