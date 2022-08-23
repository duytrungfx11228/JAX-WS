package file;


import org.apache.log4j.Logger;
import repository.StudentRepository;

import java.io.*;

import java.util.Properties;

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
}
