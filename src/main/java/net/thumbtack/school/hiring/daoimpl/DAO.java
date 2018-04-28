package net.thumbtack.school.hiring.daoimpl;

import net.thumbtack.school.hiring.DataBase.DataBase;
import net.thumbtack.school.hiring.Models.Employee;
import net.thumbtack.school.hiring.dao.EmployeeDao;

public abstract class DAO  implements EmployeeDao {
    private   DataBase database=new DataBase();
    int insert(Employee employee) {
// здесь код добавления в базу данных
      // return database.insert(employee);
return  1;
    }
}
