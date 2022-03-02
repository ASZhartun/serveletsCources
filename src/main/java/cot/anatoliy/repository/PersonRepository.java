package cot.anatoliy.repository;

import cot.anatoliy.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    Optional<List<Person>> findByName(String name);

    Optional<List<Person>> findByNameOrAge(String name, int age);

    Optional<List<Person>> findByNameOrAgeBetween(String name, int ageFrom, int ageTo);

    @Query(value = "SELECT * FROM PERSON where name=?1 or age=?2", nativeQuery = true)
    Optional<List<Person>> myCustomQuery(String name, int age);




}
