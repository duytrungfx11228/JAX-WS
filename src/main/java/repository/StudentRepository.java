package repository;

import context.DbContext;
import entities.Student;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentRepository {
    final static Logger logger = Logger.getLogger(StudentRepository.class.getName());
    Connection conn = null;
    PreparedStatement ps = null;

    public void insertStudent( Student student)  {
        try {
            String query = "INSERT into student ( name,code, age, className, address, mark) \r\n"
                    + "VALUES (?,?,?,?,?,?)";
            conn = new DbContext().connection();
            ps = conn.prepareStatement(query);

            ps.setString(1, student.getName());
            ps.setString(2, student.getCode());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getClassName());
            ps.setString(5, student.getAddress());
            ps.setFloat(6, student.getMark());
            ps.executeUpdate();
            ps.close();
            conn.close();
            logger.info("insert class successful");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

    }
}
