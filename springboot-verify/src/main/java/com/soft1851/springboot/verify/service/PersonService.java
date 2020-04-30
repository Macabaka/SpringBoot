package com.soft1851.springboot.verify.service;

import com.soft1851.springboot.verify.entity.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * @author Johnny
 * @Date: 2020/4/30 17:27
 * @Description:
 */
@Validated
public interface PersonService {

    public ResponseEntity<Person> savePerson(@Valid Person person);

    public ResponseEntity<Integer> getPersonById(@Valid @Size(min = 6,message = "id不能小于6位") String id);

    public ResponseEntity<String> getPersonByName( @Valid @Size(max = 10,message = "name长度超出范围") String name);
}
