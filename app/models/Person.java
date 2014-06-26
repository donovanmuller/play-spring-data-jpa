package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This declares a model object for persistence usage. Model objects are generally anaemic structures that represent
 * the database entity. Behaviour associated with instances of a model class are also captured, but behaviours
 * associated with collections of these model objects belong to the PersonRepository e.g. findOne, findAll etc.
 * Play Java will synthesise getter and setter methods for us and therefore keep JPA happy (JPA expects them).
 */
@Entity
public class Person {
    @Id
    @GeneratedValue
    public Long id;

    public String firstname;

    public String surname;

    @OneToMany(mappedBy = "person", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    public List<Child> children = new ArrayList<>();
}
