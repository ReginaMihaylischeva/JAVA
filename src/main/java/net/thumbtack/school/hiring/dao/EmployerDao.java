package net.thumbtack.school.hiring.dao;

import net.thumbtack.school.hiring.Models.*;
import net.thumbtack.school.hiring.error.serverException;

import java.util.ArrayDeque;

public interface EmployerDao {
  String InsertEmployer(Employer employer)throws serverException;
    void deleteEmployer(Delete employer)throws serverException;
    void addVacancy(Vacancy vacancy);
    void deleteVacancy(Delete vacancy)throws serverException;
    ArrayDeque<ListEmployee> getSummary(CriteriaEmployee requirement);
    ArrayDeque<ListEmployee> AllSummary(Summary summary);
    void editVacancy(Vacancy vacancy)throws serverException;
}
