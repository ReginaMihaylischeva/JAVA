package net.thumbtack.school.database.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {
    private int id;

    private String name;
    private String room;
    private List<Trainee> trainees;



    private List<Subject> subjects;

    public Group() {
    }

    public Group(int id, String name, String room, List<Trainee> trainees, List<Subject> subjects) {
        setName(name);
        setRoom(room);
        setId(id);
        setSubjects(subjects);
        setTrainees(trainees);
    }

    public Group(int id, String name, String room) {
        setName(name);
        setRoom(room);
        setId(id);
        trainees = new ArrayList();
        subjects = new ArrayList();
    }

    public Group(String name, String room) {
        setName(name);
        setRoom(room);
        id = 0;
        trainees = new ArrayList();
        subjects = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) {
        trainees.remove(trainee);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }


    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id &&
                Objects.equals(name, group.name) &&
                Objects.equals(room, group.room) &&
                Objects.equals(trainees, group.trainees) &&
                Objects.equals(subjects, group.subjects);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, room, trainees, subjects);
    }
}
