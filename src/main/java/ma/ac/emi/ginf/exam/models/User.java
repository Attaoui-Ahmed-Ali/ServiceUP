package ma.ac.emi.ginf.exam.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "mail", unique = true)
    private String mail;


    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserType role;


    public User(String mail, String username, String password, UserType role) {
        super();

        this.mail = (mail);
        this.username = (username);
        this.password = (DigestUtils.sha256Hex(password));
        this.role = (role);

        System.out.println("***********************************");
        System.out.println("mail :" + this.mail);
        System.out.println("us :" + this.username);
        System.out.println("password :" + this.password);
//		System.out.println("password secure :" +DigestUtils.sha256Hex(password));
        System.out.println("role :" + this.role);
        System.out.println("***********************************");
    }

    public User() {

    }


    @Override
    public String toString() {
        return this.id + " User : " + this.username + " " + this.password + " " + this.role;
    }

}
