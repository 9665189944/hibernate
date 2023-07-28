package One_T0_One;

import javax.persistence.*;

@Entity
@Table(name="student_master")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_Id")
    private int studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name="student_contact")
    private int studentContact;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="details_ref")
    private StudentDetails details;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="document_ref")
    private StudentDocument document;

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

    public int getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(int studentContact) {
        this.studentContact = studentContact;
    }

    public StudentDetails getDetails() {
        return details;
    }

    public void setDetails(StudentDetails details) {
        this.details = details;
    }

    public StudentDocument getDocument() {
        return document;
    }

    public void setDocument(StudentDocument document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return
                studentId +
                 " "+ studentName +  " " +
                + studentContact +
                 " "+ details.getMaddress()+" "+details.getMstream()+" "+details.getMpercentage() +" "
                 + document.getDpan()+" "+document.getDpassport()
                ;
    }
}
