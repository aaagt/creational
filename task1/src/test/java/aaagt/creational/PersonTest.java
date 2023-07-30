package aaagt.creational;

import aaagt.creational.Person.PersonBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("Person tests")
class PersonTest {

    @Nested
    @DisplayName("getName tests")
    class Person_getNameTest {

        @Test
        void getName() {
            Person mom = new PersonBuilder()
                    .setName("Анна")
                    .setSurname("Вольф")
                    .setAge(31)
                    .setAddress("Сидней")
                    .build();

            String expected = "Анна";

            String actual = mom.getName();

            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("getSurname tests")
    class Person_getSurnameTest {

        @Test
        void getSurname() {
            Person mom = new PersonBuilder()
                    .setName("Анна")
                    .setSurname("Вольф")
                    .setAge(31)
                    .setAddress("Сидней")
                    .build();

            String expected = "Вольф";

            String actual = mom.getSurname();

            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("getAge tests")
    class Person_getAgeTest {

        @Test
        void getAge() {
            Person mom = new PersonBuilder()
                    .setName("Анна")
                    .setSurname("Вольф")
                    .setAge(31)
                    .setAddress("Сидней")
                    .build();

            int expected = 31;

            int actual = mom.getAge();

            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("getAge с неуказанным возрастом бросает IllegalStateException")
        void getAge_ageNotSet_throwsIllegalStateException() {
            Person mom = new PersonBuilder()
                    .setName("Анна")
                    .setSurname("Вольф")
                    .setAddress("Сидней")
                    .build();

            Class<IllegalStateException> expected = IllegalStateException.class;

            assertThrows(expected, () -> mom.getAge());
        }
    }

    @Nested
    @DisplayName("newChildBuilder tests")
    class Person_newChildBuilderTest {

        @Test
        void newChildBuilder() {
            Person mom = new PersonBuilder()
                    .setName("Анна")
                    .setSurname("Вольф")
                    .setAge(31)
                    .setAddress("Сидней")
                    .build();
            Person son = mom.newChildBuilder()
                    .setName("Антошка")
                    .build();

            var expectedSonName = "Антошка";
            var expectedSonSurname = "Вольф";
            var expectedSonAge = 1;
            var expectedSonAddress = "Сидней";

            assertAll(
                    () -> assertEquals(expectedSonName, son.getName()),
                    () -> assertEquals(expectedSonSurname, son.getSurname()),
                    () -> assertEquals(expectedSonAge, son.getAge()),
                    () -> assertEquals(expectedSonAddress, son.getAddress())
            );
        }
    }

    @Nested
    @DisplayName("PersonBuilder tests")
    class PersonBuilderTest {

        @Test
        void build() {
            Person mom = new PersonBuilder()
                    .setName("Анна")
                    .setSurname("Вольф")
                    .setAge(31)
                    .setAddress("Сидней")
                    .build();

            var expectedName = "Анна";
            var expectedSurname = "Вольф";
            var expectedAge = 31;
            var expectedAddress = "Сидней";

            assertAll(
                    () -> assertEquals(expectedName, mom.getName()),
                    () -> assertEquals(expectedSurname, mom.getSurname()),
                    () -> assertEquals(expectedAge, mom.getAge()),
                    () -> assertEquals(expectedAddress, mom.getAddress())
            );
        }

        @Test
        @DisplayName("setAge для ненатуральных чисел бросает IllegalArgumentException")
        void setAge_notNaturalNumber_throwsIllegalStateException() {
            var builder = new PersonBuilder();

            Class<IllegalArgumentException> expected = IllegalArgumentException.class;

            assertThrows(expected, () -> builder.setAge(-100));
        }

        @Test
        @DisplayName("build с неуказанным именем бросает IllegalStateException")
        void build_surnameNotSet_throwsIllegalStateException() {
            var builder = new PersonBuilder()
                    .setSurname("Вольф");

            Class<IllegalStateException> expected = IllegalStateException.class;

            assertThrows(expected, () -> builder.build());
        }

        @Test
        @DisplayName("build с неуказанной фамилией бросает IllegalStateException")
        void build_non_throwsIllegalStateException() {
            var builder = new PersonBuilder()
                    .setName("Анна");

            Class<IllegalStateException> expected = IllegalStateException.class;

            assertThrows(expected, () -> builder.build());
        }
    }

}
