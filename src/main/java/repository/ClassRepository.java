package repository;

import context.DbContext;
import entities.Class;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRepository {
    final static Logger logger = Logger.getLogger(StudentRepository.class.getName());
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public void insertClass(Class cla){
        try {
            String query = "INSERT into class (name,code) \r\n"
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

    public List<Class> getClassByName(String name){
        List<Class> list = new ArrayList<>();

        try {
            String query = "SELECT * FROM class WHERE name=?";
            conn = new DbContext().connection();
            ps = conn.prepareStatement(query);
            ps.setString(1,name);
            rs = ps.executeQuery();
            while (rs.next()) {
                Class clas = new Class();
                clas.setName(rs.getString(1));
                clas.setCode(rs.getString(2));
                list.add(clas);
            }
            if (list.size() >0){
                logger.info("successful");
            } else {
                logger.info("className not exits");
            }

            ps.close();
            conn.close();

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return list;
    }
}
