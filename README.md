[![Build status](https://ci.appveyor.com/api/projects/status/2gl5d4f4n77s4urk?svg=true)](https://ci.appveyor.com/project/TatyanaGV/patterns-homework2-3)

## CardDelivery(Patterns)

Авто-тесты формы "Карта с доставкой".

##### Требования к содержимому полей:

* Город - один из административных центров субъектов РФ;
* Дата - не ранее трёх дней с текущей даты;
* Поле Фамилия и имя - разрешены только русские буквы, дефисы и пробелы;
* Поле телефон - только цифры (11 цифр), символ + (на первом месте);
* Флажок согласия должен быть выставлен;
* Тестируемая функциональность: отправка формы.

Поля Город и Дата заполняются через прямой ввод значений (без использования выбора из выпадающего списка и всплывающего календаря).

Условия: если все поля заполнены корректно, то форма переходит в состояние "Загрузки":

 ##### Инструментарий:
- JAVA8 - язык написания авто-тестов;
- JUnit - платформа для написания авто-тестов и их запуска;
- Gradle - система управления зависимостями;
- Git - хранение тестов;
- Continuous Integration (Appveyor) - система для сбора авто-тестов в автоматическом режиме;
- Selenide - фреймворк для автоматизированного тестирования веб-приложений;
- SUT - целевой сервис SUT (app-order.jar);
- Faker - библиотека для генерации данных для автозаполнения;
- Lombok.