package net.thumbtack.school.hiring.DataBase;

import net.thumbtack.school.hiring.Models.*;
import net.thumbtack.school.hiring.Models.Requirements;
import net.thumbtack.school.hiring.Models.Skills;
import net.thumbtack.school.hiring.error.ServerErrorCode;
import net.thumbtack.school.hiring.error.serverException;

import java.util.*;

public class DataBase {
    private static DataBase instance;


    public static DataBase getInstance() {
        if (instance == null) {
            synchronized (DataBase.class) {
                {
                    instance = new DataBase();
                }
            }
        }
        return instance;
    }

    private DataBase() {
    }

    public Map<String, Employee> getDataBaseEmployee() {return dataBaseEmployee; }

    public Map<String, Employer> getDataBaseEmployer() {
        return dataBaseEmployer;
    }

    public Map<String, List<Skills>> getDataBaseSummary() {
        return dataBaseSummary;
    }

    public Map<String, Vacancy> getDataBaseVacancies() {
        return dataBaseVacancies;
    }

    private Map<String, Employee> dataBaseEmployee = new HashMap<>();
    private Map<String, Employer> dataBaseEmployer = new HashMap<>();
    private Map<String, List<Skills>> dataBaseSummary = new HashMap<>();
    private Map<String, Vacancy> dataBaseVacancies = new HashMap<>();

    public String Insert(Employee employee, String login) throws serverException {
        if (dataBaseEmployee != null) {
            for (Employee employee1 : dataBaseEmployee.values()) {
                if (employee1.getLogin().equals(login)) {
                    throw new serverException(ServerErrorCode.user_already_registered);
                }
            }
        }

        dataBaseEmployee.put(employee.getToken(), employee);
        return (employee.getToken());

    }

    public void Delete(Delete employee) throws serverException {
        if (!(dataBaseSummary.containsKey(employee.getToken()) | dataBaseEmployee.containsKey(employee.getToken()))) {
            throw new serverException(ServerErrorCode.user_does_not_exist);
        }
        dataBaseSummary.remove(employee.getToken());
        dataBaseEmployee.remove(employee.getToken());

    }

    public void AddSummary(Summary summary) {
        dataBaseSummary.put(summary.getToken(), summary.getSkills());
    }


