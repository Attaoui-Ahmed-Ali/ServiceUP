package ma.ac.emi.ginf.exam.Controller;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ac.emi.ginf.exam.models.Login;
import ma.ac.emi.ginf.exam.models.UserType;
import ma.ac.emi.ginf.exam.models.Wrapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.emi.ginf.exam.models.User;
import ma.ac.emi.ginf.exam.repositories.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository ur;

    @PostMapping(value = "/")
    public ResponseEntity<Wrapper> login(@RequestBody Login user) {

        System.out.println("*********************");
        System.out.println(user);
        System.out.println("*********************");

        User u = ur.findByMailAndPassword(user.getMail(), DigestUtils.sha256Hex(user.getPassword()));

        if (u != null) {
            return ResponseEntity.ok().body(new Wrapper(u));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}



