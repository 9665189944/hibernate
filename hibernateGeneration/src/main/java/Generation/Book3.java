  package Generation;

import javax.persistence.*;

@Entity
@Table(name = "book_info3")
public class Book3 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_gen/erator")
    @SequenceGenerator(name = "book_generator",sequenceName = "book_sequence",initialValue = 101,allocationSize = 1)

    @Column(name = "book_id")
    private int productId;
    @Column(name = "book_name")
    private String productName;
    @Column(name = "book_price")
    private double productPrice;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
