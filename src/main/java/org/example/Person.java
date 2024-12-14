package org.example;

public record Person(String name, Gender gender) {
    @Override
    public String toString() {
        return "Person{name='" + name + "', gender=" + gender + '}';
    }
}
