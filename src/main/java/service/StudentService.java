package service;

import entities.Student;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebService
public interface StudentService {
    @WebMethod
    boolean checkLogin(String username,String password);
    @WebMethod
    Student addStudentFake(String username, String password, String name, String code, int age, String className, String address, float mark);
    @WebMethod
    Student addStudentReal(String username, String password, String name, String code, int age, String className, String address, float mark);
}
