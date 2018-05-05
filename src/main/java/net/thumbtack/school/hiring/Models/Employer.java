package net.thumbtack.school.hiring.Models;

public class Employer {
    private String firstName;
    private String lastName;
    private String middlename;
    private String email;
    private String login;
    private String password;
    private String address;
    private String companyName;

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

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    private void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    private void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Employer(String firstName, String login, String password, String lastName, String middlename, String address, String companyName, String email) {
        setAddress(address);
        setCompanyName(companyName);
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setLogin(login);
        setMiddlename(middlename);
        setPassword(password);
    }
}
