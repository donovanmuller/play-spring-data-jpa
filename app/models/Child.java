package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by asu on 26/06/14.
 */
@Entity
public class Child {

    @Id
    @GeneratedValue
    public Long id;

    @ManyToOne
    public Person person;
}
