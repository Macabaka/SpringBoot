package com.soft1851.springboot.verify.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soft1851.springboot.verify.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.validation.*;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void savePerson() {
        Person person = new Person();
        person.setId("123456");
        person.setName("soft1851");
        person.setAge(20);
        person.setPhone("11151860919");
        person.setEmail("soft1851@qq.com");
        person.setSex("Man");
        MockHttpServletRequestBuilder requestBuilder = null;
        try {
            requestBuilder = MockMvcRequestBuilders
                    .post("/api/person")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(person));
            mockMvc.perform(requestBuilder)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void getPersonById() {
    }


    @Test
    void checkManually(){
        //通过Validator工厂类获得的Validator实例
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator vaildator = factory.getValidator();
        Person person = new Person();
        person.setId("123");
        person.setSex("Man22");
        person.setEmail("abc");
        //对参数进行校验，得到一组结果
        Set<ConstraintViolation<Person>> violations = vaildator.validate(person);
        for (ConstraintViolation<Person> constraintViolation : violations) {
            System.out.println(constraintViolation.getMessage());
        }
    }
}