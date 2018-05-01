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

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public RegisterEmployeeDtoRequest(String firstName, String login, String password, String lastName, String middlename, int age, String email) {
        setEmail(email);
        setFirstName(firstName);
        setPassword(password);
        setLogin(login);
        setLastName(lastName);
        setMiddlename(middlename);
        setAge(age);
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
       return "error";
    }
}
