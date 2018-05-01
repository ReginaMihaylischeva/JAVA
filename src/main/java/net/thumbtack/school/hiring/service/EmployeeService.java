package net.thumbtack.school.hiring.service;

import com.google.gson.Gson;
import net.thumbtack.school.hiring.Models.*;

import net.thumbtack.school.hiring.daoimpl.DAO;
import net.thumbtack.school.hiring.request.*;
import net.thumbtack.school.hiring.response.AllVacanciesDtoResponse;
import net.thumbtack.school.hiring.response.GetVacansiesDtoResponse;
import net.thumbtack.school.hiring.response.RegisterEmployeeDtoResponse;

import java.util.UUID;

public class EmployeeService {
    private Gson gson = new Gson();
    private DAO dao =new DAO();
    public String registerEmployee(String requestJsonStringEmployee) {
        RegisterEmployeeDtoRequest registerEmployeeDtoReques = gson.fromJson(requestJsonStringEmployee, RegisterEmployeeDtoRequest.class);
        if (registerEmployeeDtoReques.validate().equals( "error")) {
            return  gson.toJson("error");


        }
        Employee newEmployee = new Employee(
                registerEmployeeDtoReques.getFirstName(),
                registerEmployeeDtoReques.getLogin(),
                registerEmployeeDtoReques.getPassword(),
                registerEmployeeDtoReques.getLastName(),
                registerEmployeeDtoReques.getMiddlename(),
                registerEmployeeDtoReques.getAge(),
                registerEmployeeDtoReques.getEmail()
                );


        RegisterEmployeeDtoResponse registerEmployeeDtoResponse= new RegisterEmployeeDtoResponse(dao.insert(newEmployee ).toString());

      return   gson.toJson( registerEmployeeDtoResponse);

    }




    public String addSummary(String requestJsonStringaddsummary) {
        AddSummaryDtoRequest addsummaryDtoReques = gson.fromJson(requestJsonStringaddsummary, AddSummaryDtoRequest.class);
        if (addsummaryDtoReques.validate().equals( "error")) {

            return  gson.toJson("error");

        }

        Summary summary = new Summary(

                addsummaryDtoReques.getSkills(),
                addsummaryDtoReques.getToken());
        dao.addSummary(summary);
        return  gson.toJson(" ");
    }

    public String GetVacancies(String requestJsonStringgetVacancies) {
    getVacanciesDtoRequest GetVacanciesDtoRequest = gson.fromJson(requestJsonStringgetVacancies, getVacanciesDtoRequest.class);
    if (GetVacanciesDtoRequest.validate().equals( "error")) {
       return  gson.toJson("error");



    }
        getVacancies GetVacancies = new getVacancies(

                GetVacanciesDtoRequest.getSkills(),
                GetVacanciesDtoRequest.getToken(),
                GetVacanciesDtoRequest.isCompulsion(),
                GetVacanciesDtoRequest.isCheckAllSkills());
        GetVacansiesDtoResponse getVacansiesDtoResponse=new  GetVacansiesDtoResponse(dao.getVacancies(GetVacancies));
   return   gson.toJson(getVacansiesDtoResponse);

     }

    public String deleteEmployee(String requestJsonStringdeleteEmployee) {
        deleteEmployeeDtoRequest deleteEmployee = gson.fromJson(requestJsonStringdeleteEmployee, deleteEmployeeDtoRequest.class);
        if (deleteEmployee.validate().equals("error")) {
            return  gson.toJson("error");


        }
        DeleteEmployee DeleteEemployee = new DeleteEmployee(

                deleteEmployee.getToken());
        dao.delete(DeleteEemployee);
        return  gson.toJson(" ");
    }

    public String deleteSummary(String requestJsonStringdeletesummary) {
        deleteSummaryDtoRequest deleteSummary = gson.fromJson(requestJsonStringdeletesummary, deleteSummaryDtoRequest.class);
        if (deleteSummary.validate() .equals( "error")) {
            return  gson.toJson("error");

        }
        Summary DeleteSummary = new Summary(
                deleteSummary.getSkills(),
                deleteSummary.getToken());
       dao.deleteSummary(DeleteSummary);
        return  gson.toJson(" ");

    }


    public String  AllVacancies(String requestJsonAllVacancies) {
        AllVacanciesDtoRequest allVacancies = gson.fromJson(requestJsonAllVacancies, AllVacanciesDtoRequest.class);
        if (allVacancies.validate() .equals( "error")) {
            return  gson.toJson("error");


        }
        AllVacancies vacancies = new AllVacancies(
                allVacancies.getAllVacancies()
        );
        AllVacanciesDtoResponse allVacanciesDtoResponse=new AllVacanciesDtoResponse(dao.AllVacancies(vacancies));

        return   gson.toJson(allVacanciesDtoResponse);
    }

}
