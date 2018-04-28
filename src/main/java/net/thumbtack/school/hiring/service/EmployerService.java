package net.thumbtack.school.hiring.service;

import com.google.gson.Gson;
import net.thumbtack.school.hiring.Models.DeleteEmployer;
import net.thumbtack.school.hiring.Models.Employer;
import net.thumbtack.school.hiring.Models.Vacancy;
import net.thumbtack.school.hiring.request.AddVacancyDtoRequest;
import net.thumbtack.school.hiring.request.RegisterEmployerDtoRequest;
import net.thumbtack.school.hiring.request.deleteEmployerDtoRequest;
import net.thumbtack.school.hiring.request.deleteVacancyDtoRequest;

public class EmployerService {
    private Gson gson = new Gson();
    public String registerEmployer(String requestJsonStringEmployer){
        RegisterEmployerDtoRequest registerEmployerDtoReques = gson.fromJson(requestJsonStringEmployer, RegisterEmployerDtoRequest.class);
        if (registerEmployerDtoReques.validate() != "error") {
            Employer employer = new Employer(
                    registerEmployerDtoReques.getFirstName(),
                    registerEmployerDtoReques.getLogin(),
                    registerEmployerDtoReques.getPassword(),
                    registerEmployerDtoReques.getLastName(),
                    registerEmployerDtoReques.getMiddlename(),
                    registerEmployerDtoReques.getEmail(),
                    registerEmployerDtoReques.getAddress(),
                    registerEmployerDtoReques.getCompanyName());

        }
        return "error";
    }
    public String addVacancy(String requestJsonStringaddVacancy){
        AddVacancyDtoRequest addVacancyDtoRequest=gson.fromJson(requestJsonStringaddVacancy, AddVacancyDtoRequest.class);
        if (addVacancyDtoRequest.validate() != "error") {
            Vacancy vacancy= new Vacancy(
                    addVacancyDtoRequest.getJobTitle(),
                    addVacancyDtoRequest.getEstimatedSalary(),
                    addVacancyDtoRequest.getToken(),
                    addVacancyDtoRequest.getRequirements()
            );
        }
        return "error";
    }
   // public String getsummary (String requestJsonStringgetsummary){}
    public String deleteEmployer(String requestJsonStringdeleteEmployer){
        deleteEmployerDtoRequest deleteEmployee = gson.fromJson(requestJsonStringdeleteEmployer, deleteEmployerDtoRequest.class);
        if (deleteEmployee.validate() != "error") {
            DeleteEmployer DeleteEemployee = new DeleteEmployer(

                    deleteEmployee.getToken());

        }
        return "error";
    }
    public String deleteVacancy(String requestJsonStringdeleteVacancy){
        deleteVacancyDtoRequest deleteVacancyDtoRequest=gson.fromJson(requestJsonStringdeleteVacancy, deleteVacancyDtoRequest.class);
        if (deleteVacancyDtoRequest.validate() != "error") {
            Vacancy vacancy= new Vacancy(
                    deleteVacancyDtoRequest.getJobTitle(),
                    deleteVacancyDtoRequest.getEstimatedSalary(),
                    deleteVacancyDtoRequest.getToken(),
                    deleteVacancyDtoRequest.getRequirements()
            );
        }
        return "error";
    }
   // public String searchEmployee(String requestJsonStringsearchEmployer){}


}
