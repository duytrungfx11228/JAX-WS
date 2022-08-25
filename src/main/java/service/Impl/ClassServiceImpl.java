package service.Impl;

import entities.Class;

import file.Xfile;
import org.apache.log4j.Logger;
import repository.ClassRepository;

import service.ClassService;



import javax.jws.WebService;


@WebService(endpointInterface = "service.ClassService")
public class ClassServiceImpl implements ClassService {
    final static Logger logger = Logger.getLogger(ClassServiceImpl.class.getName());

    private final ClassRepository classRepository = new ClassRepository();

    @Override
    public int addClass(String username, String password, String name, String code) {

        if (username!=null&&password != null && username.equals(Xfile.getUser().getUsername())
                && password.equals(Xfile.getUser().getPassword())){
            Class cla = new Class(name,code);
            classRepository.insertClass(cla);
            logger.info("successful");
            return 0;
        }
        logger.error("username and password are not right");
        return 1;
    }

    @Override
    public boolean checkClassByName(String name) {
        return classRepository.getClassByName(name).size()>0;
    }
}
