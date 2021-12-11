import com.fy.entity.Student;
import com.fy.service.StudentService;
import com.fy.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.util.List;

public class MyTest {

    StudentService studentService = new StudentServiceImpl();

    @Test
    public void addStudent() {
        Student student = new Student();
        student.setId("20191308010");
        student.setName("冯也");
        student.setMajor("软件");
        student.setPhone("123456");

        int number = studentService.addStudent(student);
        System.out.println(number);
    }

    @Test
    public void findAllStudent() {
        List<Student> List = studentService.findAll();
        for (Student student : List) {
            System.out.println(student);
        }
    }

    @Test
    public void deleteStudent() {

        int num = studentService.deleteStudent("20191308020");
        System.out.println(num);
    }

    @Test
    public void findById() {
        Student student = studentService.findStudentById("20191308020");
        System.out.println(student);
    }

    @Test
    public void updateStudent() {
        Student student = new Student();
        student.setId("20191308020");
        student.setName("冯也");
        student.setMajor("软件");
        student.setPhone("1234567");

        int number = studentService.updateStudent(student);
        System.out.println(number);
    }

}
