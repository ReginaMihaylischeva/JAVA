package net.thumbtack.school.hiring.daoimpl;

import net.thumbtack.school.hiring.DataBase.DataBase;
import net.thumbtack.school.hiring.Models.*;
import net.thumbtack.school.hiring.dao.EmployeeDao;
import net.thumbtack.school.hiring.dao.EmployerDao;
import net.thumbtack.school.hiring.request.Requirements;
import net.thumbtack.school.hiring.request.Skills;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DAO implements EmployeeDao, EmployerDao {
    private DataBase database = new DataBase();

    public UUID insert(Employee employee) {

        return database.Insert(employee, employee.getLogin());

    }

    public void delete(DeleteEmployee employee) {
        database.Delete(employee);
    }

    public void addSummary(Summary summary) {
        database.AddSummary(summary);
    }

    public void deleteSummary(Summary summary) {
        database.deleteSummary(summary);
    }

    public ArrayDeque<Vacancy> getVacancies(getVacancies GetVacancies) {
        return database.getVacancies(GetVacancies);
    }

    public UUID InsertEmployer(Employer employer) {

        return database.InsertEmployer(employer, employer.getLogin());
    }

    public void deleteEmployer(DeleteEmployer employer) {
        database.DeleteEmployer(employer);
    }

    public void addVacancy(Vacancy vacancy) {
        database.AddVacancy(vacancy);
    }

    public void deleteVacancy(Vacancy vacancy) {
        database.deleteVacancy(vacancy);
    }

    public ArrayList<Vacancy> AllVacancies(AllVacancies vacancies) {
        return database.allVacancies(vacancies);
    }
    public ArrayDeque<List<Skills>> getSummary(getSummary requirement){
        return  database.getSummary(requirement);
    }
}
