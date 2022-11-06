
package co.poli.edu.proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.poli.edu.proyecto.Model.*;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	//Spring Data Derived findBy Query Methods
	//Retrieve all records from the database based on the UserName
	//https://www.websparrow.org/spring/spring-data-derived-findby-query-methods-example
	User findByUserName(String userName);
}
