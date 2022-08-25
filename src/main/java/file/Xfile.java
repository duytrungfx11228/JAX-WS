package file;


import entities.User;
import org.apache.log4j.Logger;
import repository.StudentRepository;

import java.io.*;

import java.util.Properties;
import static constants.Constants.*;

public class Xfile {
    final static Logger logger = Logger.getLogger(StudentRepository.class.getName());
    public static Properties readFileProperties(String file){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));

            logger.info("read file successful");
        } catch (IOException e) {
            logger.error("read file failed");
        }
        return properties;
    }
    public static User getUser(){
        Properties pro = readFileProperties(APP_CONF);
        User user = new User();
        user.setUsername(pro.getProperty(USER_NAME));
        user.setPassword(pro.getProperty(PASSWORD));
        return user;
    }
}
