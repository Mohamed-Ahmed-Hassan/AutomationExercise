package utilities;

import java.util.Random;
import java.util.UUID;

public class RandomSource {

    public static String generateMobileNumber() {
        String[] prefixes = {"010", "011", "012", "015"};
        Random random = new Random();

        String prefix = prefixes[random.nextInt(prefixes.length)];
        StringBuilder number = new StringBuilder(prefix);

        for (int i = 0; i < 8; i++) {
            number.append(random.nextInt(10));
        }
        return number.toString();
    }
    public static String generateRandomEmail() {
        String[] domains = {"gmail.com", "outlook.com"};
        Random random = new Random();

        String username = "user" + random.nextInt(100000);
        String domain = domains[random.nextInt(domains.length)];

        return username + "@" + domain;
    }

    public static String generateRandomPassword(int length) {

        StringBuilder password = new StringBuilder();
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }

        return password.toString();
    }

    public static String RandomName() {

        return "User" + UUID.randomUUID().toString().substring(0, 5);}
}
