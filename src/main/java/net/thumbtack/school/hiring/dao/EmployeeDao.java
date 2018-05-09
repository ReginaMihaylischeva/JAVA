package net.thumbtack.school.hiring.dao;

import net.thumbtack.school.hiring.Models.*;
import net.thumbtack.school.hiring.error.serverException;

import java.util.ArrayDeque;

public interface EmployeeDao {
    String  insert(Employee employee) throws serverException;
    void delete(Delete employee)throws serverException;
    void addSummary(Summary summary);
    void deleteSummary(Delete summary) throws serverException;
    ArrayDeque<ListEmployer> getVacancies(CriteriaEmployer CriteriaEmployer);
    ArrayDeque<ListEmployer> AllVacancies(Vacancy vacancies);
     void editSummary(Summary editSummary)throws serverException;
}
