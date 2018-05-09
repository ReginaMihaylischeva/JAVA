package net.thumbtack.school.hiring.daoimpl;

import net.thumbtack.school.hiring.DataBase.DataBase;
import net.thumbtack.school.hiring.Models.*;
import net.thumbtack.school.hiring.dao.EmployeeDao;
import net.thumbtack.school.hiring.dao.EmployerDao;
import net.thumbtack.school.hiring.error.serverException;

import java.util.ArrayDeque;

public class DAO implements EmployeeDao, EmployerDao {
    private DataBase database= DataBase.getInstance();

    public String insert(Employee employee)throws serverException {

      return    database.Insert(employee, employee.getLogin());

    }

    public void delete(Delete employee)throws serverException {
        database.Delete(employee);
    }

    public void addSummary(Summary summary) {
        database.AddSummary(summary);
    }

    public void deleteSummary(Delete summary)throws serverException {
        database.deleteSummary(summary);
    }

    public ArrayDeque<ListEmployer> getVacancies(CriteriaEmployer CriteriaEmployer) {
        return database.getVacancies(CriteriaEmployer);
    }

    public String InsertEmployer(Employer employer)throws serverException {

        return database.InsertEmployer(employer, employer.getLogin());
    }

    public void deleteEmployer(Delete employer)throws serverException {
        database.DeleteEmployer(employer);
    }

    public void addVacancy(Vacancy vacancy) {
        database.AddVacancy(vacancy);
    }

    public void deleteVacancy(Delete vacancy)throws serverException {
        database.deleteVacancy(vacancy);
    }

    public ArrayDeque<ListEmployer> AllVacancies(Vacancy vacancies) {
        return database.allVacancies(vacancies);
    }

    public ArrayDeque<ListEmployee> getSummary(CriteriaEmployee requirement) {
        return database.getSummary(requirement);
    }

    public ArrayDeque<ListEmployee> AllSummary(Summary summary) {
        return database.allSummary(summary);
    }

    public void editSummary(Summary editSummary)throws serverException {
        database.editSummary(editSummary);
    }

    public void editVacancy(Vacancy editVacancy)throws serverException {
        database.editVacancy(editVacancy);
    }
}
