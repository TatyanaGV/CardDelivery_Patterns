import com.github.javafaker.Faker;

import java.util.*;

public class DataGenerator {
    private DataGenerator() {
    }

    public static User UserGenerate() {
        Faker faker = new Faker(new Locale("ru"));
        return new User(
                faker.name().lastName() + " " + faker.name().firstName(),
                faker.phoneNumber().phoneNumber(),
                getValidCity()
        );
    }

    public static String getValidCity() {
        List<String> ValidCity = new ArrayList<>(Arrays.asList("Владивосток", "Кострома", "Краснодар", "Красноярск", "Псков", "Ростов-на-Дону", "Саратов", "Севастополь", "Симферополь", "Смоленск", "Ставрополь", "Москва", "Санкт-Петербург"));
        Random rand = new Random();
        return ValidCity.get(rand.nextInt(ValidCity.size()));
    }
}
