package ie.atu.week9cicd;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public Person getPersonByEmployeeId(String employeeId) {
        return personRepository.findByEmployeeId(employeeId);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public ResponseEntity<String> updatePerson(String email, Person updatePerson) {
        Optional<Person> existingPersonOptional = personRepository.findByEmail(email);

        if (existingPersonOptional.isPresent()) {
            Person existingPerson = existingPersonOptional.get();
            existingPerson.setName(updatePerson.getName());
            existingPerson.setAge(updatePerson.getAge());
            existingPerson.setEmail(updatePerson.getEmail());
            existingPerson.setTitle(updatePerson.getTitle());
            existingPerson.setEmployeeId(updatePerson.getEmployeeId());
            existingPerson.setPosition(updatePerson.getPosition());
            existingPerson.setDepartment(updatePerson.getDepartment());

            personRepository.save(existingPerson);
            return new ResponseEntity<>("Person updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
        }
    }
}