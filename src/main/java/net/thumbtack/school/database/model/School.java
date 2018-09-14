package net.thumbtack.school.database.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class School {
    private int id;
    private String name;
    private int year;
    private List<Group> groups;

    public School() {
    }

    public School(int id, String name, int year, List<Group> groups) {
        setGroups(groups);
        setId(id);
        setName(name);
        setYear(year);
    }

    public School(int id, String name, int year) {
        setName(name);
        setYear(year);
        setId(id);
        groups = new ArrayList();
    }

    public School(String name, int year) {
        setName(name);
        setYear(year);
        groups = new ArrayList();
        id = 0;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }


    public void removeGroup(Group group) {
        groups.remove(group);
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return id == school.id &&
                year == school.year &&
                Objects.equals(name, school.name) &&
                Objects.equals(groups, school.groups);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, year, groups);
    }
}
