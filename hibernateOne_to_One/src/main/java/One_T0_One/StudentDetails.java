package One_T0_One;

import javax.persistence.*;

@Entity
@Table(name="student_details")
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "details_id")
    private int detailsId;
    @Column(name = "address")
    private String maddress;
    @Column(name="stream")
    private String mstream;
    @Column(name="percentage")
    private double mpercentage;

    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    public String getMaddress() {
        return maddress;
    }

    public void setMaddress(String maddress) {
        this.maddress = maddress;
    }

    public String getMstream() {
        return mstream;
    }

    public void setMstream(String mstream) {
        this.mstream = mstream;
    }

    public double getMpercentage() {
        return mpercentage;
    }

    public void setMpercentage(double mpercentage) {
        this.mpercentage = mpercentage;
    }
}
