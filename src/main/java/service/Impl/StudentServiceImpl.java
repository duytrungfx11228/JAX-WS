package service.Impl;

import entities.Student;
import file.Xfile;
import org.apache.log4j.Logger;
import repository.ClassRepository;
import repository.StudentRepository;
import service.ClassService;
import service.StudentService;
import thread.ThreadOne;

import javax.inject.Inject;
import javax.jws.WebService;

@WebService(endpointInterface = "service.StudentService")
public class StudentServiceImpl implements StudentService {
    final static Logger logger = Logger.getLogger(StudentRepository.class.getName());
    @Inject
    ClassRepository classRepository;
    @Inject
    ClassService classService;
    @Override
    public boolean checkLogin(String username, String password) {
        if (username!=null&&password != null && username.equals(Xfile.readFileProperties("app.properties").getProperty("username"))
        && password.equals(Xfile.readFileProperties("app.properties").getProperty("password"))){
            logger.info("login successful");
            return true;
        }
        logger.error("login failed");
        return false;
    }

    @Override
    public Student addStudentFake(String username, String password, String name, String code, int age, String className, String address, float mark) {
        if (checkLogin(username, password)){
            Student student = new Student(name,code,age,className,address,mark);
            ThreadOne th1 = new ThreadOne(student);
            th1.start();
            logger.info("insert successful");
            return student;
        }
        logger.error("insert failed");
        return null;
    }

    @Override
    public Student addStudentReal(String username, String password, String name, String code, int age, String className, String address, float mark) {
        if (checkLogin(username, password)){

            if (classRepository.getClassByName(className) == null){
                int ok = classService.addClass(username,password,className,"code");
                if (ok == 1){
                    logger.error("add student failed ");
                    return null;
                }
            }

            Student student = new Student(name,code,age,className,address,mark);
            ThreadOne th1 = new ThreadOne(student);
            th1.start();
            logger.info("insert successful");
            return student;
        }
        logger.error("add student failed ");
        return null;
    }
}
