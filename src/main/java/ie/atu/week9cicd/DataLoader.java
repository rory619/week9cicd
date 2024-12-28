package ie.atu.week9cicd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final PersonRepository personRepository;

    @Autowired
    public DataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Person person1 = new Person("Paul", 23, "paul@atu.ie", "Mr", "12345", "Lecturer", "Electronics");
        Person person2 = new Person("Rory", 26, "rory@atu.ie", "Mr", "12344", "Student", "Electronics");
        Person person3 = new Person("James", 21, "james@atu.ie", "Mr", "12343", "Janitor", "Electronics");

        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
    }
}