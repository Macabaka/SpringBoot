package com.soft1851.springboot.oauth.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Johnny
 * @Date: 2020/4/29 11:07
 * @Description:
 */
@RestController
public class TestController {
    @RequestMapping("index")
    public  String simpleIndex(ModelMap map){
        return "index";
    }

}
