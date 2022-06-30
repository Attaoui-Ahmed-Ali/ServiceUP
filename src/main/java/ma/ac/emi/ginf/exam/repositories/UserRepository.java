package ma.ac.emi.ginf.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.ac.emi.ginf.exam.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByMailAndPassword(String mail, String password);

}
