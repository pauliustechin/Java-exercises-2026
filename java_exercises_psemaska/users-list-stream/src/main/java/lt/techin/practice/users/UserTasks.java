package lt.techin.practice.users;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserTasks {

    // Count how many users in the list are older than 25.
    public static Integer countUsersOlderThan25(List<User> users) {
        return (int) users.stream()
                .filter(user -> user.getAge() > 25)
                .count();
    }

    // Calculate and return the average age of all users in the list.
    public static double getAverageAge(List<User> users) {
       return users.stream()
               .mapToDouble(user -> user.getAge())
               .average().orElse(0.0);
    }

    // Find and return the smallest age from the list of users.
    public static Integer getMinAge(List<User> users) {

        return users.stream().mapToInt(User::getAge).min().orElse(0);

    }

    // Find the first user whose name matches the provided name.
    public static User findByName(List<User> users, String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst().get();
    }

    // Return a new list of users sorted by age in ascending order.
    public static List<User> sortByAge(List<User> users) {

        return users.stream()
                .sorted((u1, u2) -> u1.getAge() - u2.getAge())
                .collect(Collectors.toList());
    }

    // Find and return the oldest user in the list.
    public static User findOldest(List<User> users) {
        int maxAge = 0;
        return users.stream().sorted((u1, u2) -> u2.getAge() - u1.getAge())
                .findFirst().orElse(null);

    }

    // Sum all user ages and return the result as an int.
    public static int sumAge(List<User> users) {

        return users.stream()
                .mapToInt(user -> user.getAge()).sum();
    }

    // Count how many users have the provided hobby in their hobbies collection.
    public static Integer countUsersWithTheHobby(List<User> users, String hobby) {
        return (int) users.stream()
                .flatMap(user -> user.getHobbies().stream())
                .filter(hb -> hb.equals(hobby)).count();
    }

    // Find and return all users who have the provided hobby.
    public static List<User> findUsersWithHobby(List<User> users, String hobby) {
        return users.stream()
                .filter(user -> user.getHobbies().contains(hobby))
                .toList();
    }

    // Return all unique hobbies from every user as a set.
    public static Set<String> getUniqueHobbies(List<User> users) {
        return users.stream()
                .flatMap(user -> user.getHobbies().stream())
                .collect(Collectors.toSet());
    }

}
