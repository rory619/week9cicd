package ie.atu.week9cicd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PersonRepository extends JpaRepository <Person, Long> {
    Person findByEmployeeId(String employeeId);

    Optional<Person> findByEmail(String email);
}
