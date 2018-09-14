package net.thumbtack.school.database.jdbc;

import java.sql.PreparedStatement;

import net.thumbtack.school.database.model.Group;
import net.thumbtack.school.database.model.School;
import net.thumbtack.school.database.model.Subject;
import net.thumbtack.school.database.model.Trainee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class JdbcService {


    public static void insertTrainee(Trainee trainee) throws SQLException {
        String insertQuery = "INSERT INTO trainee VALUES (?,?,?,?)";
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(insertQuery, RETURN_GENERATED_KEYS);
        stmt.setNull(1, java.sql.Types.INTEGER);
        stmt.setString(2, trainee.getFirstName());
        stmt.setString(3, trainee.getLastName());
        stmt.setInt(4, trainee.getRating());
        stmt.executeUpdate();
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        generatedKeys.next();
        trainee.setId(generatedKeys.getInt(1));
    }

    public static void updateTrainee(Trainee trainee) throws SQLException {
        String updateQuery = " UPDATE trainee SET  firstname=?, lastname = ?,rating=?";
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(updateQuery);
        stmt.setString(1, trainee.getFirstName());
        stmt.setString(2, trainee.getLastName());
        stmt.setInt(3, trainee.getRating());
        stmt.executeUpdate();
    }

    public static Trainee getTraineeByIdUsingColNames(int traineeId) throws SQLException {
        String getTraineeByIdUsingColNamesQuery = "SELECT id,firstname, lastname, rating FROM trainee WHERE Id=" + traineeId;
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getTraineeByIdUsingColNamesQuery);
        ResultSet rs = stmt.executeQuery(getTraineeByIdUsingColNamesQuery);
        if (rs.next()) {

            return new Trainee(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getInt("rating"));
        }
        return null;
    }

    public static Trainee getTraineeByIdUsingColNumbers(int traineeId) throws SQLException {
        String getTraineeByIdUsingColNamesQuery = "SELECT id, firstname, lastname, rating FROM trainee WHERE Id=" + traineeId;
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getTraineeByIdUsingColNamesQuery);
        ResultSet rs = stmt.executeQuery(getTraineeByIdUsingColNamesQuery);
        if (rs.next()) {

            return new Trainee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
        }
        return null;
    }

    public static List<Trainee> getTraineesUsingColNames() throws SQLException {
        String getTraineeByIdUsingColNamesQuery = "SELECT id, firstname, lastname, rating FROM trainee";
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getTraineeByIdUsingColNamesQuery);
        ResultSet rs = stmt.executeQuery(getTraineeByIdUsingColNamesQuery);
        List<Trainee> Trainees = new ArrayList<>();
        while (rs.next()) {
            Trainees.add(new Trainee(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getInt("rating")));
        }
        if (Trainees.isEmpty()) {
            return null;
        }
        return Trainees;
    }

    public static List<Trainee> getTraineesUsingColNumbers() throws SQLException {
        String getTraineeByIdUsingColNamesQuery = "SELECT id, firstname, lastname, rating FROM trainee";
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getTraineeByIdUsingColNamesQuery);
        ResultSet rs = stmt.executeQuery(getTraineeByIdUsingColNamesQuery);
        List<Trainee> Trainees = new ArrayList<>();
        while (rs.next()) {
            Trainees.add(new Trainee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
        }
        if (Trainees.isEmpty()) {
            return null;
        }
        return Trainees;

    }

    public static void deleteTrainee(Trainee trainee) throws SQLException {
        String deleteQuery = "DELETE FROM trainee WHERE  firstname=\'" + trainee.getFirstName() + "\' and lastname=\'" + trainee.getLastName() + "\' and rating=\'" + trainee.getRating() + "\';";
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(deleteQuery);
        stmt.executeUpdate(deleteQuery);
    }

    public static void deleteTrainees() throws SQLException {
        String deleteQuery = "Delete from trainee ";
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(deleteQuery);
        stmt.executeUpdate(deleteQuery);
    }

    public static void insertSubject(Subject subject) throws SQLException {
        String insertQuery = "INSERT INTO subject VALUES (?,?)";
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(insertQuery, RETURN_GENERATED_KEYS);
        stmt.setNull(1, java.sql.Types.INTEGER);
        stmt.setString(2, subject.getName());
        stmt.executeUpdate();
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        generatedKeys.next();
        subject.setId(generatedKeys.getInt(1));
    }

    public static Subject getSubjectByIdUsingColNames(int subjectId) throws SQLException {
        String getSubjectByIdUsingColNames = "SELECT id,name FROM subject WHERE Id=" + subjectId;
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getSubjectByIdUsingColNames);
        ResultSet rs = stmt.executeQuery(getSubjectByIdUsingColNames);
        if (rs.next()) {

            return new Subject(rs.getInt("id"), rs.getString("name"));
        }
        return null;
    }

    public static Subject getSubjectByIdUsingColNumbers(int subjectId) throws SQLException {
        String getSubjectByIdUsingColNames = "SELECT id,name FROM subject WHERE Id=" + subjectId;
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getSubjectByIdUsingColNames);
        ResultSet rs = stmt.executeQuery(getSubjectByIdUsingColNames);
        if (rs.next()) {

            return new Subject(rs.getInt(1), rs.getString(2));
        }
        return null;


    }

    public static void deleteSubjects() throws SQLException {
        String deleteQuery = "delete from subject ";
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(deleteQuery);
        stmt.executeUpdate();
    }

    public static void insertSchool(School school) throws SQLException {
        String insertQuery = "INSERT INTO school VALUES (?,?,?)";
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(insertQuery, RETURN_GENERATED_KEYS);
        stmt.setNull(1, java.sql.Types.INTEGER);
        stmt.setString(2, school.getName());
        stmt.setInt(3, school.getYear());
        stmt.executeUpdate();
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        generatedKeys.next();
        school.setId(generatedKeys.getInt(1));
    }

    public static School getSchoolByIdUsingColNames(int schoolId) throws SQLException {
        String getSubjectByIdUsingColNames = "SELECT id, name,year FROM school WHERE Id=" + schoolId;
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getSubjectByIdUsingColNames);
        ResultSet rs = stmt.executeQuery(getSubjectByIdUsingColNames);
        while (rs.next()) {

            return new School(rs.getInt("id"), rs.getString("name"), rs.getInt("year"));
        }
        return null;
    }

    public static School getSchoolByIdUsingColNumbers(int schoolId) throws SQLException {
        String getSubjectByIdUsingColNames = "SELECT id,name,year FROM school WHERE Id=" + schoolId;
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getSubjectByIdUsingColNames);
        ResultSet rs = stmt.executeQuery(getSubjectByIdUsingColNames);
        if (rs.next()) {

            return new School(rs.getInt(1), rs.getString(2), rs.getInt(3));
        }
        return null;
    }

    public static void deleteSchools() throws SQLException {
        String deleteQuery = "delete from school ";
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(deleteQuery);
        stmt.executeUpdate();
    }

    public static void insertGroup(School school, Group group) throws SQLException {
        String insertQuery = "INSERT INTO groupe VALUES (?,?,?,?)";
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(insertQuery, RETURN_GENERATED_KEYS);
        stmt.setNull(1, java.sql.Types.INTEGER);
        stmt.setString(2, group.getName());
        stmt.setString(3, group.getRoom());
        stmt.setInt(4, school.getId());
        stmt.executeUpdate();
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        generatedKeys.next();
        group.setId(generatedKeys.getInt(1));
    }

    public static School getSchoolByIdWithGroups(int id) throws SQLException {
        String getSchoolByIdWithGroupsQuery = "SELECT * FROM ttschool.groupe,ttschool.school Where (schoolid=ttschool.school.id =" + id + ")";
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getSchoolByIdWithGroupsQuery);
        ResultSet rs = stmt.executeQuery(getSchoolByIdWithGroupsQuery);
        List<Group> Group = new ArrayList<>();

        if (rs.wasNull()) {
            return null;
        }

        while (!rs.isLast()) {
            rs.next();
            Group.add(new Group(rs.getInt("id"), rs.getString("name"), rs.getString("room")));
        }

        return new School(rs.getInt("school.id"), rs.getString("school.name"), rs.getInt("year"), Group);


    }

    public static List<School> getSchoolsWithGroups() throws SQLException {
        String getSchoolByIdWithGroupsQuery = "SELECT * FROM ttschool.groupe,ttschool.school Where (schoolid=ttschool.school.id) group by school.id,groupe.id";
        PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getSchoolByIdWithGroupsQuery);
        ResultSet rs = stmt.executeQuery(getSchoolByIdWithGroupsQuery);
        List<School> School = new ArrayList<>();
        if (rs.wasNull()) {
            return null;
        }
        while (rs.next()) {
            School school = new School(rs.getInt("school.id"), rs.getString("school.name"), rs.getInt("year"), new ArrayList<>());
            if (!School.contains(school)) {
                School.add(school);
            }

        }

        rs.beforeFirst();
        while (rs.next()) {

            Group group = new Group(rs.getInt("groupe.id"), rs.getString("name"), rs.getString("room"));
            for (int i = 0; i < School.size(); i++) {

                if (School.get(i).getId() == rs.getInt("schoolid")) {
                    School.get(i).getGroups().add(group);
                }


            }


        }
        return School;
    }

}
