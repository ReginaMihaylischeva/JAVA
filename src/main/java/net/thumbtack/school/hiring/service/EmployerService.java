package net.thumbtack.school.hiring.service;

import com.google.gson.Gson;
import net.thumbtack.school.hiring.Models.*;
import net.thumbtack.school.hiring.daoimpl.DAO;
import net.thumbtack.school.hiring.error.serverException;
import net.thumbtack.school.hiring.request.*;
import net.thumbtack.school.hiring.response.AllSummaryDtoResponse;
import net.thumbtack.school.hiring.response.RegisterEmployerDtoResponse;
import net.thumbtack.school.hiring.response.getSummaryDtoResponse;

import java.util.UUID;


public class EmployerService {
    private Gson gson = new Gson();
    private DAO dao = new DAO();

    public String registerEmployer(String requestJsonStringEmployer) {
        RegisterEmployerDtoRequest registerEmployerDtoReques = gson.fromJson(requestJsonStringEmployer, RegisterEmployerDtoRequest.class);
        if (!registerEmployerDtoReques.validate().equals("")) {
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
                registerEmployerDtoReques.getCompanyName(),
                UUID.randomUUID().toString());
        try {
            RegisterEmployerDtoResponse registerEmployerDtoResponse = new RegisterEmployerDtoResponse(dao.InsertEmployer(employer));

            return gson.toJson(registerEmployerDtoResponse);
        } catch (serverException user_already_registered) {
            return gson.toJson(new Error(user_already_registered));
        }
    }

    public String addVacancy(String requestJsonStringAddVacancy) {
        AddVacancyDtoRequest addVacancyDtoRequest = gson.fromJson(requestJsonStringAddVacancy, AddVacancyDtoRequest.class);
        if (!addVacancyDtoRequest.validate().equals("")) {
            return gson.toJson(addVacancyDtoRequest.validate());
        }
        Vacancy vacancy = new Vacancy(
                addVacancyDtoRequest.getJobTitle(),
                addVacancyDtoRequest.getEstimatedSalary(),
                addVacancyDtoRequest.getToken(),
                addVacancyDtoRequest.getRequirements(),
                addVacancyDtoRequest.isActivity()
        );
        dao.addVacancy(vacancy);
        return gson.toJson("");
    }

    public String getSummary(String requestJsonStringGetSummary) {
        GetSummaryDtoRequest getSummaryDtoRequest = gson.fromJson(requestJsonStringGetSummary, GetSummaryDtoRequest.class);
        if (!getSummaryDtoRequest.validate().equals("")) {
            return gson.toJson(getSummaryDtoRequest.validate());
        }
        CriteriaEmployee requirements = new CriteriaEmployee(
                getSummaryDtoRequest.getRequirements(),
                getSummaryDtoRequest.getToken(),
                getSummaryDtoRequest.isCompulsion(),
                getSummaryDtoRequest.isCheckAllRequirements()


        );

        getSummaryDtoResponse GetSummaryDtoResponse = new getSummaryDtoResponse(dao.getSummary(requirements));
        return gson.toJson(GetSummaryDtoResponse);
    }

    public String deleteEmployer(String requestJsonStringdeleteEmployer) {
        DeleteDtoRequest deleteEmployer = gson.fromJson(requestJsonStringdeleteEmployer, DeleteDtoRequest.class);
        if (!deleteEmployer.validate().equals("")) {
            return gson.toJson(deleteEmployer.validate().equals(""));


        }
        Delete DeleteEmployee = new Delete(

                deleteEmployer.getToken());
        try {
            dao.deleteEmployer(DeleteEmployee);
            return gson.toJson("");
        } catch (serverException user_does_not_exist) {
            return gson.toJson(new Error(user_does_not_exist));
        }
    }

    public String deleteVacancy(String requestJsonStringDeleteVacancy) {
        DeleteDtoRequest deleteVacancyDtoRequest = gson.fromJson(requestJsonStringDeleteVacancy, DeleteDtoRequest.class);
        if (!deleteVacancyDtoRequest.validate().equals("")) {
            return gson.toJson(deleteVacancyDtoRequest.validate());
        }
        Delete vacancy = new Delete(

                deleteVacancyDtoRequest.getToken()
        );
        try {
            dao.deleteVacancy(vacancy);
            return gson.toJson("");

        } catch (serverException vacancy_does_not_exist) {
            return gson.toJson(new Error(vacancy_does_not_exist));
        }
    }

    public String allSummary(String requestJsonAllSummary) {
        AllSummaryDtoRequest allSummary = gson.fromJson(requestJsonAllSummary, AllSummaryDtoRequest.class);
        if (!allSummary.validate().equals("")) {
            return gson.toJson(allSummary.validate());
        }

        Summary Summary = new Summary(
                allSummary.getSkills(),
                allSummary.getToken()
        );
        AllSummaryDtoResponse allSummaryDtoResponse = new AllSummaryDtoResponse(dao.AllSummary(Summary));

        return gson.toJson(allSummaryDtoResponse);
    }

    public String editVacancy(String requestJsonStringEditVacancy) {
        AddVacancyDtoRequest editVacancyDtoRequest = gson.fromJson(requestJsonStringEditVacancy, AddVacancyDtoRequest.class);
        if (!editVacancyDtoRequest.validate().equals("")) {
            return gson.toJson(editVacancyDtoRequest.validate());
        }
        Vacancy editVacancy = new Vacancy(
                editVacancyDtoRequest.getJobTitle(),
                editVacancyDtoRequest.getEstimatedSalary(),
                editVacancyDtoRequest.getToken(),
                editVacancyDtoRequest.getRequirements(),
                editVacancyDtoRequest.isActivity()

        );
        try {
            dao.editVacancy(editVacancy);
            return gson.toJson("");
        } catch (serverException vacancy_does_not_exist) {
            return gson.toJson(new Error(vacancy_does_not_exist));
        }
    }

}
