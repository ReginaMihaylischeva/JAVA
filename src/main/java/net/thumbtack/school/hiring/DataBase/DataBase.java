package net.thumbtack.school.hiring.DataBase;

import net.thumbtack.school.hiring.Models.*;
import net.thumbtack.school.hiring.Models.Requirements;
import net.thumbtack.school.hiring.Models.Skills;
import net.thumbtack.school.hiring.error.ServerErrorCode;
import net.thumbtack.school.hiring.error.serverException;

import java.util.*;

public class    DataBase {
    private static DataBase instance;
   /* private static DataBase instance;

    public static  synchronized DataBase getInstance(Map<String, Employee> dataBaseEmployee,Map<String, Employer> dataBaseEmployer,Map<String, List<Skills>> dataBaseSummary,Map<String, Vacancy> dataBaseVacancies) {
        if (instance == null) {
            instance = new DataBase(dataBaseEmployee, dataBaseEmployer, dataBaseSummary,dataBaseVacancies);
        }
        return instance;
    }
    private DataBase(Map<String, Employee> dataBaseEmployee,Map<String, Employer> dataBaseEmployer,Map<String, List<Skills>> dataBaseSummary,Map<String, Vacancy> dataBaseVacancies) {
        // Этот код эмулирует медленную инициализацию.
        this.dataBaseEmployer = dataBaseEmployer;
        this.dataBaseEmployee = dataBaseEmployee;
        this.dataBaseSummary = dataBaseSummary;
        this.dataBaseVacancies = dataBaseVacancies;

    }*/

/*
    private DataBase() {}

    private static class SingletonHolder {
        public static final DataBase instance = new DataBase();
    }

    public static DataBase getInstance()  {
        return SingletonHolder.instance;

    }*/

    public static DataBase getInstance() {
        if (instance == null) {
          //  synchronized (DataBase.class) {
            {
             //   if (instance == null) {
                    instance = new DataBase();
              //  }
            }
        }
        return instance;
    }

    private DataBase() {}

    public Map<String, Employee> getDataBaseEmployee() {
        return dataBaseEmployee;
    }

    public Map<String, Employer> getDataBaseEmployer() {
        return dataBaseEmployer;
    }

    public Map<String, List<Skills>> getDataBaseSummary() {
        return dataBaseSummary;
    }

    public Map<String, Vacancy> getDataBaseVacancies() {
        return dataBaseVacancies;
    }

    private    Map<String, Employee> dataBaseEmployee=new HashMap<>();
    private Map<String, Employer> dataBaseEmployer=new HashMap<>();
    private Map<String, List<Skills>> dataBaseSummary=new HashMap<>();
    private  Map<String, Vacancy> dataBaseVacancies=new HashMap<>();

    public String Insert(Employee employee, String login) throws serverException {
        if(dataBaseEmployee != null) {
            for (Employee employee1 : dataBaseEmployee.values()) {
                if (employee1.getLogin().equals(login)) {
                    throw new serverException(ServerErrorCode.user_already_registered);
                }
            }
        }

        dataBaseEmployee.put(employee.getToken(),employee);
        return (employee.getToken());

    }

