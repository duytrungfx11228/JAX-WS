package thread;

import entities.Student;
import org.apache.log4j.Logger;
import repository.StudentRepository;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadOne extends Thread{
    final static Logger logger = Logger.getLogger(StudentRepository.class.getName());
    private final Queue<Student> studentQueue;
    private final StudentRepository repository = new StudentRepository();
    private final Student student;
    public ThreadOne(Student student){
        studentQueue = new LinkedList<>();
        this.student = student;
    }
    @Override
    public void run(){
        studentQueue.add(student);
        if (studentQueue.size() > 0){
            repository.insertStudent(studentQueue.poll());
            logger.info("insert student successful");
        } else {
            logger.error("insert student failed");
        }

    }
}