    //ну такое
    public ArrayDeque<ListEmployer> getVacancies(CriteriaEmployer CriteriaEmployer) {
        int count = 0;
        int oldCount = 0;
        ArrayDeque<ListEmployer> NewList = new ArrayDeque<>();
        for (Vacancy vacancies : dataBaseVacancies.values()) {
            for (Skills skills : CriteriaEmployer.getSkills()) {
                for (Requirements Requirement : vacancies.getRequirements()) {
                    if (skills.getNameRequirement().equals(Requirement.getNameRequirement()) & skills.getLevelProficiency() >= Requirement.getLevelProficiency() & !CriteriaEmployer.isCompulsion() & CriteriaEmployer.isCheckAllSkills()) {
                        count++;
                    }
                    if (skills.getNameRequirement().equals(Requirement.getNameRequirement()) & skills.getLevelProficiency() >= Requirement.getLevelProficiency() & CriteriaEmployer.isCompulsion() & CriteriaEmployer.isCheckAllSkills() &skills.getLevelProficiency() != 0) {
                        count++;
                    }
                    if (skills.getNameRequirement().equals(Requirement.getNameRequirement()) & skills.getLevelProficiency() == 0 & CriteriaEmployer.isCheckAllSkills()) {
                        count++;
                    }
                    if (skills.getNameRequirement().equals(Requirement.getNameRequirement()) & skills.getLevelProficiency() >= Requirement.getLevelProficiency() & !CriteriaEmployer.isCheckAllSkills()) {
                        count++;
                    }
                }


            }

            if (count == CriteriaEmployer.getSkills().size() & CriteriaEmployer.isCheckAllSkills() & vacancies.isActivity().equals("yes")) {
                Object firstKey = dataBaseVacancies.keySet().toArray()[0];
                Vacancy valueForFirstKey = dataBaseVacancies.get(firstKey.toString());
                Employer sdf = dataBaseEmployer.get(valueForFirstKey.getToken());
                ListEmployer v = new ListEmployer(

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
            if (count != 0 & !CriteriaEmployer.isCheckAllSkills() & vacancies.isActivity().equals("yes")) {
                Object firstKey = dataBaseVacancies.keySet().toArray()[1];
                Vacancy valueForFirstKey = dataBaseVacancies.get(firstKey.toString());
                Employer sdf = dataBaseEmployer.get(valueForFirstKey.getToken());
                ListEmployer v = new ListEmployer(

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

    public void deleteSummary(Delete summary) throws serverException {
        if (!dataBaseSummary.containsKey(summary.getToken())) {
            throw new serverException(ServerErrorCode.summary_does_not_exist);
        }
        dataBaseSummary.remove(summary.getToken());
    }

    public String InsertEmployer(Employer Employer, String login) throws serverException {
        for (Employer employer : dataBaseEmployer.values()) {
            if (employer.getLogin().equals(login)) {
                throw new serverException(ServerErrorCode.user_already_registered);
            }
        }
        dataBaseEmployer.put(Employer.getToken(), Employer);
        return Employer.getToken();
    }

    public void DeleteEmployer(Delete employer) throws serverException {
        if (!(dataBaseVacancies.containsKey(employer.getToken()) | dataBaseEmployer.containsKey(employer.getToken()))) {
            throw new serverException(ServerErrorCode.user_does_not_exist);
        }
        dataBaseVacancies.remove(employer.getToken());
        dataBaseEmployer.remove(employer.getToken());

    }

    public void AddVacancy(Vacancy vacancy) {
        dataBaseVacancies.put(vacancy.getToken(), vacancy);
    }

    public void deleteVacancy(Delete vacancy) throws serverException {
        if (!dataBaseVacancies.containsKey(vacancy.getToken())) {
            throw new serverException(ServerErrorCode.vacancy_does_not_exist);
        }
        dataBaseVacancies.remove(vacancy.getToken());
    }

    public ArrayDeque<ListEmployer> allVacancies(Vacancy vacancy) {
        ArrayDeque<ListEmployer> NewList = new ArrayDeque<>();

        for (Vacancy vacancies : dataBaseVacancies.values()) {

            Object firstKey = dataBaseVacancies.keySet().toArray()[0];
            Object valueForFirstKey = dataBaseVacancies.get(firstKey.toString());
            Employer sdf = dataBaseEmployer.get(valueForFirstKey.toString());
            ListEmployer v = new ListEmployer(

                    sdf.getFirstName(),
                    sdf.getLastName(),
                    sdf.getMiddlename(),
                    sdf.getEmail(),
                    vacancies,
                    sdf.getAddress(),
                    sdf.getCompanyName()

            );
            if (!vacancy.isActivity().isEmpty() & vacancy.isActivity().equals(vacancies.isActivity())) {
                NewList.add(v);
            }
            if (vacancy.isActivity().isEmpty()) {
                NewList.add(v);
            }
        }
        return NewList;
    }


    public ArrayDeque<ListEmployee> getSummary(CriteriaEmployee requirements) {
        ArrayDeque<ListEmployee> NewList = new ArrayDeque<>();

        int count = 0;
        int oldCount = 0;
        for (List<Skills> skills : dataBaseSummary.values()) {
            for (Skills skill : skills) {
                for (Requirements requirement : requirements.getRequirements()) {
                    if (skill.getNameRequirement().equals(requirement.getNameRequirement()) & skill.getLevelProficiency() >= requirement.getLevelProficiency() & !requirements.isCompulsion() & requirements.isCheckAllRequirements()) {
                        count++;
                    }
                    if (skill.getNameRequirement().equals(requirement.getNameRequirement()) & skill.getLevelProficiency() >= requirement.getLevelProficiency() & requirements.isCompulsion() & requirements.isCheckAllRequirements()&requirement.getLevelProficiency() != 0) {
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
                Employee sdf = dataBaseEmployee.get(firstKey.toString());
                ListEmployee v = new ListEmployee(

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
                Object firstKey = dataBaseSummary.keySet().toArray()[1];
                Employee sdf = dataBaseEmployee.get(firstKey.toString());
                ListEmployee v = new ListEmployee(

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

    public ArrayDeque<ListEmployee> allSummary(Summary summary) {
        ArrayDeque<ListEmployee> NewList = new ArrayDeque<>();
        for (List<Skills> skills : dataBaseSummary.values()) {
            Object firstKey = dataBaseSummary.keySet().toArray()[0];
            Object valueForFirstKey = dataBaseSummary.get(firstKey.toString());
            Employee sdf = dataBaseEmployee.get(valueForFirstKey.toString());
            ListEmployee v = new ListEmployee(

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

    public void editSummary(Summary editSummary) throws serverException {
        if (!dataBaseSummary.containsKey(editSummary.getToken())) {
            throw new serverException(ServerErrorCode.summary_does_not_exist);
        }
        dataBaseSummary.remove(editSummary.getToken());
        dataBaseSummary.put(editSummary.getToken(), editSummary.getSkills());
    }

    public void editVacancy(Vacancy editVacancy) throws serverException {
        if (!dataBaseVacancies.containsKey(editVacancy.getToken())) {
            throw new serverException(ServerErrorCode.vacancy_does_not_exist);
        }
        dataBaseVacancies.remove(editVacancy.getToken());
        dataBaseVacancies.put(editVacancy.getToken(), editVacancy);

    }
}
