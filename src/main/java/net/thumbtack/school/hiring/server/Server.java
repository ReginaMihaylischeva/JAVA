package net.thumbtack.school.hiring.server;

import com.google.gson.Gson;
import net.thumbtack.school.hiring.DataBase.DataBase;
import net.thumbtack.school.hiring.service.EmployeeService;
import net.thumbtack.school.hiring.service.EmployerService;

import java.io.*;

public class Server  {
    public void startServer(String savedDataFileName) throws IOException{
        Gson gson = new Gson();

        try (BufferedReader br = new BufferedReader(new FileReader(savedDataFileName))) {
            DataBase dataBase= gson.fromJson(br, DataBase.class);

        }
    }

    public void stopServer(String saveDataFileName)throws IOException {
        Gson gson = new Gson();
        if (!saveDataFileName.isEmpty()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(saveDataFileName))) {

                gson.toJson(DataBase.class, bw);
            }
        }


    }

    private net.thumbtack.school.hiring.service.EmployeeService EmployeeService = new EmployeeService();

    public String registerEmployee(String requestJsonStringEmployee) {
        return EmployeeService.registerEmployee(requestJsonStringEmployee);
    }

    public String addsummary(String requestJsonStringAddSummary) {
        return EmployeeService.addSummary(requestJsonStringAddSummary);


    }

    public String getsummary(String requestJsonStringGetSummary) {
        return EmployerService.getSummary(requestJsonStringGetSummary);

    }

    public String deleteEmployee(String requestJsonStringDeleteEmployee) {
        return EmployeeService.deleteEmployee(requestJsonStringDeleteEmployee);

    }

    public String deletesummary(String requestJsonStringDeletesummary) {
        return EmployeeService.deleteSummary(requestJsonStringDeletesummary);

    }

    public String allVacancies(String requestJsonAllVacancies) {
        return EmployeeService.allVacancies(requestJsonAllVacancies);
    }

    public String editSummary(String requestJsonStringEditSummary) {
        return EmployeeService.editSummary(requestJsonStringEditSummary);
    }


    private net.thumbtack.school.hiring.service.EmployerService EmployerService = new EmployerService();

    public String registerEmployer(String requestJsonStringEmployer) {
        return EmployerService.registerEmployer(requestJsonStringEmployer);

    }

    public String addVacancy(String requestJsonStringAddVacancy) {
        return EmployerService.addVacancy(requestJsonStringAddVacancy);

    }

    public String getVacancies(String requestJsonStringGetVacancies) {
        return EmployeeService.getVacancies(requestJsonStringGetVacancies);

    }

    public String deleteEmployer(String requestJsonStringDeleteEmployer) {
        return EmployerService.deleteEmployer(requestJsonStringDeleteEmployer);

    }

    public String deleteVacancy(String requestJsonStringDeleteVacancy) {
        return EmployerService.deleteVacancy(requestJsonStringDeleteVacancy);

    }

    public String allSummary(String requestJsonAllSummary) {
        return EmployerService.allSummary(requestJsonAllSummary);
    }

    public String editVacancies(String requestJsonStringEditVacancy) {
        return EmployeeService.editSummary(requestJsonStringEditVacancy);
    }

    public String editVacancy(String requestJsonStringEditVacancy) {
        return EmployerService.editVacancy(requestJsonStringEditVacancy);
    }


}
