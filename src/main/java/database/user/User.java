package database.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private Long id;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    @Enumerated
    private PrivilegeLevel privilegeLevel;
    @NotNull
    @NotBlank
    @Column(unique = true)
    private String username;
    @NotNull
    @NotBlank
    private String password;
//
//    public String getUsername() {
//        return username;
//    }

    //    public void setPassword(String password) throws Exception {
//        if(password.length() >= 3 && password.length() <= 12)
//            this.password = password;
//        else throw new Exception("Password has to be between 8 and 12 characters!");
//    }

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
