package domian;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="custid")
    private  int customerId;
    @Column(name="custname")
    private  String customerName;

    @Column(name="custcontact")
    private  int customerContact;

    @OneToMany(mappedBy = "customerRef" ,cascade = CascadeType.ALL)
    private List<Orders> orderList; //List interface data store using linked list ,get data by using Arraylist


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(int customerContact) {
        this.customerContact = customerContact;
    }

    public List<Orders> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Orders> orderList) {
        this.orderList = orderList;
    }

    //helper Method

    public  void  placeOrder(Orders order)
    {
        if(orderList==null)
        {
            orderList=new LinkedList<>();//upcasting because
        }
        orderList.add(order);
        order.setCustomerRef(this);
    }


}
