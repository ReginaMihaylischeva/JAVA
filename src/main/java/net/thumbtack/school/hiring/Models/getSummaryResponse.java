package net.thumbtack.school.hiring.Models;

import net.thumbtack.school.hiring.request.Skills;

import java.util.List;

public class getSummaryResponse {
    private List<Skills> skills;
    private String firstName;
    private String lastName;
    private String middlename;
    private int age;
    private String email;

    public List<Skills> getSkills() {
        return skills;
    }

    private void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddlename() {
        return middlename;
    }

    private void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }
    public getSummaryResponse(String firstName, String lastName, String middlename, String email, List<Skills> skills, int age ){
        setAge(age);
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setMiddlename(middlename);
        setSkills(skills);
    }
}
