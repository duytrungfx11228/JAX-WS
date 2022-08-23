package service.Impl;

import entities.Class;
import file.Xfile;
import org.apache.log4j.Logger;
import repository.ClassRepository;
import repository.StudentRepository;
import service.ClassService;

import javax.inject.Inject;
import javax.jws.WebService;
import java.util.Properties;

@WebService(endpointInterface = "service.ClassService")
public class ClassServiceImpl implements ClassService {
    final static Logger logger = Logger.getLogger(ClassServiceImpl.class.getName());
    @Inject
    ClassRepository classRepository;
    @Override
    public int addClass(String username, String password, String name, String code) {
        Properties pro = Xfile.readFileProperties("app.properties");
        if (username != null && password != null && username.equals(pro.getProperty("username"))
        && password.equals(pro.getProperty("password"))){
            Class cla = new Class(name,code);
            classRepository.insertClass(cla);
            return 0;
        }
        logger.error("username and password are not right");
        return 1;
    }
}
