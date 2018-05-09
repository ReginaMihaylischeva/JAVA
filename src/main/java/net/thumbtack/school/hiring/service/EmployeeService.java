package net.thumbtack.school.hiring.service;

import com.google.gson.Gson;
import net.thumbtack.school.hiring.Models.*;

import net.thumbtack.school.hiring.daoimpl.DAO;
import net.thumbtack.school.hiring.error.serverException;
import net.thumbtack.school.hiring.request.*;
import net.thumbtack.school.hiring.response.AllVacanciesDtoResponse;
import net.thumbtack.school.hiring.response.GetVacansiesDtoResponse;
import net.thumbtack.school.hiring.response.RegisterEmployeeDtoResponse;

import java.util.UUID;

public class EmployeeService {
    private Gson gson = new Gson();
    private DAO dao = new DAO();

    public String registerEmployee(String requestJsonStringEmployee)  {
        RegisterEmployeeDtoRequest registerEmployeeDtoRequest = gson.fromJson(requestJsonStringEmployee, RegisterEmployeeDtoRequest.class);
        if (!registerEmployeeDtoRequest.validate().equals("")) {
         Error codeError=   new Error( registerEmployeeDtoRequest.validate());
            return gson.toJson( codeError);


        }
        Employee newEmployee = new Employee(
                registerEmployeeDtoRequest.getFirstName(),
                registerEmployeeDtoRequest.getLogin(),
                registerEmployeeDtoRequest.getPassword(),
                registerEmployeeDtoRequest.getLastName(),
                registerEmployeeDtoRequest.getMiddlename(),
                registerEmployeeDtoRequest.getAge(),
                registerEmployeeDtoRequest.getEmail(),
                registerEmployeeDtoRequest.isActivity(),
                UUID.randomUUID().toString()
        );
        try {

            RegisterEmployeeDtoResponse registerEmployeeDtoResponse = new RegisterEmployeeDtoResponse(dao.insert(newEmployee));

            return gson.toJson(registerEmployeeDtoResponse);
        }catch (serverException ex ){
            return   gson.toJson(new Error(ex.getErrorCode().getErrorString()));
        }





    }


    public String addSummary(String requestJsonStringAddSummary) {
        AddSummaryDtoRequest addsummaryDtoRequest = gson.fromJson(requestJsonStringAddSummary, AddSummaryDtoRequest.class);
        if (!addsummaryDtoRequest.validate().equals("")) {

            return gson.toJson(addsummaryDtoRequest.validate());

        }

        Summary summary = new Summary(

                addsummaryDtoRequest.getSkills(),
                addsummaryDtoRequest.getToken());
        dao.addSummary(summary);
        return gson.toJson("");
    }

    public String getVacancies(String requestJsonStringGetVacancies) {
        getVacanciesDtoRequest GetVacanciesDtoRequest = gson.fromJson(requestJsonStringGetVacancies, getVacanciesDtoRequest.class);
        if (!GetVacanciesDtoRequest.validate().equals("")) {
            return gson.toJson(GetVacanciesDtoRequest.validate());


        }
        CriteriaEmployer CriteriaEmployer = new CriteriaEmployer(

                GetVacanciesDtoRequest.getSkills(),
                GetVacanciesDtoRequest.getToken(),
                GetVacanciesDtoRequest.isCompulsion(),
                GetVacanciesDtoRequest.isCheckAllSkills()
        );


        GetVacansiesDtoResponse getVacansiesDtoResponse = new GetVacansiesDtoResponse(dao.getVacancies(CriteriaEmployer));
        return gson.toJson(getVacansiesDtoResponse);

    }

    public String deleteEmployee(String requestJsonStringDeleteEmployee) {
        DeleteDtoRequest deleteEmployee = gson.fromJson(requestJsonStringDeleteEmployee, DeleteDtoRequest.class);
        if (!deleteEmployee.validate().equals("")) {
            return gson.toJson(deleteEmployee.validate());


        }
        Delete DeleteEmployee = new Delete(

                deleteEmployee.getToken());
        try {
            dao.delete(DeleteEmployee);
        }catch (serverException user_does_not_exist ){
            return gson.toJson(new Error(user_does_not_exist));
        }


        return gson.toJson(" ");
    }

    public String deleteSummary(String requestJsonStringDeleteSummary) {
        DeleteDtoRequest deleteSummary = gson.fromJson(requestJsonStringDeleteSummary, DeleteDtoRequest.class);
        if (!deleteSummary.validate().equals("")) {
            return gson.toJson(deleteSummary.validate());

        }
        Delete DeleteSummary = new Delete(
                deleteSummary.getToken());


        try {
            dao.deleteSummary(DeleteSummary);
        }catch (serverException summary_does_not_exist ){
            return gson.toJson(new Error(summary_does_not_exist));
        }
        return gson.toJson("");

    }


    public String allVacancies(String requestJsonAllVacancies) {
        AllVacanciesDtoRequest allVacancies = gson.fromJson(requestJsonAllVacancies, AllVacanciesDtoRequest.class);
        if (!allVacancies.validate().equals("")) {
            return gson.toJson(allVacancies.validate());


        }
        Vacancy vacancies = new Vacancy(
                allVacancies.isActivity(),
                allVacancies.getEstimatedSalary(),
                allVacancies.getJobTitle(),
                allVacancies.getRequirements(),
                allVacancies.getToken()
        );
        AllVacanciesDtoResponse allVacanciesDtoResponse = new AllVacanciesDtoResponse(dao.AllVacancies(vacancies));

        return gson.toJson(allVacanciesDtoResponse);
    }

    public String editSummary(String requestJsonStringEditSummary) {
        AddSummaryDtoRequest editResume = gson.fromJson(requestJsonStringEditSummary, AddSummaryDtoRequest.class);
        if (!editResume.validate().equals("")) {
            return gson.toJson(editResume.validate());

        }


      Summary editSummary = new Summary(
              editResume.getSkills(),
              editResume.getToken()

        );
        try {
            dao.editSummary(editSummary);
        } catch (serverException summary_does_not_exist) {
            return gson.toJson(new Error(summary_does_not_exist));
        }


        return gson.toJson(" ");
    }

}
