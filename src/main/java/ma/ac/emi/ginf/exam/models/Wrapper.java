package ma.ac.emi.ginf.exam.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wrapper {
    String mail;
    UserType role;
    Long id;
    String username;

    public Wrapper(User u) {
        this.id = u.getId();
        this.mail = u.getMail();
        this.role = u.getRole();
        this.username = u.getUsername();
    }
}
