package thread;

import entities.Student;
import org.apache.log4j.Logger;
import repository.StudentRepository;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadOne extends Thread{

    private Queue<Student> studentQueue;
    private Student student;
    public ThreadOne(Student student){
        studentQueue = new LinkedList<>();
        this.student = student;
    }
    @Override
    public void run(){
        StudentRepository repository = new StudentRepository();
        studentQueue.add(student);
        repository.insertStudent(studentQueue.poll());
    }
}
