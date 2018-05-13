package net.thumbtack.school.hiring.service;

import com.google.gson.Gson;
import net.thumbtack.school.hiring.DataBase.DataBase;
import net.thumbtack.school.hiring.Models.Employer;
import net.thumbtack.school.hiring.Models.Requirements;
import net.thumbtack.school.hiring.Models.Skills;
import net.thumbtack.school.hiring.request.*;
import net.thumbtack.school.hiring.response.RegisterEmployeeDtoResponse;
import net.thumbtack.school.hiring.response.RegisterEmployerDtoResponse;
import net.thumbtack.school.hiring.response.getSummaryDtoResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestEmployerService {
    private Gson gson = new Gson();

    @Test
    public void testAddVacancy() {
        EmployerService employerService = new EmployerService();

        RegisterEmployerDtoRequest Employer1 = new RegisterEmployerDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", "ул. Маршала Жукова, 21", "Тамтэк", "Ivan@ads");
        String jsonRequest = gson.toJson(Employer1);
        String jsonResult = employerService.registerEmployer(jsonRequest);
        RegisterEmployerDtoResponse result = gson.fromJson(jsonResult, RegisterEmployerDtoResponse.class);
        Requirements Requirement1 = new Requirements("Java", true, 2);
        Requirements Requirement2 = new Requirements("C#", false, 4);
        Requirements Requirement3 = new Requirements("Python", true, 3);
        List<Requirements> Requirement = new ArrayList<>();
        Requirement.add(Requirement1);
        Requirement.add(Requirement2);
        Requirement.add(Requirement3);
        AddVacancyDtoRequest Vacancy = new AddVacancyDtoRequest("Developer", 1234, result.getToken(), Requirement, "yes");

        String jsonRequest1 = gson.toJson(Vacancy);
        String jsonResult2 = employerService.addVacancy(jsonRequest1);
        String result1 = gson.fromJson(jsonResult2, String.class);
        assertEquals("", result1);

    }

    @Test
    public void testRegisterEmployer() {
        EmployerService employerService = new EmployerService();

        RegisterEmployerDtoRequest request = new RegisterEmployerDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", "ул. Маршала Жукова, 21", "Тамтэк", "Ivan@ads");
        String jsonRequest = gson.toJson(request);

        String jsonResult = employerService.registerEmployer(jsonRequest);
        RegisterEmployerDtoResponse result = gson.fromJson(jsonResult, RegisterEmployerDtoResponse.class);
        Map<String, Employer> database = DataBase.getInstance().getDataBaseEmployer();
        assertTrue(database.containsKey(result.getToken()));
        assertEquals(database.get(result.getToken()).getLogin(), "Ivan");
     /*   assertEquals(database.get(result.getToken()).getAddress(), "ул. Маршала Жукова, 21");
        assertEquals(database.get(result.getToken()).getCompanyName(), "Тамтэк");
        assertEquals(database.get(result.getToken()).getMiddlename(), "");
        assertEquals(database.get(result.getToken()).getLastName(), "Иванов");
        assertEquals(database.get(result.getToken()).getEmail(), "Ivan@ads");
        assertEquals(database.get(result.getToken()).getLogin(), "Ivan");
        assertEquals(database.get(result.getToken()).getFirstName(), "Иван");*/
    }

    @Test
    public void testRegisterEmployerWithError() {
        EmployerService employerService = new EmployerService();


        RegisterEmployerDtoRequest request = new RegisterEmployerDtoRequest(
                "", "Ivan", "123456", "Иванов",
                "", "ул. Маршала Жукова, 21", "Тамтэк", "Ivan@ads");
        String jsonRequest = gson.toJson(request);
        String jsonResult = employerService.registerEmployer(jsonRequest);
        Error result = gson.fromJson(jsonResult, Error.class);
        assertEquals(result.getMessage(), "Empty first name");
        RegisterEmployerDtoRequest request1 = new RegisterEmployerDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", "ул. Маршала Жукова, 21", "Тамтэк", "Ivanads");
        String jsonRequest1 = gson.toJson(request1);
        String jsonResult1 = employerService.registerEmployer(jsonRequest1);
        Error result1 = gson.fromJson(jsonResult1, Error.class);
        assertEquals("Not correct email", result1.getMessage());
    }

    @Test
    public void testRegisterEmployerWithException() {
        EmployerService employerService = new EmployerService();

        RegisterEmployerDtoRequest Employer1 = new RegisterEmployerDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", "ул. Маршала Жукова, 21", "Тамтэк", "Ivan@ads");
        RegisterEmployerDtoRequest Employer2 = new RegisterEmployerDtoRequest(
                "Вася", "Ivan", "123487", "Васильев",
                "", "Karl Marx Av., 41, bld", "Luxoft Professional", "Vasya@ads");
        String jsonRequest = gson.toJson(Employer2);
        employerService.registerEmployer(jsonRequest);
        String jsonRequest2 = gson.toJson(Employer1);
        String jsonResult2 = employerService.registerEmployer(jsonRequest2);
        Error result1 = gson.fromJson(jsonResult2, Error.class);
        assertEquals("User already registered", result1.getMessage());
    }

    @Test
    public void testAddAndEditVacancyWithError() {
        EmployerService employerService = new EmployerService();
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
        AddVacancyDtoRequest Vacancy = new AddVacancyDtoRequest("Developer", -1234, result.getToken(), Requirement, "yes");
        Requirements Requirement4 = new Requirements("", true, 3);
        Requirement.add(Requirement4);
        String jsonRequest1 = gson.toJson(Vacancy);
        String jsonResult2 = employerService.addVacancy(jsonRequest1);
        String result1 = gson.fromJson(jsonResult2, String.class);
        assertEquals("Requirement is empty", result1);

    }

    @Test
    public void testDeleteEmployer() {
        EmployerService employerService = new EmployerService();

        RegisterEmployerDtoRequest Employer1 = new RegisterEmployerDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", "ул. Маршала Жукова, 21", "Тамтэк", "Ivan@ads");
        String jsonRequest = gson.toJson(Employer1);
        String jsonResult = employerService.registerEmployer(jsonRequest);
        RegisterEmployerDtoResponse result = gson.fromJson(jsonResult, RegisterEmployerDtoResponse.class);

        DeleteDtoRequest deleteEmployer = new DeleteDtoRequest(result.getToken());
        String jsonRequest1 = gson.toJson(deleteEmployer);


        String jsonResultDelete = employerService.deleteEmployer(jsonRequest1);
        String result1 = gson.fromJson(jsonResultDelete, String.class);
        assertEquals("", result1);


    }

    @Test
    public void testDeleteEmployerWithException() {
        EmployerService employerService = new EmployerService();
/*
        RegisterEmployerDtoRequest Employer1 = new RegisterEmployerDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", "ул. Маршала Жукова, 21", "Тамтэк", "Ivan@ads");
        employerService.registerEmployer(gson.toJson(Employer1));
*/
        DeleteDtoRequest deleteEmployer = new DeleteDtoRequest(UUID.randomUUID().toString());
        String jsonRequest2 = gson.toJson(deleteEmployer);
        String jsonResultDelete = employerService.deleteEmployer(jsonRequest2);
        Error result1 = gson.fromJson(jsonResultDelete, Error.class);
        assertEquals("User does not exist", result1.getMessage());
    }

    @Test
    public void testDeleteVacancy() {
        EmployerService employerService = new EmployerService();
        DeleteDtoRequest deleteEmployer = new DeleteDtoRequest(UUID.randomUUID().toString());
        String jsonRequest2 = gson.toJson(deleteEmployer);
        String jsonResultDelete = employerService.deleteVacancy(jsonRequest2);
        Error result1 = gson.fromJson(jsonResultDelete, Error.class);
        assertEquals("Vacancy does not exist", result1.getMessage());
    }
    @Test
    public void testGetSummary1() {
        EmployeeService employeeService = new EmployeeService();
        EmployerService employerService = new EmployerService();

        Skills skill1 = new Skills("Java", 3);
        Skills skill2 = new Skills("C#", 5);
        Skills skill3 = new Skills("Python", 3);
        List<Skills> skills = new ArrayList<>();
        skills.add(skill1);
        skills.add(skill2);
        skills.add(skill3);

        RegisterEmployeeDtoRequest Employee = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", 44, "Ivan@rt", true);
        String jsonResult = employeeService.registerEmployee(gson.toJson(Employee));
        RegisterEmployeeDtoResponse result = gson.fromJson(jsonResult, RegisterEmployeeDtoResponse.class);

        Requirements Requirement1 = new Requirements("Java", true, 2);
        Requirements Requirement2 = new Requirements("C#", false, 4);
        Requirements Requirement3 = new Requirements("Python", true, 3);
        List<Requirements> Requirement = new ArrayList<>();
        Requirement.add(Requirement1);
        Requirement.add(Requirement2);
        Requirement.add(Requirement3);
        AddSummaryDtoRequest summary = new AddSummaryDtoRequest(skills, result.getToken());
        String jsonRequestAddSummary = gson.toJson(summary);
        employeeService.addSummary(jsonRequestAddSummary);

        GetSummaryDtoRequest Summary=new GetSummaryDtoRequest(Requirement,UUID.randomUUID().toString(),false,true);
        String jsonRequestGetSummary = gson.toJson(Summary);
        String jsonResultGetSummary = employerService.getSummary(jsonRequestGetSummary);
        getSummaryDtoResponse resultGetSummary=gson.fromJson(jsonResultGetSummary, getSummaryDtoResponse.class);
        assertTrue(resultGetSummary.getSummary().size()==1);
        assertEquals(skills.get(0).getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(0).getNameRequirement());
        assertEquals(skills.get(0).getLevelProficiency(),resultGetSummary.getSummary().getFirst().getSkills().get(0).getLevelProficiency());

        assertEquals(skills.get(1).getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(1).getNameRequirement());
        assertEquals(skills.get(1).getLevelProficiency(),resultGetSummary.getSummary().getFirst().getSkills().get(1).getLevelProficiency());

        assertEquals(skills.get(2).getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(2).getNameRequirement());
        assertEquals(skills.get(2).getLevelProficiency(),resultGetSummary.getSummary().getFirst().getSkills().get(2).getLevelProficiency());


    }
    @Test
    public void testGetSummary2() {
        EmployeeService employeeService = new EmployeeService();
        EmployerService employerService = new EmployerService();

        Skills skill1 = new Skills("Java", 2);
        Skills skill2 = new Skills("C#", 3);
        Skills skill3 = new Skills("Python", 5);
        List<Skills> skills = new ArrayList<>();
        skills.add(skill1);
        skills.add(skill2);
        skills.add(skill3);

        RegisterEmployeeDtoRequest Employee = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", 44, "Ivan@rt", true);
        String jsonResult = employeeService.registerEmployee(gson.toJson(Employee));
        RegisterEmployeeDtoResponse result = gson.fromJson(jsonResult, RegisterEmployeeDtoResponse.class);

        Requirements Requirement1 = new Requirements("Java", true, 1);
        Requirements Requirement2 = new Requirements("C#", false, 3);
        Requirements Requirement3 = new Requirements("Python", true, 2);
        List<Requirements> Requirement = new ArrayList<>();
        Requirement.add(Requirement1);
        Requirement.add(Requirement2);
        Requirement.add(Requirement3);
        AddSummaryDtoRequest summary = new AddSummaryDtoRequest(skills, result.getToken());
        String jsonRequestAddSummary = gson.toJson(summary);
        employeeService.addSummary(jsonRequestAddSummary);

        GetSummaryDtoRequest Summary=new GetSummaryDtoRequest(Requirement,UUID.randomUUID().toString(),true,true);
        String jsonRequestGetSummary = gson.toJson(Summary);
        String jsonResultGetSummary = employerService.getSummary(jsonRequestGetSummary);
        getSummaryDtoResponse resultGetSummary=gson.fromJson(jsonResultGetSummary, getSummaryDtoResponse.class);
        assertTrue(resultGetSummary.getSummary().size()==1);
        assertEquals(skills.get(0).getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(0).getNameRequirement());
        assertEquals(skills.get(0).getLevelProficiency(),resultGetSummary.getSummary().getFirst().getSkills().get(0).getLevelProficiency());

        assertEquals(skills.get(1).getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(1).getNameRequirement());
        assertEquals(skills.get(1).getLevelProficiency(),resultGetSummary.getSummary().getFirst().getSkills().get(1).getLevelProficiency());

        assertEquals(skills.get(2).getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(2).getNameRequirement());
        assertEquals(skills.get(2).getLevelProficiency(),resultGetSummary.getSummary().getFirst().getSkills().get(2).getLevelProficiency());


    }
    @Test
    public void  testGetSummary3(){
        EmployeeService employeeService = new EmployeeService();
        EmployerService employerService = new EmployerService();

        Skills skill1 = new Skills("Java", 2);
        Skills skill2 = new Skills("C#", 4);
        Skills skill3 = new Skills("Python", 3);
        List<Skills> skills = new ArrayList<>();
        skills.add(skill1);
        skills.add(skill2);
        skills.add(skill3);

        RegisterEmployeeDtoRequest Employee = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", 44, "Ivan@rt", true);
        String jsonResult = employeeService.registerEmployee(gson.toJson(Employee));
        RegisterEmployeeDtoResponse result = gson.fromJson(jsonResult, RegisterEmployeeDtoResponse.class);

        Requirements Requirement1 = new Requirements("Java", true, 0);
        Requirements Requirement2 = new Requirements("C#", false, 0);
        Requirements Requirement3 = new Requirements("Python", true, 0);
        List<Requirements> Requirement = new ArrayList<>();
        Requirement.add(Requirement1);
        Requirement.add(Requirement2);
        Requirement.add(Requirement3);
        AddSummaryDtoRequest summary = new AddSummaryDtoRequest(skills, result.getToken());
        String jsonRequestAddSummary = gson.toJson(summary);
        employeeService.addSummary(jsonRequestAddSummary);

        GetSummaryDtoRequest Summary=new GetSummaryDtoRequest(Requirement,UUID.randomUUID().toString(),true,true);
        String jsonRequestGetSummary = gson.toJson(Summary);
        String jsonResultGetSummary = employerService.getSummary(jsonRequestGetSummary);
        getSummaryDtoResponse resultGetSummary=gson.fromJson(jsonResultGetSummary, getSummaryDtoResponse.class);
        assertTrue(resultGetSummary.getSummary().size()==1);
        assertEquals(skills.get(0).getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(0).getNameRequirement());
        assertEquals(skills.get(0).getLevelProficiency(),resultGetSummary.getSummary().getFirst().getSkills().get(0).getLevelProficiency());

        assertEquals(skills.get(1).getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(1).getNameRequirement());
        assertEquals(skills.get(1).getLevelProficiency(),resultGetSummary.getSummary().getFirst().getSkills().get(1).getLevelProficiency());

        assertEquals(skills.get(2).getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(2).getNameRequirement());
        assertEquals(skills.get(2).getLevelProficiency(),resultGetSummary.getSummary().getFirst().getSkills().get(2).getLevelProficiency());
    }
    @Test
    public void  testGetSummary4(){
        EmployeeService employeeService = new EmployeeService();
        EmployerService employerService = new EmployerService();

        Skills skill1 = new Skills("Java", 2);
        Skills skill2 = new Skills("C#", 4);
        Skills skill3 = new Skills("Python", 3);
        List<Skills> skills = new ArrayList<>();
        skills.add(skill1);
        skills.add(skill2);
        skills.add(skill3);
        RegisterEmployeeDtoRequest Employee = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", 44, "Ivan@rt", true);
        String jsonResult = employeeService.registerEmployee(gson.toJson(Employee));
        RegisterEmployeeDtoResponse result = gson.fromJson(jsonResult, RegisterEmployeeDtoResponse.class);
        AddSummaryDtoRequest summary = new AddSummaryDtoRequest(skills, result.getToken());
        String jsonRequestAddSummary = gson.toJson(summary);
        employeeService.addSummary(jsonRequestAddSummary);

        Skills skill11 = new Skills("Java", 2);
        Skills skill21 = new Skills("C", 4);
        Skills skill31 = new Skills("Python", 3);
        List<Skills> skills1 = new ArrayList<>();
        skills1.add(skill11);
        skills1.add(skill21);
        skills1.add(skill31);
        RegisterEmployeeDtoRequest Employee1 = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan1", "123456", "Иванов",
                "", 44, "Ivan1@rt", true);
        String jsonResult1 = employeeService.registerEmployee(gson.toJson(Employee1));
        RegisterEmployeeDtoResponse result1 = gson.fromJson(jsonResult1, RegisterEmployeeDtoResponse.class);
        AddSummaryDtoRequest summary1 = new AddSummaryDtoRequest(skills1, result1.getToken());
        String jsonRequestAddSummary1 = gson.toJson(summary1);
        employeeService.addSummary(jsonRequestAddSummary1);

        Skills skill12 = new Skills("Java", 2);
        Skills skill22 = new Skills("C", 4);
        Skills skill32 = new Skills("Py", 3);
        List<Skills> skills2 = new ArrayList<>();
        skills2.add(skill12);
        skills2.add(skill22);
        skills2.add(skill32);
        RegisterEmployeeDtoRequest Employee2 = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan2", "123456", "Иванов",
                "", 44, "Ivan2@rt", true);
        String jsonResult2 = employeeService.registerEmployee(gson.toJson(Employee2));
        RegisterEmployeeDtoResponse result2 = gson.fromJson(jsonResult2, RegisterEmployeeDtoResponse.class);
        AddSummaryDtoRequest summary2 = new AddSummaryDtoRequest(skills2, result2.getToken());
        String jsonRequestAddSummary2 = gson.toJson(summary2);
        employeeService.addSummary(jsonRequestAddSummary2);

        Requirements Requirement1 = new Requirements("Java", true, 1);
        Requirements Requirement2 = new Requirements("C#", false, 2);
        Requirements Requirement3 = new Requirements("Python", true, 3);
        List<Requirements> Requirement = new ArrayList<>();
        Requirement.add(Requirement1);
        Requirement.add(Requirement2);
        Requirement.add(Requirement3);

        GetSummaryDtoRequest Summary=new GetSummaryDtoRequest(Requirement,UUID.randomUUID().toString(),false,false);
        String jsonRequestGetSummary = gson.toJson(Summary);
        String jsonResultGetSummary = employerService.getSummary(jsonRequestGetSummary);
        getSummaryDtoResponse resultGetSummary=gson.fromJson(jsonResultGetSummary, getSummaryDtoResponse.class);
        assertTrue(resultGetSummary.getSummary().size()==3);

        assertEquals(skill1.getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(0).getNameRequirement());
        assertEquals(skill2.getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(1).getNameRequirement());
        assertEquals(skill3.getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(2).getNameRequirement());
        resultGetSummary.getSummary().removeFirst();

        assertEquals(skill11.getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(0).getNameRequirement());
        assertEquals(skill21.getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(1).getNameRequirement());
        assertEquals(skill31.getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(2).getNameRequirement());
        resultGetSummary.getSummary().removeFirst();

        assertEquals(skill12.getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(0).getNameRequirement());
        assertEquals(skill22.getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(1).getNameRequirement());
        assertEquals(skill32.getNameRequirement(),resultGetSummary.getSummary().getFirst().getSkills().get(2).getNameRequirement());
        resultGetSummary.getSummary().removeFirst();
    }

}
