package One_T0_One;

import javax.persistence.*;

@Entity
@Table(name="student_document")
public class StudentDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private  int did;
    @Column(name = "pan_no")
    private String dpan;
    @Column(name = "passport_no")
    private String dpassport;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDpan() {
        return dpan;
    }

    public void setDpan(String dpan) {
        this.dpan = dpan;
    }

    public String getDpassport() {
        return dpassport;
    }

    public void setDpassport(String dpassport) {
        this.dpassport = dpassport;
    }
}
