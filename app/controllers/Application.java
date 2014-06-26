package controllers;

import models.Child;
import models.Person;
import models.PersonRepository;
import org.springframework.transaction.annotation.Transactional;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * The main set of web services.
 */
@Named
@Singleton
public class Application extends Controller {

    private final PersonRepository personRepository;

    // We are using constructor injection to receive a repository to support our desire for immutability.
    @Inject
    public Application(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional // <-- Let Spring manage our transaction boundaries. See @EnableTransactionManagement on SpringDataJpaConfiguration. You could add this annotation at class level as well, which means all controller actions will either participate in or start new transactions.
    public Result index() {

        final Person person = new Person();
        person.firstname = "Bruce";
        person.surname = "Smith";

        final Child child = new Child();
        child.person = person;
        person.children.add(child);

        // Here the children collection for the savedPerson works, because we just added it before.
        final Person savedPerson = personRepository.save(person);

        // For retrievedPerson the children collection is not initialized because of a LIE.
        final Person retrievedPerson = personRepository.findOne(savedPerson.id);
        Logger.info("Got person, no LIE's: {} {}", retrievedPerson.firstname, retrievedPerson.surname);

        return ok(views.html.index.render("Found id: " + retrievedPerson.id + " of person/people with " + retrievedPerson.children.size() + " children"));
    }
}
