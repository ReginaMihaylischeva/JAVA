package net.thumbtack.school.database.model;

import java.util.Objects;

public class Trainee {
    private String firstName;
    private String lastName;
    private int rating;
    private int id;

    public Trainee() {
    }

    public Trainee(int id, String firstName, String lastName, int rating) {
        setFirstName(firstName);
        setLastName(lastName);
        setRating(rating);
        setId(id);
    }

    public Trainee(String firstName, String lastName, int rating) {
        setFirstName(firstName);
        setLastName(lastName);
        setRating(rating);
        id = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainee trainee = (Trainee) o;
        return rating == trainee.rating &&
                id == trainee.id &&
                Objects.equals(firstName, trainee.firstName) &&
                Objects.equals(lastName, trainee.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, rating, id);
    }




}
