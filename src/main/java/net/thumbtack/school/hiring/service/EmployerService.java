package net.thumbtack.school.hiring.service;

import com.google.gson.Gson;
import net.thumbtack.school.hiring.Models.DeleteEmployer;
import net.thumbtack.school.hiring.Models.Employer;
import net.thumbtack.school.hiring.Models.Vacancy;
import net.thumbtack.school.hiring.daoimpl.DAO;
import net.thumbtack.school.hiring.request.*;
import net.thumbtack.school.hiring.response.RegisterEmployerDtoResponse;

public class EmployerService {
    private Gson gson = new Gson();
    private DAO dao = new DAO();

    public String registerEmployer(String requestJsonStringEmployer) {
        RegisterEmployerDtoRequest registerEmployerDtoReques = gson.fromJson(requestJsonStringEmployer, RegisterEmployerDtoRequest.class);
        if (registerEmployerDtoReques.validate().equals("error")) {
            return "error";


        }
        Employer employer = new Employer(
                registerEmployerDtoReques.getFirstName(),
                registerEmployerDtoReques.getLogin(),
                registerEmployerDtoReques.getPassword(),
                registerEmployerDtoReques.getLastName(),
                registerEmployerDtoReques.getMiddlename(),
                registerEmployerDtoReques.getEmail(),
                registerEmployerDtoReques.getAddress(),
                registerEmployerDtoReques.getCompanyName());
        RegisterEmployerDtoResponse registerEmployerDtoResponse = new RegisterEmployerDtoResponse(dao.InsertEmployer(employer).toString());

        return gson.toJson(registerEmployerDtoResponse);

    }

    public String addVacancy(String requestJsonStringaddVacancy) {
        AddVacancyDtoRequest addVacancyDtoRequest = gson.fromJson(requestJsonStringaddVacancy, AddVacancyDtoRequest.class);
        if (addVacancyDtoRequest.validate().equals("error")) {
            return gson.toJson("error");
        }
        Vacancy vacancy = new Vacancy(
                addVacancyDtoRequest.getJobTitle(),
                addVacancyDtoRequest.getEstimatedSalary(),
                addVacancyDtoRequest.getToken(),
                addVacancyDtoRequest.getRequirements()
        );
        dao.addVacancy(vacancy);
        return gson.toJson("");
    }

    public String getSummary(String requestJsonStringGetSummary) {
        GetSummaryDtoRequest getSummaryDtoRequest = gson.fromJson(requestJsonStringGetSummary, GetSummaryDtoRequest.class);
        if (getSummaryDtoRequest.validate().equals("error")) {
            return gson.toJson("error");
        }
        Requirements requirements = new Requirements(

                getSummaryDtoRequest.getNameRequirement(),
                getSummaryDtoRequest.isCompulsion(),
                getSummaryDtoRequest.getLevelProficiency()


        );
        return gson.toJson("");
    }

    public String deleteEmployer(String requestJsonStringdeleteEmployer) {
        deleteEmployerDtoRequest deleteEmployer = gson.fromJson(requestJsonStringdeleteEmployer, deleteEmployerDtoRequest.class);
        if (deleteEmployer.validate().equals("error")) {
            return gson.toJson("error");


        }
        DeleteEmployer DeleteEmployee = new DeleteEmployer(

                deleteEmployer.getToken());
        dao.deleteEmployer(DeleteEmployee);
        return gson.toJson("");
    }

    public String deleteVacancy(String requestJsonStringdeleteVacancy) {
        deleteVacancyDtoRequest deleteVacancyDtoRequest = gson.fromJson(requestJsonStringdeleteVacancy, deleteVacancyDtoRequest.class);
        if (deleteVacancyDtoRequest.validate().equals("error")) {
            return gson.toJson("error");
        }
        Vacancy vacancy = new Vacancy(
                deleteVacancyDtoRequest.getJobTitle(),
                deleteVacancyDtoRequest.getEstimatedSalary(),
                deleteVacancyDtoRequest.getToken(),
                deleteVacancyDtoRequest.getRequirements()
        );
        dao.deleteVacancy(vacancy);
        return gson.toJson("");
    }
    // public String searchEmployee(String requestJsonStringsearchEmployer){}


}
