package net.thumbtack.school.hiring.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.thumbtack.school.hiring.DataBase.DataBase;
import net.thumbtack.school.hiring.Models.Employee;
import net.thumbtack.school.hiring.Models.Skills;
import net.thumbtack.school.hiring.error.ServerErrorCode;
import net.thumbtack.school.hiring.error.serverException;
import net.thumbtack.school.hiring.request.AddSummaryDtoRequest;
import net.thumbtack.school.hiring.request.RegisterEmployeeDtoRequest;
import net.thumbtack.school.hiring.response.RegisterEmployeeDtoResponse;
import org.junit.Test;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestEmployeeService {
   private Gson gson = new Gson();
    @Test
    public void testRegisterEmployee() {
        RegisterEmployeeDtoRequest request = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", 45, "Ivan@ads", true);
        String jsonRequst = gson.toJson(request);
        EmployeeService employeeService = new EmployeeService();

        String jsonResult = employeeService.registerEmployee(jsonRequst);
        RegisterEmployeeDtoResponse result = gson.fromJson(jsonResult, RegisterEmployeeDtoResponse.class);
        Map<String, Employee> database = DataBase.getInstance().getDataBaseEmployee();
        assertTrue(database.containsKey(result.getToken()));
        assertEquals(database.get(result.getToken()).getLogin(), "Ivan");

    }

    @Test
    public void testRegisterEmployeeWithError() {

        RegisterEmployeeDtoRequest request = new RegisterEmployeeDtoRequest(
                "", "Ivan", "123456", "Иванов",
                "", 45, "Ivan@ads", true);
        String jsonRequst = gson.toJson(request);
        EmployeeService employeeService = new EmployeeService();
        String jsonResult = employeeService.registerEmployee(jsonRequst);
        Error result = gson.fromJson(jsonResult, Error.class);
        assertEquals(result.getMessage(), "Empty first name");
        RegisterEmployeeDtoRequest request1 = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", -35, "Ivan@ads", true);
        String jsonRequst1 = gson.toJson(request1);
        String jsonResult1 = employeeService.registerEmployee(jsonRequst1);
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
        String jsonRequst = gson.toJson(Employee2);
        String jsonResult = employeeService.registerEmployee(jsonRequst);
        String jsonRequst2 = gson.toJson(Employee1);
        String jsonResult2 = employeeService.registerEmployee(jsonRequst2);
        Error result1 = gson.fromJson(jsonResult2, Error.class);
        assertEquals("User already registered", result1.getMessage());
    }

    @Test
    public void testAddSummary() {
        EmployeeService employeeService = new EmployeeService();

        RegisterEmployeeDtoRequest Employee1 = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", 45, "Ivan@ads", true);
        String jsonRequst = gson.toJson(Employee1);
        String jsonResult = employeeService.registerEmployee(jsonRequst);
        RegisterEmployeeDtoResponse result = gson.fromJson(jsonResult, RegisterEmployeeDtoResponse.class);
        Skills skill1=new Skills("Java",2);
        Skills skill2=new Skills("C#",4);
        Skills skill3=new Skills("Python",3);
        List<Skills> skills= new ArrayList<>();
        skills.add(skill1);
        skills.add(skill2);
        skills.add(skill3);
        AddSummaryDtoRequest Summary=new AddSummaryDtoRequest(skills,result.getToken());
        String jsonRequest1 = gson.toJson(Summary);
        String jsonResult2 = employeeService.addSummary(jsonRequest1);
        String result1 = gson.fromJson(jsonResult2,String.class);
        assertEquals("",result1);
    }
    @Test
    public void testAddAndEditSummaryWithError() {
        EmployeeService employeeService = new EmployeeService();

        RegisterEmployeeDtoRequest Employee1 = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", 45, "Ivan@ads", true);
        String jsonRequst = gson.toJson(Employee1);
        String jsonResult = employeeService.registerEmployee(jsonRequst);
        RegisterEmployeeDtoResponse result = gson.fromJson(jsonResult, RegisterEmployeeDtoResponse.class);
        Skills skill1=new Skills("Java",2);
        Skills skill2=new Skills("C#",-12);
        Skills skill3=new Skills("Python",3);
        List<Skills> skills= new ArrayList<>();
        skills.add(skill1);
        skills.add(skill2);
        skills.add(skill3);
        AddSummaryDtoRequest Summary=new AddSummaryDtoRequest(skills,result.getToken());
        String jsonRequest1 = gson.toJson(Summary);
        String jsonResult2 = employeeService.addSummary(jsonRequest1);
        String result1 = gson.fromJson(jsonResult2,String.class);
        assertEquals("not correct level Proficiency",result1);
        Skills skill4=new Skills("",3);
        List<Skills> skills1= new ArrayList<>();
        skills1.add(skill4);
        AddSummaryDtoRequest editSummary=new AddSummaryDtoRequest(skills1,result.getToken());
        String jsonRequest3 = gson.toJson(editSummary);
        String jsonResult3 = employeeService.editSummary(jsonRequest3);
        String result3 = gson.fromJson(jsonResult3,String.class);
        assertEquals("Requirement is empty",result3);

    }
}
