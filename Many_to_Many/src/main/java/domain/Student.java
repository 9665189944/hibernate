package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "studentdata")
public class Student {

@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "student_id")
    private int studentId;

@Column(name="student_name")
    private String studentName;



    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
@JoinTable(
        name="studentcourse",
        joinColumns = @JoinColumn(name="student_ref"),
        inverseJoinColumns = @JoinColumn(name="course_ref")
)
private List<Course> courseList;
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public  void  addCourse(Course course)
    {
        if(courseList==null)
        {
            courseList=new LinkedList<>();//upcasting because
        }
        courseList.add(course);

    }
}
