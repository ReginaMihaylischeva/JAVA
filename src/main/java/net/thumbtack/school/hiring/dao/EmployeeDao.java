package net.thumbtack.school.hiring.dao;

import net.thumbtack.school.hiring.Models.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface EmployeeDao {
    UUID insert(Employee employee);
    void delete(DeleteEmployee employee);
    void addSummary(Summary summary);
    void deleteSummary(Summary summary);
    ArrayDeque<Vacancy> getVacancies(getVacancies GetVacancies);
    ArrayList<Vacancy> AllVacancies(AllVacancies vacancies);

}
