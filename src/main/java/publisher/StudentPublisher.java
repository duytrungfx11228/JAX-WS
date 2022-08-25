package publisher;



import service.Impl.ClassServiceImpl;
import service.Impl.StudentServiceImpl;


import javax.xml.ws.Endpoint;

public class StudentPublisher {
	
	private static final String ULR_STUDENT= "http://localhost:8088/student";
	private static final String URL_CLASS = "http://localhost:8088/class";

	public static void main(String[] args) {
		
		Endpoint.publish(ULR_STUDENT, new StudentServiceImpl());
		Endpoint.publish(URL_CLASS, new ClassServiceImpl());
		
	}

}
