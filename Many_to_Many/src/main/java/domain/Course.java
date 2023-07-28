package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "coursedata")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name="course_name")
    private String courseName;



    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="studentcourse",
            joinColumns = @JoinColumn(name="course_ref"),
            inverseJoinColumns = @JoinColumn(name="student_ref")
    )
    private List<Student> studentList;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }



    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public  void  addStudent(Student student)
    {
        if(studentList==null)
        {
            studentList=new LinkedList<>();//upcasting because
        }
        studentList.add(student);

    }
}
