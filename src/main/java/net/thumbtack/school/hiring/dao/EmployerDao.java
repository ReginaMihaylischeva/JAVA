package net.thumbtack.school.hiring.dao;

import net.thumbtack.school.hiring.Models.*;
import net.thumbtack.school.hiring.error.serverException;

import java.util.ArrayDeque;
import java.util.UUID;

public interface EmployerDao {
    UUID InsertEmployer(Employer employer)throws serverException;
    void deleteEmployer(DeleteEmployer employer)throws serverException;
    void addVacancy(Vacancy vacancy);
    void deleteVacancy(Vacancy vacancy)throws serverException;
    ArrayDeque<getSummaryResponse> getSummary(getSummary requirement);
    ArrayDeque<getSummaryResponse> AllSummary(AllSummary summary);
    void editVacancy(EditVacancy vacancy)throws serverException;
}
