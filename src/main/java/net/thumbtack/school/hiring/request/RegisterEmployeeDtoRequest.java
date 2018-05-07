package net.thumbtack.school.hiring.request;

import net.thumbtack.school.hiring.Models.Employee;

public class RegisterEmployeeDtoRequest {
    private String firstName;
    private String lastName;
    private String middlename;
    private int age;
    private String email;
    private String login;
    private String password;
    private boolean activity;

    public boolean isActivity() {
        return activity;
    }

    private void setActivity(boolean activity) {
        this.activity = activity;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public RegisterEmployeeDtoRequest(String firstName, String login, String password, String lastName, String middlename, int age, String email, boolean activity) {
        setEmail(email);
        setFirstName(firstName);
        setPassword(password);
        setLogin(login);
        setLastName(lastName);
        setMiddlename(middlename);
        setAge(age);
        setActivity(activity);
    }


    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    private void setAge(int age) {
        this.age = age;
    }


    public String getLastName() {
        return lastName;
    }

    public String getMiddlename() {
        return middlename;
    }

    public int getAge() {
        return age;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLogin(String login) {
        this.login = login;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    // конструкторы, геттеры и сеттеры
    public String validate() {
        if (firstName.isEmpty()) {
            return "Empty first name";
        }
        if (lastName.isEmpty()) {
            return "Empty last name";
        }
        if (email.isEmpty()) {
            return "Empty email ";
        }
        if (login.isEmpty()) {
            return "Empty login ";
        }
        if (password.isEmpty()) {
            return "Empty password ";
        }
        if (age < 18 | age > 100) {
            return "not correct age";
        }

        return "";
    }
}
