package de.ostfale.sb.sbreftest.user.api;

public record User(
        String name,
        Integer age,
        String email
) {

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
