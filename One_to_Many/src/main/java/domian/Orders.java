package domian;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderid")
    private  int orderId;

    @Column(name ="orderno")
         private String orderNo;

    @Column(name="cart_amt")
    private double orderAmount;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="cust_FK")
    private Customer customerRef;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Customer getCustomerRef() {
        return customerRef;
    }

    public void setCustomerRef(Customer customerRef) {
        this.customerRef = customerRef;
    }
}
