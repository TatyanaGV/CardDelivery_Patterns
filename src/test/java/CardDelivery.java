import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CardDelivery {
    private String URL = "http://localhost:9999";

    @Test
    @DisplayName("Positive test. All fields are filled")
    void shouldRegisterByDeliverCardPositive() {
        open(URL);

        User UserOne = DataGenerator.UserGenerate();
        $("[data-test-id=city] input").setValue(UserOne.getCity());
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        $("[data-test-id=date] input").setValue(getDate(3));
        $("[data-test-id=name] input").setValue(UserOne.getName());
        $("[data-test-id=phone] input").setValue(UserOne.getPhone());
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Запланировать")).click();
        $(withText("Успешно")).waitUntil(visible, 15000);
    }

    @Test
    @DisplayName("Negative test. 'Mobile phone' is empty")
    void shouldRegisterByDeliverCardNegative() {
        open(URL);
        User UserSecond = DataGenerator.UserGenerate();
        $("[data-test-id=city] input").setValue(UserSecond.getCity());
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        $("[data-test-id=date] input").setValue(getDate(3));
        $("[data-test-id=name] input").setValue(UserSecond.getName());
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Запланировать")).click();
        $(withText("Поле обязательно для заполнения")).waitUntil(visible, 15000);
    }

    public String getDate(int plusDays) {
        LocalDate today = LocalDate.now();
        LocalDate date3Day = today.plusDays(plusDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        String formatDate = formatter.format(date3Day);
        return formatDate;
    }
}