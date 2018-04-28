package net.thumbtack.school.hiring.server;

import net.thumbtack.school.hiring.service.EmployeeService;
import net.thumbtack.school.hiring.service.EmployerService;

public class Server {
    public void startServer(String savedDataFileName) {
    }

    public void stopServer(String saveDataFileName) {
    }

    private net.thumbtack.school.hiring.service.EmployeeService EmployeeService = new EmployeeService();

    public String registerEmployee(String requestJsonStringEmployee) {
        return EmployeeService.registerEmployee(requestJsonStringEmployee);
    }

    public String addsummary(String requestJsonStringaddsummary) {
        return EmployeeService.addSummary(requestJsonStringaddsummary);


    }

  /*  public String getsummary(String requestJsonStringgetsummary) {
        return EmployeeService.getSummary(requestJsonStringgetsummary);

    }*/

    public String deleteEmployee(String requestJsonStringdeleteEmployee) {
        return EmployeeService.deleteEmployee(requestJsonStringdeleteEmployee);

    }

    public String deletesummary(String requestJsonStringdeletesummary) {
        return EmployeeService.deleteSummary(requestJsonStringdeletesummary);

    }

  /*  public String searchEmployee(String requestJsonStringsearchEmployee) {
        return EmployeeService.searchEmployee(requestJsonStringsearchEmployee);

    }*/


    private net.thumbtack.school.hiring.service.EmployerService EmployerService = new EmployerService();
    public String registerEmployer(String requestJsonStringEmployer){
        return EmployerService.registerEmployer(requestJsonStringEmployer);

    }
    public String addVacancy(String requestJsonStringaddVacancy){
        return EmployerService.addVacancy(requestJsonStringaddVacancy);

    }
   /* public String getVacancies(String requestJsonStringgetVacancies){
        return EmployerService.getVacancies(requestJsonStringgetVacancies);

    }*/
    public String deleteEmployer(String requestJsonStringdeleteEmployer){
        return EmployerService.deleteEmployer(requestJsonStringdeleteEmployer);

    }
    public String deleteVacancy(String requestJsonStringdeleteVacancy){
        return EmployerService.deleteVacancy(requestJsonStringdeleteVacancy);

    }
 /*   public String searchEmployer(String requestJsonStringsearchEmployer){
        return EmployerService.searchEmployer(requestJsonStringsearchEmployer);

    }*/

}
