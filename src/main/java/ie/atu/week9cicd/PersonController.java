package ie.atu.week9cicd;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/person")
@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getPerson(@PathVariable String employeeId) {
        if (employeeId.length() > 5 || employeeId.isBlank()) {
            return ResponseEntity.badRequest().body("EmployeeId is invalid");
        }

        Person person = personService.getPersonByEmployeeId(employeeId);

        if (person == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(person);
    }

    @PostMapping("/createPerson")
    public ResponseEntity<String> create(@Valid @RequestBody Person person) {
        personService.savePerson(person);
        return new ResponseEntity<>("Person created successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return new ResponseEntity<>("Person deleted successfully", HttpStatus.OK);
    }
    @PutMapping("/{email}")
    public ResponseEntity<String> updatePerson(@PathVariable String email, @RequestBody Person updatedPerson) {
        personService.updatePerson(email, updatedPerson);
        return new ResponseEntity<>("Person updated successfully", HttpStatus.OK);
    }
}