package com.nico5310.safetyNetAlerts.service;


import com.nico5310.safetyNetAlerts.model.Person;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceTest {

    List<Person> listPerson;

    @Mock
    PersonServiceInterface personServiceInterface;

    PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService();
    }

    @Test
    @DisplayName("Test")
    public void findPersonAll() {
        //GIVEN
        listPerson = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("nicolas");
        person.setLastName("biancucci");
        person.setAddress("le village");
        person.setCity("thurigneux");
        person.setZip("01390");
        person.setPhone("061111111");
        person.setEmail("nico@gmail.com");
        listPerson.add(person);

        //WHEN
       when(personService.findPersonAll()).thenReturn(listPerson);

        //THEN
        assertThat(personService.findPersonAll().toString(), containsString("nicolas"));
    }




}
