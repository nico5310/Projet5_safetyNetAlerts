package com.nico5310.safetyNetAlerts.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.service.PersonService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PersonController.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    @Autowired
    private PersonService personService;

    @Test
    @DisplayName("Test return status for findPersonAll request")
    public void findPersonAll() throws Exception {
        //GIVEN
        Person person = new Person(); // creat new object Person
        List<Person> listPersons = new ArrayList<Person>(); // create new list of Person
        person.setFirstName("nicolas"); //set firstName to object
        person.setLastName("biancucci"); //set lastName to object
        person.setAddress("4 le village"); //set address to object
        person.setCity("thurigneux"); //set city to object
        person.setZip("01390"); //set zip to object
        person.setPhone("0611111111"); //set phone to object
        person.setEmail("nicolas@gmail.com"); //set email to object
        listPersons.add(person); //set parameters of object to list
        when(personService.findPersonAll()).thenReturn(listPersons); // when the service is called, return new List

        //WHEN
        mockMvc.perform(get("/person")).andExpect(status().isOk());// Execute request with Get"person" and wait for an answer 200 status

        //THEN
        verify(personService, times(1)).findPersonAll(); // verify when service person is called one more times

    }

    @Test
    @DisplayName("Test return status for addPerson request")
    public void addPerson() throws Exception {
        //GIVEN
        Person person = new Person();
        person.setFirstName("nicolas");
        person.setLastName("biancucci");
        person.setAddress("4 le village");
        person.setCity("thurigneux");
        person.setZip("01390");
        person.setPhone("0611111111");
        person.setEmail("nicolas@gmail.com");
        List<Person> listPerson = new ArrayList<Person>();
        listPerson.add(person);
        when(personService.savePersonList(any(Person.class))).thenReturn(listPerson);

        //WHEN
        mockMvc.perform(post("/person").content("{ \"firstName\":\"nicolas\", \"lastName\":\"biancucci\", \"address\":\"4 le village\", \"city\":\"thurigneux\" }").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        //THEN
        verify(personService, times(1)).savePersonList(any(Person.class));
    }

    @Test
    @DisplayName("Test return status for updatePerson request")
    public void updatePerson() throws Exception {
        //GIVEN
        Person person = new Person();
        person.setFirstName("nicolas");
        person.setLastName("biancucci");
        person.setAddress("4 le village");
        person.setCity("thurigneux");
        person.setZip("01390");
        person.setPhone("0611111111");
        person.setEmail("nicolas@gmail.com");
        when(personService.updatePersonList(any(String.class),(any(Person.class)))).thenReturn(person);

        //WHEN
        mockMvc.perform(put("/person/NicolasBiancucci").content("{\"firstName\":\"ZZZZ\"}").contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());

        //THEN
        verify(personService, times(1)).updatePersonList(any(String.class),(any(Person.class)));
    }

    @Test
    @DisplayName("Test return status for deletePersonList request")
    public void deletePersonList() throws Exception {
        //GIVEN

        //WHEN
        mockMvc.perform(delete("/person/JohnBoyd",1)).andExpect(status().isOk());

        //THEN
        verify(personService, times(1)).deletePersonList(any(String.class));
    }

}
