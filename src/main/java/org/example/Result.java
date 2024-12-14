package org.example;

import java.time.Duration;

public record Result(Person person, Distance distance, Duration time) {
    private static String value;

    public boolean hasGender(Gender gender) {

        return person.gender() == gender;
    }

    public boolean hasDistance(Distance distance) {
        return this.distance == distance;
    }

    public String getValue() {

        return value;
    }

    @Override
    public String toString() {
        return "Result[person=" + person + ", distance=" + distance + ", time=" + time + "]";
    }
}