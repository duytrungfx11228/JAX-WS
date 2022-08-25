package service;

import entities.Class;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebService
public interface ClassService {
    int addClass(String username, String password, String name, String code);
    boolean checkClassByName(String name);
}
