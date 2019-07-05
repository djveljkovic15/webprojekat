package database.shop;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shop")
@Data
@NoArgsConstructor
public class Shop implements Serializable {

    @Id
    @Column(name = "shop_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

}