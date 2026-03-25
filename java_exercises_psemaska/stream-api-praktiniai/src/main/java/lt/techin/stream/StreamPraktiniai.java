package lt.techin.stream;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPraktiniai {

    public static List<Integer> returnSquareRoot(List<Integer> numbers){
        return numbers.stream()
                .map(number -> (int) Math.sqrt(number))
                .toList();
    }

    public static List<Integer> getAgeFromUsers(List<User> users){
        return users.stream()
                .map(user -> user.getAge())
                .toList();
    }

    public static List<Integer> getDistinctAges(List<User> users){
        return users.stream()
                .map(user -> user.getAge())
                .distinct()
                .toList();
    }

    public static List<User> getLimitedUserList(List<User> users, int limit){
        return users.stream()
                .limit(limit)
                .toList();
    }

    public static Integer countUsersOlderThen25(List<User> users){
        return (int) users.stream()
                .filter(user -> user.getAge() > 25)
                .count();
    }

    public static List<String> mapToUpperCase(List<String> strings){
        return strings.stream()
                .map(s -> s.toUpperCase())
                .toList();
    }

    public static Integer sum(List<Integer> integers){
        return integers.stream()
                .reduce(0, (acc, num) -> acc += num);
    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip){
        return integers.stream()
                .skip(toSkip)
                .toList();
    }

    public static List<String> getFirstNames(List<String> names){

        return names.stream()
                .map(str -> str.split(" ")[0])
                .toList();
    }

    public static List<String> getDistinctLetters(List<String> names){
        return names.stream()
                .flatMap(str -> Arrays.stream(str.split("")))
                .distinct()
                .toList();
    }


    public static String separateNamesByComma(List<User> users){
        return users.stream()
                .map(user -> user.getName())
                .collect(Collectors.joining(", "));
    }

    public static double getAverageAge(List<User> users){
       return users.stream()
               .mapToInt(user -> user.getAge())
               .average().getAsDouble();
    }

    public static Integer getMaxAge(List<User> users){
        return users.stream()
                .mapToInt(user -> user.getAge())
                .max().getAsInt();
    }

    public static Integer getMinAge(List<User> users) {

        return users.stream()
                .mapToInt(user -> user.getAge())
                .min().getAsInt();

    }

    public static boolean anyMatch(List<User> users, int age){
        return users.stream()
                .anyMatch(user -> user.getAge() == age);
    }

    public static boolean noneMatch(List<User> users, int age){
        return users.stream()
                .noneMatch(user -> user.getAge() == age);
    }

    public static Optional<User> findAny(List<User> users, String name){
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findAny();
    }

    public static List<User> sortByAge(List<User> users){

        return users.stream()
                .sorted((u1, u2) -> u1.getAge() - u2.getAge())
                .toList();

    }

    public static Stream<Integer> getBoxedStream(IntStream stream){
        return stream.boxed();
    }

    public static List<Integer> generateFirst10PrimeNumbers(){
        return Stream.iterate(2, x -> x + 1)
                .filter(x -> isPrime(x))
                .limit(10)
                .toList();
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
    }

    public static List<Integer> generate10RandomNumbers(){
        return Stream.generate(() -> (int) Math.random() * Integer.MAX_VALUE)
                .limit(10)
                .toList();
    }

    public static User findOldest(List<User> users){
        return users.stream()
                .sorted((u1, u2) -> u2.getAge() - u1.getAge())
                .findFirst().orElse(null);
    }

    public static int sumAge(List<User> users){
        return users.stream()
                .mapToInt(user -> user.getAge())
                .sum();
    }

    //Pvz.:
    //Java 8 Streams API: Grouping and Partitioning a Stream
    //https://www.javacodegeeks.com/2015/11/java-8-streams-api-grouping-partitioning-stream.html

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users){
        return users.stream()
                .collect(Collectors.partitioningBy(user -> user.isMale()));
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users){
        return users.stream()
                .collect(Collectors.groupingBy(user -> user.getAge()));
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users){
        return users.stream()
                .collect(Collectors.groupingBy(User::isMale, Collectors.groupingBy(User::getAge)));
    }

    public static Map<Boolean, Long> countGender(List<User> users){
        return users.stream()
                .collect(Collectors.groupingBy(User::isMale, Collectors.counting()));
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users){
        return users.stream()
                .collect(Collectors.summarizingInt(User::getAge));
    }

}
