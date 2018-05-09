package net.thumbtack.school.hiring.response;

import net.thumbtack.school.hiring.Models.ListEmployer;

import java.util.ArrayDeque;

public class GetVacansiesDtoResponse {
    private ArrayDeque<ListEmployer> Vacancies;

    public ArrayDeque<ListEmployer> getVacancies() {
        return Vacancies;
    }

    private void setVacancies(ArrayDeque<ListEmployer> vacancies) {
        Vacancies = vacancies;
    }

    /* private Vacancy vacancies;
    private String firstName;
    private String lastName;
    private String middlename;
    private String  address;
    private String companyName;
    private String email;

    public Vacancy getRequirements() {
        return vacancies;
    }

    private void setRequirements(Vacancy requirements) {
        this.vacancies = requirements;
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
    public GetVacansiesDtoResponse(String firstName, String lastName, String middlename, String email, Vacancy vacancies,String  address,String companyName){
        setAddress(address);
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setMiddlename(middlename);
        setCompanyName(companyName);
        setRequirements(vacancies);
    }*/
    public GetVacansiesDtoResponse(ArrayDeque<ListEmployer> Vacancies) {
        setVacancies(Vacancies);
    }
}
