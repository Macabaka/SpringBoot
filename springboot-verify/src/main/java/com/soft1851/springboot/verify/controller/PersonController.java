package com.soft1851.springboot.verify.controller;

import com.soft1851.springboot.verify.entity.Person;
import com.soft1851.springboot.verify.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * @author Johnny
 * @Date: 2020/4/30 16:37
 * @Description:
 */
@RestController
@RequestMapping("/api")
@Validated
@Slf4j
public class PersonController {

    @Resource
    private PersonService personService;

    @PostMapping("person")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping(".person/{id}")
    public ResponseEntity<Integer> getPersonById( @PathVariable("id") String id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/person")
    public ResponseEntity<String> getPersonByName( @RequestParam("name") String name) {
        return personService.getPersonByName(name);
    }

}
