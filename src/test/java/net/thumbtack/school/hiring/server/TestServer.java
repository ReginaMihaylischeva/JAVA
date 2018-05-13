package net.thumbtack.school.hiring.server;

import com.google.gson.Gson;
import net.thumbtack.school.file.FileService;
import net.thumbtack.school.hiring.DataBase.DataBase;
import net.thumbtack.school.hiring.Models.Employee;
import net.thumbtack.school.hiring.request.RegisterEmployeeDtoRequest;
import net.thumbtack.school.hiring.response.RegisterEmployeeDtoResponse;
import net.thumbtack.school.hiring.service.EmployeeService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TestServer {



    @Test
    public void testStopStartServer() {
        Server newServer = new Server();
         Gson gson = new Gson();
         RegisterEmployeeDtoRequest request = new RegisterEmployeeDtoRequest(
                "Иван", "Ivan", "123456", "Иванов",
                "", 45, "Ivan@ads", true);
        String jsonRequest = gson.toJson(request);
        EmployeeService employeeService = new EmployeeService();

        String jsonResult = employeeService.registerEmployee(jsonRequest);
        RegisterEmployeeDtoResponse result = gson.fromJson(jsonResult, RegisterEmployeeDtoResponse.class);

        try {
            newServer.stopServer("DataBase.txt");
            newServer.startServer("DataBase.txt");
            Map<String, Employee> database = DataBase.getInstance().getDataBaseEmployee();
            assertTrue(database.size()==1);
            assertTrue(database.containsKey(result.getToken()));
        } catch (IOException ex) {
            fail();
        }

    }
    @Test
    public void testWorkServer() {}
}
