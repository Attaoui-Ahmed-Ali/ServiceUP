package ma.ac.emi.ginf.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.ac.emi.ginf.exam.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("SELECT u FROM User u WHERE u.mail = :mail and u.mdp = :mdp")
	User findUser(@Param("mail") String mail, @Param("mdp") String mdp);
}
