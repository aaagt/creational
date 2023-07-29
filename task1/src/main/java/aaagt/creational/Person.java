package aaagt.creational;

import java.util.Optional;

public class Person {

    String name;
    String surname;
    Optional<Integer> age;
    Optional<String> address;

    private Person(String name, String surname, Optional<Integer> age, Optional<String> address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Optional<Integer> getAge() {
        if (hasAge()) {
            return age;
        } else {
            throw new IllegalStateException("Возраст неопределён");
        }
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public void happyBirthday() {
        if (hasAge()) {
            age = Optional.of(age.get() + 1);
        } else {
            throw new IllegalStateException("Возраст неопределён");
        }
    }

    public Optional<String> getAddress() {
        if (hasAddress()) {
            return address;
        } else {
            throw new IllegalStateException("Адрес неопределён");
        }
    }

    public void setAddress(String city) {
        address = Optional.ofNullable(city);
    }

    public boolean hasAddress() {
        return address.isPresent();
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setAge(1)
                .setSurname(this.surname)
                .setAddress(address.orElse(null));
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + (age.isPresent() ? age.get() : "не известен") + '\'' +
                ", address='" + (address.isPresent() ? address.get() : "не известен") + '\'' +
                '}';
    }

    public static class PersonBuilder {

        Optional<String> name = Optional.empty();
        Optional<String> surname = Optional.empty();
        Optional<Integer> age = Optional.empty();
        Optional<String> address = Optional.empty();

        public PersonBuilder setName(String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            this.surname = Optional.ofNullable(surname);
            return this;
        }

        public PersonBuilder setAge(Integer age) {

            if (age != null && age <= 0) {
                throw new IllegalArgumentException("Возраст должен быть натуральным числом");
            }

            this.age = Optional.ofNullable(age);
            return this;
        }

        public PersonBuilder setAddress(String address) {
            this.address = Optional.ofNullable(address);
            return this;
        }

        public Person build() {
            if (this.name.isEmpty()) {
                throw new IllegalStateException("Имя должно быть заполнено");
            }
            if (this.surname.isEmpty()) {
                throw new IllegalStateException("Фамилия должна быть заполнена");
            }

            return new Person(
                    this.name.get(),
                    this.surname.get(),
                    this.age,
                    this.address
            );
        }
    }
}
