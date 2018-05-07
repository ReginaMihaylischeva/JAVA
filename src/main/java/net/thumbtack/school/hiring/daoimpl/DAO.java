package net.thumbtack.school.hiring.daoimpl;

import net.thumbtack.school.hiring.DataBase.DataBase;
import net.thumbtack.school.hiring.Models.*;
import net.thumbtack.school.hiring.dao.EmployeeDao;
import net.thumbtack.school.hiring.dao.EmployerDao;
import net.thumbtack.school.hiring.error.serverException;

import java.util.ArrayDeque;
import java.util.UUID;

public class DAO implements EmployeeDao, EmployerDao {
    private DataBase database= DataBase.getInstance();

    public String insert(Employee employee)throws serverException {

      return    database.Insert(employee, employee.getLogin());

    }

    public void delete(DeleteEmployee employee)throws serverException {
        database.Delete(employee);
    }

    public void addSummary(Summary summary) {
        database.AddSummary(summary);
    }

    public void deleteSummary(Summary summary)throws serverException {
        database.deleteSummary(summary);
    }

    public ArrayDeque<getVacanciesResponse> getVacancies(getVacancies GetVacancies) {
        return database.getVacancies(GetVacancies);
    }

    public UUID InsertEmployer(Employer employer)throws serverException {

        return database.InsertEmployer(employer, employer.getLogin());
    }

    public void deleteEmployer(DeleteEmployer employer)throws serverException {
        database.DeleteEmployer(employer);
    }

    public void addVacancy(Vacancy vacancy) {
        database.AddVacancy(vacancy);
    }

    public void deleteVacancy(Vacancy vacancy)throws serverException {
        database.deleteVacancy(vacancy);
    }

    public ArrayDeque<getVacanciesResponse> AllVacancies(AllVacancies vacancies) {
        return database.allVacancies(vacancies);
    }

    public ArrayDeque<getSummaryResponse> getSummary(getSummary requirement) {
        return database.getSummary(requirement);
    }

    public ArrayDeque<getSummaryResponse> AllSummary(AllSummary summary) {
        return database.allSummary(summary);
    }

    public void editSummary(EditSummary editSummary)throws serverException {
        database.editSummary(editSummary);
    }

    public void editVacancy(EditVacancy editVacancy)throws serverException {
        database.editVacancy(editVacancy);
    }
}
