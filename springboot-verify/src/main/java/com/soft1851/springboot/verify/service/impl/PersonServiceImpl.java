package com.soft1851.springboot.verify.service.impl;

import com.soft1851.springboot.verify.entity.Person;
import com.soft1851.springboot.verify.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * @author Johnny
 * @Date: 2020/4/30 17:30
 * @Description:
 */

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public ResponseEntity<Person> savePerson( Person person) {
        return ResponseEntity.ok().body(person);
    }

    @Override
    public ResponseEntity<Integer> getPersonById( String id) {
        return ResponseEntity.ok().body(Integer.parseInt(id));
    }

    @Override
    public ResponseEntity<String> getPersonByName(String name) {
        return ResponseEntity.ok().body(name);
    }
}
