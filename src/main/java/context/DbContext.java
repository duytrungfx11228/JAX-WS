package context;

import file.Xfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;
import static constants.Constants.*;
public class DbContext {
    final static Logger logger = Logger.getLogger(DbContext.class.getName());
    public Connection connection() {

        Properties pro = Xfile.readFileProperties(DB_CONF);
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(pro.getProperty(CONNECTION), pro.getProperty(USER_NAME), pro.getProperty(PASSWORD));
            logger.info("connect successful..");

        }  catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return conn;
    }
}
