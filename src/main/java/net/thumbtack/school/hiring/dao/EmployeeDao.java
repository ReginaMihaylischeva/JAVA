package net.thumbtack.school.hiring.dao;

import net.thumbtack.school.hiring.Models.*;
import net.thumbtack.school.hiring.error.serverException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface EmployeeDao {
    String  insert(Employee employee) throws serverException;
    void delete(DeleteEmployee employee)throws serverException;
    void addSummary(Summary summary);
    void deleteSummary(Summary summary) throws serverException;
    ArrayDeque<getVacanciesResponse> getVacancies(getVacancies GetVacancies);
    ArrayDeque<getVacanciesResponse> AllVacancies(AllVacancies vacancies);
     void editSummary(EditSummary editSummary)throws serverException;
}
