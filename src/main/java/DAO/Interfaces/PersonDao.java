package DAO.Interfaces;

import beans.Person;

import java.util.List;

public interface PersonDao
{
    void add(Person person);

    void delete(int id);

    void update(int id, Person newPerson);

    List<Person> list();

    Person find(int id);

    Person findByEmailNPassword(String email, String password);
}
