package net.thumbtack.school.hiring.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.thumbtack.school.hiring.DataBase.DataBase;
import net.thumbtack.school.hiring.Models.*;
import net.thumbtack.school.hiring.error.ServerErrorCode;
import net.thumbtack.school.hiring.error.serverException;
import net.thumbtack.school.hiring.request.*;
import net.thumbtack.school.hiring.response.GetVacansiesDtoResponse;
import net.thumbtack.school.hiring.response.RegisterEmployeeDtoResponse;
import net.thumbtack.school.hiring.response.RegisterEmployerDtoResponse;
import org.junit.Test;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestEmployeeService {
    private Gson gson = new Gson();

    @Test
    public void testRegisterEmployee() {
        DataBase.getInstance().getDataBaseEmployee().clear();

        RegisterEmployeeDtoRequest request = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", 45, "Ivan@ads", true);
        String jsonRequest = gson.toJson(request);
        EmployeeService employeeService = new EmployeeService();

        String jsonResult = employeeService.registerEmployee(jsonRequest);
        RegisterEmployeeDtoResponse result = gson.fromJson(jsonResult, RegisterEmployeeDtoResponse.class);
        Map<String, Employee> database = DataBase.getInstance().getDataBaseEmployee();
        assertTrue(database.containsKey(result.getToken()));
        assertEquals(database.get(result.getToken()).getLogin(), "Ivan");
       assertEquals(database.get(result.getToken()).getEmail(), "Ivan@ads");
        assertEquals(database.get(result.getToken()).getFirstName(), "Иван");
        assertEquals(database.get(result.getToken()).getLastName(), "Иванов");
        assertEquals(database.get(result.getToken()).getMiddlename(), "");
        assertEquals(database.get(result.getToken()).getPassword(), "123456");
        assertEquals(database.get(result.getToken()).getAge(), 45);
        assertEquals(database.get(result.getToken()).isActivity(), true);


    }

    @Test
    public void testRegisterEmployeeWithError() {

        RegisterEmployeeDtoRequest request = new RegisterEmployeeDtoRequest(
                "", "Ivan", "123456", "Иванов",
                "", 45, "Ivan@ads", true);
        String jsonRequest = gson.toJson(request);
        EmployeeService employeeService = new EmployeeService();
        String jsonResult = employeeService.registerEmployee(jsonRequest);
        Error result = gson.fromJson(jsonResult, Error.class);
        assertEquals(result.getMessage(), "Empty first name");
        RegisterEmployeeDtoRequest request1 = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", -35, "Ivan@ads", true);
        String jsonRequest1 = gson.toJson(request1);
        String jsonResult1 = employeeService.registerEmployee(jsonRequest1);
        Error result1 = gson.fromJson(jsonResult1, Error.class);
        assertEquals(result1.getMessage(), "not correct age");
    }

    @Test
    public void testRegisterEmployeeWithException() {
        EmployeeService employeeService = new EmployeeService();

        RegisterEmployeeDtoRequest Employee1 = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", 45, "Ivan@ads", true);
        RegisterEmployeeDtoRequest Employee2 = new RegisterEmployeeDtoRequest(
                "Вася", "Ivan", "123487", "Васильев",
                "", 65, "Vasya@ads", true);
        String jsonRequest = gson.toJson(Employee2);
        employeeService.registerEmployee(jsonRequest);
        String jsonRequest2 = gson.toJson(Employee1);
        String jsonResult2 = employeeService.registerEmployee(jsonRequest2);
        Error result1 = gson.fromJson(jsonResult2, Error.class);
        assertEquals("User already registered", result1.getMessage());
    }

    @Test
    public void testAddSummary() {
        DataBase.getInstance().getDataBaseSummary(). clear();
        DataBase.getInstance().getDataBaseEmployee().clear();
        EmployeeService employeeService = new EmployeeService();

        RegisterEmployeeDtoRequest Employee1 = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", 45, "Ivan@ads", true);
        String jsonRequest = gson.toJson(Employee1);
        String jsonResult = employeeService.registerEmployee(jsonRequest);
        RegisterEmployeeDtoResponse result = gson.fromJson(jsonResult, RegisterEmployeeDtoResponse.class);
        Skills skill1 = new Skills("Java", 2);
        Skills skill2 = new Skills("C#", 4);
        Skills skill3 = new Skills("Python", 3);
        List<Skills> skills = new ArrayList<>();
        skills.add(skill1);
        skills.add(skill2);
        skills.add(skill3);
        AddSummaryDtoRequest Summary = new AddSummaryDtoRequest(skills, result.getToken());
        String jsonRequest1 = gson.toJson(Summary);
        String jsonResult2 = employeeService.addSummary(jsonRequest1);
        String result1 = gson.fromJson(jsonResult2, String.class);
        assertEquals("", result1);
    }

    @Test
    public void testAddAndEditSummaryWithError() {
        DataBase.getInstance().getDataBaseSummary(). clear();
        DataBase.getInstance().getDataBaseEmployee().clear();
        EmployeeService employeeService = new EmployeeService();

        RegisterEmployeeDtoRequest Employee1 = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", 45, "Ivan@ads", true);
        String jsonRequest = gson.toJson(Employee1);
        String jsonResult = employeeService.registerEmployee(jsonRequest);
        RegisterEmployeeDtoResponse result = gson.fromJson(jsonResult, RegisterEmployeeDtoResponse.class);
        Skills skill1 = new Skills("Java", 2);
        Skills skill2 = new Skills("C#", -12);
        Skills skill3 = new Skills("Python", 3);
        List<Skills> skills = new ArrayList<>();
        skills.add(skill1);
        skills.add(skill2);
        skills.add(skill3);
        AddSummaryDtoRequest Summary = new AddSummaryDtoRequest(skills, result.getToken());
        String jsonRequest1 = gson.toJson(Summary);
        String jsonResult2 = employeeService.addSummary(jsonRequest1);
        String result1 = gson.fromJson(jsonResult2, String.class);
        assertEquals("not correct level Proficiency", result1);
        Skills skill4 = new Skills("", 3);
        skills.remove(skill2);
        skills.add(skill4);

        String jsonRequest3 = gson.toJson(Summary);
        String jsonResult3 = employeeService.editSummary(jsonRequest3);
        String result3 = gson.fromJson(jsonResult3, String.class);
        assertEquals("Requirement is empty", result3);

    }


    @Test
    public void testDeleteEmployee() {
        DataBase.getInstance().getDataBaseEmployee().clear();
        EmployeeService employeeService = new EmployeeService();

        RegisterEmployeeDtoRequest Employee = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", 45, "Ivan@ads", true);
        String jsonRequest = gson.toJson(Employee);
        String jsonResult = employeeService.registerEmployee(jsonRequest);
        RegisterEmployeeDtoResponse result = gson.fromJson(jsonResult, RegisterEmployeeDtoResponse.class);

        DeleteDtoRequest deleteEmployee = new DeleteDtoRequest(result.getToken());
        String jsonRequest1 = gson.toJson(deleteEmployee);


        String jsonResultDelete = employeeService.deleteEmployee(jsonRequest1);
        String result1 = gson.fromJson(jsonResultDelete, String.class);
        assertEquals("", result1);


    }

    @Test
    public void testDeleteEmployeeWithException() {
        EmployeeService employeeService = new EmployeeService();

        DeleteDtoRequest deleteEmployee = new DeleteDtoRequest(UUID.randomUUID().toString());
        String jsonRequest2 = gson.toJson(deleteEmployee);
        String jsonResultDelete = employeeService.deleteEmployee(jsonRequest2);
        Error result1 = gson.fromJson(jsonResultDelete, Error.class);
        assertEquals("User does not exist", result1.getMessage());
    }

    @Test
    public void testDeleteSummary() {
        EmployeeService employeeService = new EmployeeService();
        DeleteDtoRequest deleteEmployee = new DeleteDtoRequest(UUID.randomUUID().toString());
        String jsonRequest2 = gson.toJson(deleteEmployee);
        String jsonResultDelete = employeeService.deleteSummary(jsonRequest2);
        Error result1 = gson.fromJson(jsonResultDelete, Error.class);
        assertEquals("Summary does not exist", result1.getMessage());
    }

    @Test
    public void testGetVacancies2() {
        DataBase.getInstance().getDataBaseVacancies(). clear();
        DataBase.getInstance().getDataBaseEmployer().clear();
        EmployeeService employeeService = new EmployeeService();
        EmployerService employerService = new EmployerService();

        Skills skill1 = new Skills("Java", 3);
        Skills skill2 = new Skills("C#", 5);
        Skills skill3 = new Skills("Python", 3);
        List<Skills> skills = new ArrayList<>();
        skills.add(skill1);
        skills.add(skill2);
        skills.add(skill3);

        RegisterEmployerDtoRequest Employer1 = new RegisterEmployerDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", "ул. Маршала Жукова, 21", "Тамтэк", "Ivan@ads");
        String jsonRequst = gson.toJson(Employer1);
        String jsonResult = employerService.registerEmployer(jsonRequst);
        RegisterEmployerDtoResponse result = gson.fromJson(jsonResult, RegisterEmployerDtoResponse.class);


        Requirements Requirement1 = new Requirements("Java", true, 2);
        Requirements Requirement2 = new Requirements("C#", false, 4);
        Requirements Requirement3 = new Requirements("Python", true, 3);
        List<Requirements> Requirement = new ArrayList<>();
        Requirement.add(Requirement1);
        Requirement.add(Requirement2);
        Requirement.add(Requirement3);
        AddVacancyDtoRequest Vacancy = new AddVacancyDtoRequest("Developer", 1234, result.getToken(), Requirement, "yes");
        employerService.addVacancy(gson.toJson(Vacancy));



        getVacanciesDtoRequest Vacancies=new getVacanciesDtoRequest(skills,UUID.randomUUID().toString(),true,true);
        String jsonRequestGetVacancies = gson.toJson(Vacancies);
        String jsonResultGetVacanciese = employeeService.getVacancies(jsonRequestGetVacancies);
        GetVacansiesDtoResponse resultGetVacanciese=gson.fromJson(jsonResultGetVacanciese, GetVacansiesDtoResponse.class);
        assertTrue(resultGetVacanciese.getVacancies().size()==1);
        assertEquals(resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(1).getNameRequirement(),Requirement.get(1).getNameRequirement() );
        assertEquals(resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(1).getLevelProficiency(),Requirement.get(1).getLevelProficiency() );
        assertEquals(resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(2).getNameRequirement(),Requirement.get(2).getNameRequirement() );
        assertEquals(resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(2).getLevelProficiency(),Requirement.get(2).getLevelProficiency() );
        assertEquals(resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(0).getNameRequirement(),Requirement.get(0).getNameRequirement() );
        assertEquals(resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(0).getLevelProficiency(),Requirement.get(0).getLevelProficiency() );


    }

    @Test
    public void testGetVacancies1() {
       // DataBase.getInstance().getDataBaseVacancies(). clear();
      //  DataBase.getInstance().getDataBaseEmployer().clear();
        EmployeeService employeeService = new EmployeeService();
        EmployerService employerService = new EmployerService();

        Skills skill1 = new Skills("Java", 2);
        Skills skill2 = new Skills("C#", 5);
        Skills skill3 = new Skills("Python", 4);
        List<Skills> skills = new ArrayList<>();
        skills.add(skill1);
        skills.add(skill2);
        skills.add(skill3);

        RegisterEmployerDtoRequest Employer1 = new RegisterEmployerDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", "ул. Маршала Жукова, 21", "Тамтэк", "Ivan@ads");
        String jsonResult = employerService.registerEmployer(gson.toJson(Employer1));
        RegisterEmployerDtoResponse result = gson.fromJson(jsonResult, RegisterEmployerDtoResponse.class);

        Requirements Requirement1 = new Requirements("Java", true, 2);
        Requirements Requirement2 = new Requirements("C#", false, 4);
        Requirements Requirement3 = new Requirements("Python", true, 3);
        List<Requirements> Requirement = new ArrayList<>();
        Requirement.add(Requirement1);
        Requirement.add(Requirement2);
        Requirement.add(Requirement3);
        AddVacancyDtoRequest Vacancy = new AddVacancyDtoRequest("Developer", 1234, result.getToken(), Requirement, "yes");
        String jsonRequestAddVacancy = gson.toJson(Vacancy);
        employerService.addVacancy(jsonRequestAddVacancy);



        getVacanciesDtoRequest Vacancies=new getVacanciesDtoRequest(skills,UUID.randomUUID().toString(),false,true);
        String jsonRequestGetVacancies = gson.toJson(Vacancies);
        String jsonResultGetVacanciese = employeeService.getVacancies(jsonRequestGetVacancies);
        GetVacansiesDtoResponse resultGetVacanciese=gson.fromJson(jsonResultGetVacanciese, GetVacansiesDtoResponse.class);
        assertTrue(resultGetVacanciese.getVacancies().size()==1);
        assertEquals(Requirement.get(1).getNameRequirement(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(1).getNameRequirement() );
        assertEquals(Requirement.get(1).getLevelProficiency(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(1).getLevelProficiency() );
        assertEquals(Requirement.get(2).getNameRequirement() ,resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(2).getNameRequirement());
        assertEquals(Requirement.get(2).getLevelProficiency(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(2).getLevelProficiency() );
        assertEquals(Requirement.get(0).getNameRequirement(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(0).getNameRequirement() );
        assertEquals(Requirement.get(0).getLevelProficiency(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(0).getLevelProficiency() );


    }

    @Test
    public void  testGetVacancies3(){
        DataBase.getInstance().getDataBaseVacancies(). clear();
        DataBase.getInstance().getDataBaseEmployer().clear();
        EmployeeService employeeService = new EmployeeService();
        EmployerService employerService = new EmployerService();

        Skills skill1 = new Skills("Java", 0);
        Skills skill2 = new Skills("C#", 0);
        Skills skill3 = new Skills("Python", 0);
        List<Skills> skills = new ArrayList<>();
        skills.add(skill1);
        skills.add(skill2);
        skills.add(skill3);

        RegisterEmployerDtoRequest Employer1 = new RegisterEmployerDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", "ул. Маршала Жукова, 21", "Тамтэк", "Ivan@ads");
        String jsonRequst = gson.toJson(Employer1);
        String jsonResult = employerService.registerEmployer(jsonRequst);
        RegisterEmployerDtoResponse result = gson.fromJson(jsonResult, RegisterEmployerDtoResponse.class);

        Requirements Requirement1 = new Requirements("Java", true, 2);
        Requirements Requirement2 = new Requirements("C#", false, 4);
        Requirements Requirement3 = new Requirements("Python", true, 3);
        List<Requirements> Requirement = new ArrayList<>();
        Requirement.add(Requirement1);
        Requirement.add(Requirement2);
        Requirement.add(Requirement3);
        AddVacancyDtoRequest Vacancy = new AddVacancyDtoRequest("Developer", 1234, result.getToken(), Requirement, "yes");
        String jsonRequestAddVacancy = gson.toJson(Vacancy);
        employerService.addVacancy(jsonRequestAddVacancy);



        getVacanciesDtoRequest Vacancies=new getVacanciesDtoRequest(skills,UUID.randomUUID().toString(),false,true);
        String jsonRequestGetVacancies = gson.toJson(Vacancies);
        String jsonResultGetVacanciese = employeeService.getVacancies(jsonRequestGetVacancies);
        GetVacansiesDtoResponse resultGetVacanciese=gson.fromJson(jsonResultGetVacanciese, GetVacansiesDtoResponse.class);
        assertTrue(resultGetVacanciese.getVacancies().size()==1);
        assertEquals(Requirement.get(1).getNameRequirement(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(1).getNameRequirement() );
        assertEquals(Requirement.get(1).getLevelProficiency(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(1).getLevelProficiency() );
        assertEquals(Requirement.get(2).getNameRequirement(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(2).getNameRequirement() );
        assertEquals(Requirement.get(2).getLevelProficiency(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(2).getLevelProficiency() );
        assertEquals(Requirement.get(0).getNameRequirement(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(0).getNameRequirement() );
        assertEquals(Requirement.get(0).getLevelProficiency(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(0).getLevelProficiency() );
    }
    @Test
    public void  testGetVacancies4(){
        DataBase.getInstance().getDataBaseVacancies(). clear();
        DataBase.getInstance().getDataBaseEmployer().clear();
        EmployeeService employeeService = new EmployeeService();
        EmployerService employerService = new EmployerService();

        Skills skill1 = new Skills("Java", 5);
        Skills skill2 = new Skills("C#", 5);
        Skills skill3 = new Skills("Python", 3);
        List<Skills> skills = new ArrayList<>();
        skills.add(skill1);
        skills.add(skill2);
        skills.add(skill3);

        RegisterEmployerDtoRequest Employer1 = new RegisterEmployerDtoRequest("Иван", "Ivan", "123456", "Иванов",
                "", "ул. Маршала Жукова, 21", "Тамтэк", "Ivan@ads");
        String jsonResult = employerService.registerEmployer(gson.toJson(Employer1));
        RegisterEmployerDtoResponse result = gson.fromJson(jsonResult, RegisterEmployerDtoResponse.class);

        Requirements Requirement1 = new Requirements("Java", true, 2);
        Requirements Requirement2 = new Requirements("C#", false, 4);
        Requirements Requirement3 = new Requirements("Python", true, 3);
        List<Requirements> Requirement = new ArrayList<>();
        Requirement.add(Requirement1);
        Requirement.add(Requirement2);
        Requirement.add(Requirement3);
        AddVacancyDtoRequest Vacancy = new AddVacancyDtoRequest("Developer", 1234, result.getToken(), Requirement, "yes");
        employerService.addVacancy(gson.toJson(Vacancy));

        RegisterEmployerDtoRequest Employer2 = new RegisterEmployerDtoRequest("Иван", "Ivan1", "123456", "Иванов",
                "", "ул. Маршала Жукова, 21", "Тамтэк", "Ivan@ads");
        String jsonResult1 = employerService.registerEmployer(gson.toJson(Employer2));
        RegisterEmployerDtoResponse result1 = gson.fromJson(jsonResult1, RegisterEmployerDtoResponse.class);

        Requirements Requirement11 = new Requirements("Java", true, 2);
        Requirements Requirement21 = new Requirements("C#", false, 4);
        Requirements Requirement31 = new Requirements("Py", true, 3);
        List<Requirements> Requirement10 = new ArrayList<>();
        Requirement10.add(Requirement11);
        Requirement10.add(Requirement21);
        Requirement10.add(Requirement31);
        AddVacancyDtoRequest Vacancy1 = new AddVacancyDtoRequest("Developer", 1234, result1.getToken(), Requirement10, "yes");
        employerService.addVacancy(gson.toJson(Vacancy1));

        RegisterEmployerDtoRequest Employer3 = new RegisterEmployerDtoRequest("Иван", "Ivan2", "123456", "Иванов",
                "", "ул. Маршала Жукова, 21", "Тамтэк", "Ivan@ads");
        String jsonResult2 = employerService.registerEmployer(gson.toJson(Employer3));
        RegisterEmployerDtoResponse result2 = gson.fromJson(jsonResult2, RegisterEmployerDtoResponse.class);

        Requirements Requirement12 = new Requirements("Java", true, 2);
        Requirements Requirement22 = new Requirements("C", false, 4);
        Requirements Requirement32 = new Requirements("Py", true, 3);
        List<Requirements> Requirement20 = new ArrayList<>();
        Requirement20.add(Requirement12);
        Requirement20.add(Requirement22);
        Requirement20.add(Requirement32);
        AddVacancyDtoRequest Vacancy2 = new AddVacancyDtoRequest("Developer", 1234, result2.getToken(), Requirement20, "yes");
        employerService.addVacancy(gson.toJson(Vacancy2));

        getVacanciesDtoRequest Vacancies=new getVacanciesDtoRequest(skills,UUID.randomUUID().toString(),false,false);
        String jsonRequestGetVacancies = gson.toJson(Vacancies);
        String jsonResultGetVacanciese = employeeService.getVacancies(jsonRequestGetVacancies);
        GetVacansiesDtoResponse resultGetVacanciese=gson.fromJson(jsonResultGetVacanciese, GetVacansiesDtoResponse.class);
        assertTrue(resultGetVacanciese.getVacancies().size()==3);

        assertEquals(Requirement.get(0).getNameRequirement(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(0).getNameRequirement() );
        assertEquals(Requirement.get(1).getNameRequirement(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(1).getNameRequirement() );
        assertEquals(Requirement.get(2).getNameRequirement(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(2).getNameRequirement());
        resultGetVacanciese.getVacancies().removeFirst();

        assertEquals(Requirement10.get(0).getNameRequirement(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(0).getNameRequirement() );
        assertEquals(Requirement10.get(1).getNameRequirement(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(1).getNameRequirement() );
        assertEquals(Requirement10.get(2).getNameRequirement(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(2).getNameRequirement() );
        resultGetVacanciese.getVacancies().removeFirst();

        assertEquals(Requirement20.get(0).getNameRequirement(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(0).getNameRequirement() );
        assertEquals(Requirement20.get(1).getNameRequirement(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(1).getNameRequirement());
        assertEquals(Requirement20.get(2).getNameRequirement(),resultGetVacanciese.getVacancies().getFirst().getRequirements().getRequirements().get(2).getNameRequirement() );
    }

}
