package ma.ac.emi.ginf.exam.Controller;

import java.util.Optional;

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
	
	@PostMapping(value = "/", consumes = {"*/*"})
		public ResponseEntity<User> findUserById(@RequestBody User user ) {

		User u = ur.findUser(user.getMail(),user.getMdp());

	    if(u!=null) {
	        return ResponseEntity.ok().body(u);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

}
