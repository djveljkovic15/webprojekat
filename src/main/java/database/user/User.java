package database.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Id
    private Long id;
    @Version
    private Integer version;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    @Enumerated
    private PrivilegeLevel privilegeLevel;
    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    private String password;

    public void setPassword(String password){
        if (!isPasswordValid(password))
            throw new IllegalArgumentException("Password is invalid");
        this.password=password;
    }
    private boolean isPasswordValid(String plainText){
        return plainText!= null &&
                plainText.length()>= 3 &&
                plainText.length()<= 12;
    }
}
