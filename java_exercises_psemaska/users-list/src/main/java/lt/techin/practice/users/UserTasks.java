package lt.techin.practice.users;

import java.util.*;

public class UserTasks {

    // Count how many users in the list are older than 25.
    public static Integer countUsersOlderThan25(List<User> users) {
        int count = 0;
        for(User user : users) {
            if(user.getAge() > 25) {
                count++;
            }
        }
        return count;
    }

    // Calculate and return the average age of all users in the list.
    public static double getAverageAge(List<User> users) {

        int ageSum = 0;

        for(User user : users) {
            ageSum += user.getAge();
        }

        return (double) ageSum / users.size();

    }

    // Find and return the smallest age from the list of users.
    public static Integer getMinAge(List<User> users) {
        int smallestAge = users.get(0).getAge();

        for(int i = 1; i < users.size(); i++) {
            if(users.get(i).getAge() < smallestAge) {
                smallestAge = users.get(i).getAge();
            }
        }
        return smallestAge;
    }

    // Find the first user whose name matches the provided name.
    public static User findByName(List<User> users, String name) {
        for(User user : users) {
            if(user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    // Return a new list of users sorted by age in ascending order.
    public static List<User> sortByAge(List<User> users) {
        Collections.sort(users);
        return users;
    }

    // Find and return the oldest user in the list.
    public static User findOldest(List<User> users) {
        int oldest = users.get(0).getAge();
        int oldestIndex = 0;

        for(int i = 1; i < users.size(); i++) {
            if(users.get(i).getAge() > oldest) {
                oldest = users.get(i).getAge();
                oldestIndex = i;
            }
        }
        return users.get(oldestIndex);
    }

    // Sum all user ages and return the result as an int.
    public static int sumAge(List<User> users) {

        int sumAge = 0;

        for(User user : users) {
            sumAge += user.getAge();
        }

        return sumAge;
    }

    // Count how many users have the provided hobby in their hobbies collection.
    public static Integer countUsersWithTheHobby(List<User> users, String hobby) {

        int count = 0;

        for(User user : users) {
            for(String hb : user.getHobbies()) {
                if(hb.equals(hobby)) {
                    count++;
                }
            }
        }
        return count;
    }

    // Find and return all users who have the provided hobby.
    public static List<User> findUsersWithHobby(List<User> users, String hobby) {

        List<User> usersWithHobbies = new ArrayList<>();

        for(User user : users) {
            for(String hb :user.getHobbies()) {
                if(hb.equals(hobby)) {
                    usersWithHobbies.add(user);
                }
            }
        }

        return usersWithHobbies;
    }

    // Return all unique hobbies from every user as a set.
    public static Set<String> getUniqueHobbies(List<User> users) {
        Set<String> hobbies = new HashSet<>();

        for(User user : users) {
            for(String hobby : user.getHobbies()){
                hobbies.add(hobby);
            }
        }
        return hobbies;
    }

}
