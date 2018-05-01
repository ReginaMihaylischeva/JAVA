package net.thumbtack.school.hiring.DataBase;

import net.thumbtack.school.hiring.Models.*;
import net.thumbtack.school.hiring.request.Requirements;
import net.thumbtack.school.hiring.request.Skills;

import java.util.*;

public class DataBase {
    private Map<String, net.thumbtack.school.hiring.Models.Employee> dataBaseEmployee;
    private Map<String, net.thumbtack.school.hiring.Models.Employer> dataBaseEmployer;

    private Map<String, List<Skills>> dataBaseSummary;
    private Map<String, Vacancy> dataBaseVacancies;

    public UUID Insert(net.thumbtack.school.hiring.Models.Employee Employee, String login) {
        dataBaseEmployee.put(UUID.fromString(login).toString(), Employee);
        return UUID.fromString(login);
    }

    public void Delete(DeleteEmployee employee) {
        dataBaseSummary.remove(employee.getToken());
        dataBaseEmployee.remove(employee.getToken());

    }

    public void AddSummary(Summary summary) {
        dataBaseSummary.put(summary.getToken(), summary.getSkills());
    }


    //ну такое
    public ArrayDeque<getVacanciesResponse> getVacancies(getVacancies GetVacancies) {
        int count = 0;
        int oldCount = 0;
        ArrayDeque<getVacanciesResponse> NewList = new ArrayDeque<>();
        for (Vacancy vacancies : dataBaseVacancies.values()) {
            for (Skills skills : GetVacancies.getSkills()) {
                for (Requirements Requirement : vacancies.getRequirements()) {
                    if (skills.getNameRequirement().equals(Requirement.getNameRequirement()) & skills.getLevelProficiency() >= Requirement.getLevelProficiency() & !GetVacancies.isCompulsion() & GetVacancies.isCheckAllSkills()) {
                        count++;
                    }
                    if (skills.getNameRequirement().equals(Requirement.getNameRequirement()) & skills.getLevelProficiency() >= Requirement.getLevelProficiency() & GetVacancies.isCompulsion()  & GetVacancies.isCheckAllSkills()) {
                        count++;
                    }
                    if (skills.getNameRequirement().equals(Requirement.getNameRequirement()) & skills.getLevelProficiency() == 0 & GetVacancies.isCheckAllSkills()) {
                        count++;
                    }
                    if (skills.getNameRequirement().equals(Requirement.getNameRequirement()) & skills.getLevelProficiency() >= Requirement.getLevelProficiency() & !GetVacancies.isCheckAllSkills()) {
                        count++;
                    }
                }


            }

            if (count == GetVacancies.getSkills().size() & GetVacancies.isCheckAllSkills()) {
                Object firstKey = dataBaseVacancies.keySet().toArray()[0];
                Object valueForFirstKey = dataBaseVacancies.get(firstKey.toString());
                Employer sdf=dataBaseEmployer.get(valueForFirstKey.toString());
                getVacanciesResponse v=new getVacanciesResponse(

                        sdf.getFirstName(),
                        sdf.getLastName(),
                        sdf.getMiddlename(),
                        sdf.getEmail(),
                        vacancies,
                        sdf.getAddress(),
                        sdf.getCompanyName()

                );
                NewList.add(v);
            }
            if (count != 0 & !GetVacancies.isCheckAllSkills()) {
                Object firstKey = dataBaseVacancies.keySet().toArray()[0];
                Object valueForFirstKey = dataBaseVacancies.get(firstKey.toString());
                Employer sdf=dataBaseEmployer.get(valueForFirstKey.toString());
                getVacanciesResponse v=new getVacanciesResponse(

                        sdf.getFirstName(),
                        sdf.getLastName(),
                        sdf.getMiddlename(),
                        sdf.getEmail(),
                        vacancies,
                        sdf.getAddress(),
                        sdf.getCompanyName()

                );
                if (oldCount > count) {
                    NewList.addLast(v);
                } else {
                    NewList.addFirst(v);
                }
                oldCount = count;
            }
            count = 0;


        }
        return NewList;

    }

    public void deleteSummary(Summary summary) {
        dataBaseSummary.remove(summary.getToken(), summary.getSkills());
    }

    public UUID InsertEmployer(net.thumbtack.school.hiring.Models.Employer Employer, String login) {
        dataBaseEmployer.put(UUID.fromString(login).toString(), Employer);
        return UUID.fromString(login);
    }

    public void DeleteEmployer(DeleteEmployer employer) {
        dataBaseVacancies.remove(employer.getToken().toString());
        dataBaseEmployer.remove(employer.getToken().toString());

    }

    public void AddVacancy(Vacancy vacancy) {
        dataBaseVacancies.put(vacancy.getToken(), vacancy);
    }

    public void deleteVacancy(Vacancy vacancy) {
        dataBaseVacancies.remove(vacancy.getToken(), vacancy);
    }

    public   ArrayList<Vacancy>   allVacancies(AllVacancies vacancies){
        return new ArrayList<>(dataBaseVacancies.values());}


    public  ArrayDeque<getSummaryResponse> getSummary(getSummary requirements){
        ArrayDeque<getSummaryResponse> NewList = new ArrayDeque<>();

        int count = 0;
        int oldCount = 0;
        for (List<Skills> skills : dataBaseSummary.values()){
            for (Skills skill : skills){
                for (Requirements requirement : requirements.getRequirements()){
                    if (skill.getNameRequirement().equals(requirement.getNameRequirement()) & skill.getLevelProficiency() >= requirement.getLevelProficiency() & !requirements.isCompulsion()&requirements.isCheckAllRequirements()) {
                        count++;
                    }
                    if (skill.getNameRequirement().equals(requirement.getNameRequirement()) & skill.getLevelProficiency() >= requirement.getLevelProficiency() & requirements.isCompulsion()&requirements.isCheckAllRequirements()) {
                        count++;
                    }
                    if (skill.getNameRequirement().equals(requirement.getNameRequirement()) & requirement.getLevelProficiency() ==0 &requirements.isCheckAllRequirements()) {
                        count++;
                    }
                    if (skill.getNameRequirement().equals(requirement.getNameRequirement()) & skill.getLevelProficiency() >= requirement.getLevelProficiency() & !requirements.isCheckAllRequirements()) {
                        count++;
                    }

                }


            }
            if (count == requirements.getRequirements().size() & requirements.isCheckAllRequirements()) {
                Object firstKey = dataBaseSummary.keySet().toArray()[0];
                Object valueForFirstKey = dataBaseSummary.get(firstKey.toString());
                Employee sdf=dataBaseEmployee.get(valueForFirstKey.toString());
                getSummaryResponse v=new getSummaryResponse(

                        sdf.getFirstName(),
                        sdf.getLastName(),
                        sdf.getMiddlename(),
                        sdf.getEmail(),
                         skills,
                        sdf.getAge()
                );
                NewList.add(v);
            }
            if (count != 0 & !requirements.isCheckAllRequirements()) {
                Object firstKey = dataBaseSummary.keySet().toArray()[0];
                Object valueForFirstKey = dataBaseSummary.get(firstKey.toString());
                Employee sdf=dataBaseEmployee.get(valueForFirstKey.toString());
                getSummaryResponse v=new getSummaryResponse(

                        sdf.getFirstName(),
                        sdf.getLastName(),
                        sdf.getMiddlename(),
                        sdf.getEmail(),
                        skills,
                        sdf.getAge()
                );
                if (oldCount > count) {
                    NewList.addLast(v);
                } else {
                    NewList.addFirst(v);
                }
                oldCount = count;
            }
            count = 0;
        }
       return NewList;
    }

}
