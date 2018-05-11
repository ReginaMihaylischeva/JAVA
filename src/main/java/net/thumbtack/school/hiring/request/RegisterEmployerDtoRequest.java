package net.thumbtack.school.hiring.request;

public class RegisterEmployerDtoRequest {
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

    public  RegisterEmployerDtoRequest(String firstName, String login, String password, String lastName, String middlename, String address, String companyName, String email) {
        setAddress(address);
        setCompanyName(companyName);
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setLogin(login);
        setMiddlename(middlename);
        setPassword(password);
    }

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
        if (address.isEmpty()) {
            return "Empty address ";
        }
        if (!email.contains("@")) {
            return "Not correct email";
        }
        if (companyName.isEmpty()) {
            return "Empty company  name";
        }
        return "";
    }
}
