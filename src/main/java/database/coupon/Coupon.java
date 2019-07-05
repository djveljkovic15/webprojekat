package database.coupon;

import database.shop.Shop;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name = "coupon")
public class Coupon implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    @Id
    private Long id;
    @Version
    @Column(name = "version")
    private Integer version;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "shop")
    private Shop shop;
    @NotNull
    @Column(unique = true)
    private String productName;
    @NotNull
    private Float newPrice;
    @NotNull
    private Float oldPrice;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date validFrom;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date validTo;

    public String getValidFrom() {
        return new SimpleDateFormat("yyyy-dd-MM").format(validFrom);
    }

    public void setValidFrom(String validFrom) {
        try {
            this.validFrom = new SimpleDateFormat("yyyy-dd-MM").parse(validFrom);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getValidTo() {
        return new SimpleDateFormat("yyyy-dd-MM").format(validTo);
    }

    public void setValidTo(String validTo) {
        try {
            this.validTo = new SimpleDateFormat("yyyy-dd-MM").parse(validTo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
