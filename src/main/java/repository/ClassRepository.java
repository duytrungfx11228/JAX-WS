package repository;

import context.DbContext;
import entities.Class;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassRepository {
    final static Logger logger = Logger.getLogger(StudentRepository.class.getName());
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public void insertClass(Class cla){

        try {
            String query = "INSERT into student ( name,code) \r\n"
                    + "VALUES (?,?)";
            conn = new DbContext().connection();
            ps = conn.prepareStatement(query);
            ps.setString(1,cla.getName());
            ps.setString(2,cla.getCode());
            ps.executeUpdate();
            ps.close();
            conn.close();
            logger.info("insert successful");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    public Class getClassByName(String name){
        try {
            String query = "SELECT * FROM class WHERE name=?";
            conn = new DbContext().connection();
            ps = conn.prepareStatement(query);
            ps.setString(1,name);
            rs = ps.executeQuery();

            ps.close();
            conn.close();
            while (rs.next()){
                return new Class(rs.getString(1),rs.getString(2));
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return null;
    }
}