    public void Delete(DeleteEmployee employee)throws serverException{
     if   ( !(dataBaseSummary.containsKey(employee.getToken())|dataBaseEmployee.containsKey(employee.getToken()))){
         throw new serverException(ServerErrorCode.user_does_not_exist);
     }
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
                    if (skills.getNameRequirement().equals(Requirement.getNameRequirement()) & skills.getLevelProficiency() >= Requirement.getLevelProficiency() & GetVacancies.isCompulsion() & GetVacancies.isCheckAllSkills()) {
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

            if (count == GetVacancies.getSkills().size() & GetVacancies.isCheckAllSkills() & vacancies.isActivity().equals("yes")) {
                Object firstKey = dataBaseVacancies.keySet().toArray()[0];
                Object valueForFirstKey = dataBaseVacancies.get(firstKey.toString());
                Employer sdf = dataBaseEmployer.get(valueForFirstKey.toString());
                getVacanciesResponse v = new getVacanciesResponse(

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
            if (count != 0 & !GetVacancies.isCheckAllSkills() & vacancies.isActivity().equals("yes")) {
                Object firstKey = dataBaseVacancies.keySet().toArray()[0];
                Object valueForFirstKey = dataBaseVacancies.get(firstKey.toString());
                Employer sdf = dataBaseEmployer.get(valueForFirstKey.toString());
                getVacanciesResponse v = new getVacanciesResponse(

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

    public void deleteSummary(Summary summary) throws serverException{
        if    (!dataBaseSummary.containsValue(summary.getSkills())){
            throw new serverException(ServerErrorCode.summary_does_not_exist);
        }
        dataBaseSummary.remove(summary.getToken(), summary.getSkills());
    }

    public UUID InsertEmployer(net.thumbtack.school.hiring.Models.Employer Employer, String login)throws serverException {
        for(Employer employer :dataBaseEmployer.values()){
            if(employer.getLogin().equals(login)){ throw new serverException(ServerErrorCode.user_already_registered); }
        }
        dataBaseEmployer.put(UUID.fromString(login).toString(), Employer);
        return UUID.fromString(login);
    }

    public void DeleteEmployer(DeleteEmployer employer) throws serverException{
        if   ( !(dataBaseVacancies.containsKey(employer.getToken().toString())|dataBaseEmployer.containsKey(employer.getToken().toString()))){
            throw new serverException(ServerErrorCode.user_does_not_exist);
        }
        dataBaseVacancies.remove(employer.getToken().toString());
        dataBaseEmployer.remove(employer.getToken().toString());

    }

    public void AddVacancy(Vacancy vacancy) {
        dataBaseVacancies.put(vacancy.getToken(), vacancy);
    }

    public void deleteVacancy(Vacancy vacancy) throws serverException{
        if    (!dataBaseVacancies.containsValue(vacancy)){
            throw new serverException(ServerErrorCode.vacancy_does_not_exist);
        }
        dataBaseVacancies.remove(vacancy.getToken(), vacancy);
    }

    public ArrayDeque<getVacanciesResponse> allVacancies(AllVacancies vacancy) {
        ArrayDeque<getVacanciesResponse> NewList = new ArrayDeque<>();

        for (Vacancy vacancies : dataBaseVacancies.values()) {

            Object firstKey = dataBaseVacancies.keySet().toArray()[0];
            Object valueForFirstKey = dataBaseVacancies.get(firstKey.toString());
            Employer sdf = dataBaseEmployer.get(valueForFirstKey.toString());
            getVacanciesResponse v = new getVacanciesResponse(

                    sdf.getFirstName(),
                    sdf.getLastName(),
                    sdf.getMiddlename(),
                    sdf.getEmail(),
                    vacancies,
                    sdf.getAddress(),
                    sdf.getCompanyName()

            );
            if (!vacancy.getActivity().isEmpty() & vacancy.getActivity().equals(vacancies.isActivity())) {
                NewList.add(v);
            }
            if (vacancy.getActivity().isEmpty()) {
                NewList.add(v);
            }
        }
        return NewList;
    }


    public ArrayDeque<getSummaryResponse> getSummary(getSummary requirements) {
        ArrayDeque<getSummaryResponse> NewList = new ArrayDeque<>();

        int count = 0;
        int oldCount = 0;
        for (List<Skills> skills : dataBaseSummary.values()) {
            for (Skills skill : skills) {
                for (Requirements requirement : requirements.getRequirements()) {
                    if (skill.getNameRequirement().equals(requirement.getNameRequirement()) & skill.getLevelProficiency() >= requirement.getLevelProficiency() & !requirements.isCompulsion() & requirements.isCheckAllRequirements()) {
                        count++;
                    }
                    if (skill.getNameRequirement().equals(requirement.getNameRequirement()) & skill.getLevelProficiency() >= requirement.getLevelProficiency() & requirements.isCompulsion() & requirements.isCheckAllRequirements()) {
                        count++;
                    }
                    if (skill.getNameRequirement().equals(requirement.getNameRequirement()) & requirement.getLevelProficiency() == 0 & requirements.isCheckAllRequirements()) {
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
                Employee sdf = dataBaseEmployee.get(valueForFirstKey.toString());
                getSummaryResponse v = new getSummaryResponse(

                        sdf.getFirstName(),
                        sdf.getLastName(),
                        sdf.getMiddlename(),
                        sdf.getEmail(),
                        skills,
                        sdf.getAge()
                );
                if (sdf.isActivity()) {
                    NewList.add(v);
                }
            }
            if (count != 0 & !requirements.isCheckAllRequirements()) {
                Object firstKey = dataBaseSummary.keySet().toArray()[0];
                Object valueForFirstKey = dataBaseSummary.get(firstKey.toString());
                Employee sdf = dataBaseEmployee.get(valueForFirstKey.toString());
                getSummaryResponse v = new getSummaryResponse(

                        sdf.getFirstName(),
                        sdf.getLastName(),
                        sdf.getMiddlename(),
                        sdf.getEmail(),
                        skills,
                        sdf.getAge()
                );
                if (sdf.isActivity()) {

                    if (oldCount > count) {
                        NewList.addLast(v);
                    } else {
                        NewList.addFirst(v);
                    }
                    oldCount = count;
                }
            }
            count = 0;
        }
        return NewList;
    }

    public ArrayDeque<getSummaryResponse> allSummary(AllSummary summary) {
        ArrayDeque<getSummaryResponse> NewList = new ArrayDeque<>();
        for (List<Skills> skills : dataBaseSummary.values()) {
            Object firstKey = dataBaseSummary.keySet().toArray()[0];
            Object valueForFirstKey = dataBaseSummary.get(firstKey.toString());
            Employee sdf = dataBaseEmployee.get(valueForFirstKey.toString());
            getSummaryResponse v = new getSummaryResponse(

                    sdf.getFirstName(),
                    sdf.getLastName(),
                    sdf.getMiddlename(),
                    sdf.getEmail(),
                    skills,
                    sdf.getAge()
            );
            NewList.add(v);
        }
        return NewList;
    }

    public void editSummary(EditSummary editSummary) throws serverException {
        if    (!dataBaseSummary.containsKey(editSummary.getToken())){
            throw new serverException(ServerErrorCode.summary_does_not_exist);
        }
        List<Skills> skills = dataBaseSummary.get(editSummary.getToken());
        if (editSummary.getOldSkills().isEmpty()) {
            skills.addAll(editSummary.getNewSkills());
        }
        if (editSummary.getNewSkills().isEmpty()) {
            skills.removeAll(editSummary.getOldSkills());
        }
        if (!editSummary.getNewSkills().isEmpty() & !editSummary.getOldSkills().isEmpty()) {
            skills.removeAll(editSummary.getOldSkills());
            skills.addAll(editSummary.getNewSkills());
        }
    }

    public void editVacancy(EditVacancy editVacancy) throws serverException {
        if    (!dataBaseVacancies.containsKey(editVacancy.getToken())){
            throw new serverException(ServerErrorCode.vacancy_does_not_exist);
        }
        List<Requirements> requirements = dataBaseVacancies.get(editVacancy.getToken()).getRequirements();
        if (editVacancy.getOldRequirements().isEmpty()) {
            requirements.addAll(editVacancy.getNewRequirements());
        }
        if (editVacancy.getNewRequirements().isEmpty()) {
            requirements.removeAll(editVacancy.getOldRequirements());
        }
        if (!editVacancy.getNewRequirements().isEmpty() & !editVacancy.getOldRequirements().isEmpty()) {
            requirements.removeAll(editVacancy.getOldRequirements());
            requirements.addAll(editVacancy.getNewRequirements());
        }

    }
}
