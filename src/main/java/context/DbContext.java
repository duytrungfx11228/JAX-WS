package context;

import file.Xfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class DbContext {
    final static Logger logger = Logger.getLogger(DbContext.class.getName());
    public Connection connection() {

        Properties pro = Xfile.readFileProperties("db.properties");
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(pro.getProperty("connection"), pro.getProperty("username"), pro.getProperty("password"));
            logger.info("connect successful..");

            return conn;
        }  catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return null;
    }
}
