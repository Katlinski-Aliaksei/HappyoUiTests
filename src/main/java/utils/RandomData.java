package utils;

import java.util.Random;

public class RandomData {
    public static String generatedString=null;

    public static String generateRandomPhoneNumber() {
        int a = 100000000;
        int b = 999999999;
        int random_number = a + (int) (Math.random() * b);
        System.out.println("случайное число: " + random_number);

        return String.valueOf(random_number);
    }

    public static String generateRandomName() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println(generatedString);

        return generatedString;
    }
}
