package net.thumbtack.school.database.model;

import java.util.Objects;

public class Subject {
    private int id;
    private String name;

    public Subject() {
    }

    public Subject(int id, String name) {
        setId(id);
        setName(name);
    }

    public Subject(String name) {
        setName(name);
        id = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id == subject.id &&
                Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
