package Employee;

import javax.persistence.*;

@Entity
@Table(name="employee_master")
public class Employee_master {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "e_id")
    private int emp_id;

    @Column(name="ename")
    private  String emp_name;

    @Column(name="email")
    private String emp_email;

@OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="pro_id")
    private ProfessionalDetails professional;

@OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="acc_id")
    private AccountDetails account;


    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public ProfessionalDetails getProfessional() {
        return professional;
    }

    public void setProfessional(ProfessionalDetails professional) {
        this.professional = professional;
    }

    public AccountDetails getAccount() {
        return account;
    }

    public void setAccount(AccountDetails account) {
        this.account = account;
    }
}
