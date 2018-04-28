package net.thumbtack.school.hiring.service;

import com.google.gson.Gson;
import net.thumbtack.school.hiring.Models.DeleteEmployee;
import net.thumbtack.school.hiring.Models.DeleteSummary;
import net.thumbtack.school.hiring.Models.Employee;
import net.thumbtack.school.hiring.Models.Summary;
import net.thumbtack.school.hiring.request.AddSummaryDtoRequest;
import net.thumbtack.school.hiring.request.RegisterEmployeeDtoRequest;
import net.thumbtack.school.hiring.request.deleteEmployeeDtoRequest;
import net.thumbtack.school.hiring.request.deleteSummaryDtoRequest;

public class EmployeeService {
    Gson gson = new Gson();

    public String registerEmployee(String requestJsonStringEmployee) {
        RegisterEmployeeDtoRequest registerEmployeeDtoReques = gson.fromJson(requestJsonStringEmployee, RegisterEmployeeDtoRequest.class);
        if (registerEmployeeDtoReques.validate() != "error") {
            Employee employee = new Employee(
                    registerEmployeeDtoReques.getFirstName(),
                    registerEmployeeDtoReques.getLogin(),
                    registerEmployeeDtoReques.getPassword(),
                    registerEmployeeDtoReques.getLastName(),
                    registerEmployeeDtoReques.getMiddlename(),
                    registerEmployeeDtoReques.getAge(),
                    registerEmployeeDtoReques.getEmail());
        }
        return "error";
    }

    public String addSummary(String requestJsonStringaddsummary) {
        AddSummaryDtoRequest addsummaryDtoReques = gson.fromJson(requestJsonStringaddsummary, AddSummaryDtoRequest.class);
        if (addsummaryDtoReques.validate() != "error") {

            Summary summary = new Summary(

                    addsummaryDtoReques.getMachineLanguage(),
                    addsummaryDtoReques.getRating(),
                    addsummaryDtoReques.getToken());


        }
        return "error";
    }

    //public String getVacancies(String requestJsonStringgetVacancies) { }

    public String deleteEmployee(String requestJsonStringdeleteEmployee) {
        deleteEmployeeDtoRequest deleteEmployee = gson.fromJson(requestJsonStringdeleteEmployee, deleteEmployeeDtoRequest.class);
        if (deleteEmployee.validate() != "error") {
            DeleteEmployee DeleteEemployee = new DeleteEmployee(

                    deleteEmployee.getToken());

        }
        return "error";
    }

    public String deleteSummary(String requestJsonStringdeletesummary) {
        deleteSummaryDtoRequest deleteSummary = gson.fromJson(requestJsonStringdeletesummary, deleteSummaryDtoRequest.class);
        if (deleteSummary.validate() != "error") {
            Summary DeleteSummary = new Summary(
                    deleteSummary.getMachineLanguage(),
                    deleteSummary.getRating(),
                    deleteSummary.getToken());

        }
        return "error";
    }

   // public String searchEmployer(String requestJsonStringsearchEmployee) {}

}
