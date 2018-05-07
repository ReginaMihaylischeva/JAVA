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
        getVacancies GetVacancies = new getVacancies(

                GetVacanciesDtoRequest.getSkills(),
                GetVacanciesDtoRequest.getToken(),
                GetVacanciesDtoRequest.isCompulsion(),
                GetVacanciesDtoRequest.isCheckAllSkills()
        );


        GetVacansiesDtoResponse getVacansiesDtoResponse = new GetVacansiesDtoResponse(dao.getVacancies(GetVacancies));
        return gson.toJson(getVacansiesDtoResponse);

    }

    public String deleteEmployee(String requestJsonStringDeleteEmployee) {
        deleteEmployeeDtoRequest deleteEmployee = gson.fromJson(requestJsonStringDeleteEmployee, deleteEmployeeDtoRequest.class);
        if (!deleteEmployee.validate().equals("")) {
            return gson.toJson(deleteEmployee.validate());


        }
        DeleteEmployee DeleteEemployee = new DeleteEmployee(

                deleteEmployee.getToken());
        try {
            dao.delete(DeleteEemployee);
        }catch (serverException user_does_not_exist ){
            return gson.toJson(new Error(user_does_not_exist));
        }


        return gson.toJson(" ");
    }

    public String deleteSummary(String requestJsonStringDeleteSummary) {
        deleteSummaryDtoRequest deleteSummary = gson.fromJson(requestJsonStringDeleteSummary, deleteSummaryDtoRequest.class);
        if (!deleteSummary.validate().equals("")) {
            return gson.toJson(deleteSummary.validate());

        }
        Summary DeleteSummary = new Summary(
                deleteSummary.getSkills(),
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
        AllVacancies vacancies = new AllVacancies(
                allVacancies.getAllVacancies(),
                allVacancies.getActivity()
        );
        AllVacanciesDtoResponse allVacanciesDtoResponse = new AllVacanciesDtoResponse(dao.AllVacancies(vacancies));

        return gson.toJson(allVacanciesDtoResponse);
    }

    public String editSummary(String requestJsonStringEditSummary) {
        EditSummaryDtoRequest editResumes = gson.fromJson(requestJsonStringEditSummary, EditSummaryDtoRequest.class);
        if (!editResumes.validate().equals("")) {
            return gson.toJson(editResumes.validate());

        }
        EditSummary editSummary = new EditSummary(
                editResumes.getNewSkills(),
                editResumes.getOldSkills(),
                editResumes.getToken()

        );
        try {
            dao.editSummary(editSummary);
        } catch (serverException summary_does_not_exist) {
            return gson.toJson(new Error(summary_does_not_exist));
        }


        return gson.toJson(" ");
    }

}
