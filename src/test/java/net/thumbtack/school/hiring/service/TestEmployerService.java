package net.thumbtack.school.hiring.service;

import com.google.gson.Gson;
import net.thumbtack.school.hiring.DataBase.DataBase;
import net.thumbtack.school.hiring.Models.Employer;
import net.thumbtack.school.hiring.Models.Requirements;
import net.thumbtack.school.hiring.request.AddVacancyDtoRequest;
import net.thumbtack.school.hiring.request.DeleteDtoRequest;
import net.thumbtack.school.hiring.request.RegisterEmployerDtoRequest;
import net.thumbtack.school.hiring.response.RegisterEmployerDtoResponse;
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


}
