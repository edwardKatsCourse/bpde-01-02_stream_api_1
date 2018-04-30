package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        Collection
        //List
        //Set
        //Map
        //Array

        List<String> strings = Arrays.asList("c", "b", "a", "aa")
                .stream()
                .filter(x -> x.length() == 1)
                .collect(Collectors.toList());

        Set<String> stringSet = new HashSet<>();
        stringSet.add("a");
        stringSet.add("b");
        stringSet.add("c");
        stringSet.add("aa");

        stringSet = stringSet.stream()
                .filter(x -> x.length() == 1)
                .collect(Collectors.toSet());

        System.out.println(strings);
        System.out.println(stringSet);

        List<User> users = new ArrayList<>();
        users.add(new User("David", 46, "male"));
        users.add(new User("Anna", 34, "female"));
        users.add(new User("Daniel", 31, "male"));
        users.add(new User("Jane", 22, "female"));

        List<RichUserInfo> richUserInfoList = users
                .stream()
                .filter(x -> x.getAge() > 30)
                .map(x -> new RichUserInfo(x, "Fleet St.", "London"))
                /*------RichUserInfo ------*/
                .sorted((o1, o2) -> o1.getBaseUserInfo().getAge().compareTo(
                        o2.getBaseUserInfo().getAge()))
                .peek(x -> {
                    String prefix = "";
                    if (x.getBaseUserInfo().getGender().equalsIgnoreCase("male")) {
                        prefix = "Mr.";
                    }

                    if (x.getBaseUserInfo().getGender().equalsIgnoreCase("female")) {
                        prefix = "Mrs.";
                    }
                    String name = prefix + " " + x.getBaseUserInfo().getName();
                    x.getBaseUserInfo().setName(name);
                })
                .collect(Collectors.toList());

        richUserInfoList.forEach(x -> System.out.printf("Name: %s, Age: %s, Address: %s, %s%n",
                x.getBaseUserInfo().getName(),
                x.getBaseUserInfo().getAge(),
                x.getAddress(),
                x.getCity()));

        System.out.println("Original List of Users");
        System.out.println(users);


        Map<String, RichUserInfo> richUserInfoMap = richUserInfoList.stream()
                .collect(Collectors.toMap(
                        x -> x.getBaseUserInfo().getName(),
                        x -> x));

        richUserInfoMap.entrySet().stream()
                .forEach(x -> System.out.printf("Key: %s, Value: %s%n", x.getKey(), x.getValue()));
        System.out.println();
    }


    private static void stringsToIntegers() {
        List<String> stringNumbers = Arrays.asList(
                "2",
                "4",
                "a",
                "b",
                "101",
                "10",
                "3",
                "1a7",
                "101@",
                "1",
                "-1000"
        );

        List<Integer> integers = stringNumbers
                .stream()
                .filter(x -> {
                    try {
                        Integer.parseInt(x);
                        System.out.printf("LOG: [%s] is a number%n", x);
                        return true;
                    } catch (NumberFormatException e) {
                        System.out.printf("LOG: [%s] is NOT a number%n", x);
                        return false;
                    }
                })
                .map(x -> {
                    System.out.printf("Transforming [%s]%n", x);
                    return Integer.parseInt(x);
                })
                .skip(1)
                .limit(2)
                .sorted()
                .collect(Collectors.toList());


        System.out.println();
        System.out.println("--------------------------");
        System.out.println(stringNumbers);
        System.out.println(integers);

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Method RUN");
//            }
//        };
//
//        Runnable runnable2 = () -> System.out.println("Method RUN");
    }


    private static void beforeJava8() {
        List<String> strings = Arrays.asList("a", "b", "c");
        String searchingFor = "d";
        System.out.println(hasValue(strings, searchingFor));

        List<User> users = Arrays.asList(
                new User("David", 46, "male"),
                new User("Maria", 23, "female"));


        System.out.println(transform(users, "Baker St.", "London"));
    }

    private static List<RichUserInfo> transform(List<User> users, String street, String city) {
        List<RichUserInfo> richUserInfos = new ArrayList<>();
        for (User u : users) {
            richUserInfos.add(new RichUserInfo(u, street, city));
        }
        return richUserInfos;
    }

    private static boolean hasValue(List<String> list, String search) {
        for (String s : list) {
            if (search.equals(s)) {
                return true;
            }
        }
        return false;
    }

}

