package net.thumbtack.school.hiring.dao;

import net.thumbtack.school.hiring.Models.*;
import net.thumbtack.school.hiring.request.Requirements;
import net.thumbtack.school.hiring.request.Skills;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface EmployerDao {
    UUID InsertEmployer(Employer employer);
    void deleteEmployer(DeleteEmployer employer);
    void addVacancy(Vacancy vacancy);
    void deleteVacancy(Vacancy vacancy);
    ArrayDeque<getSummaryResponse> getSummary(getSummary requirement);
   // ArrayList<Summary> AllSummary(AllSummary summary);
}
