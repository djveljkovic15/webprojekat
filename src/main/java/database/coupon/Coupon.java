package database.coupon;

import database.shop.Shop;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
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
    @NotBlank
    @Column(unique = true)
    private String productName;
    @NotNull
    @NotBlank
    private Float newPrice;
    @NotNull
    @NotBlank
    private Float oldPrice;
    @NotNull
    @NotBlank
    private Date validFrom;

    private Date validTo;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Integer getVersion() {
//        return version;
//    }
//
//    public void setVersion(Integer version) {
//        this.version = version;
//    }
//
//    public Shop getShop() {
//        return shop;
//    }
//
//    public void setShop(Shop shop) {
//        this.shop = shop;
//    }
//
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    public Float getNewPrice() {
//        return newPrice;
//    }
//
//    public void setNewPrice(Float newPrice) {
//        this.newPrice = newPrice;
//    }
//
//    public Float getOldPrice() {
//        return oldPrice;
//    }
//
//    public void setOldPrice(Float oldPrice) {
//        this.oldPrice = oldPrice;
//    }
//
//    public Date getValidFrom() {
//        return validFrom;
//    }
//
//    public void setValidFrom(Date validFrom) {
//        this.validFrom = validFrom;
//    }
//
//    public Date getValidTo() {
//        return validTo;
//    }
//
//    public void setValidTo(Date validTo) {
//        this.validTo = validTo;
//    }
}
