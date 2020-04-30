package com.soft1851.springboot.jwt.service;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jack
 * @Date: 2020/4/15 16:47
 * @Description:
 */
@Service
public class AdminService {

    public List<String> getPermissionsByRole(String role) {
        Map<String, List<String>> map = new TreeMap<>();
        String[] admins = {"专辑管理", "歌曲管理"};
        String[] superAdmins = {"权限设置", "系统设置"};
        map.put("admin", Arrays.asList(admins));
        map.put("superAdmin", Arrays.asList(superAdmins));
        return map.get(role);
    }

    public boolean checkRole(String role) {
        if ("admin".equals(role) || ("superAdmin".equals(role))) {
            return true;
        }else{
            return false;
        }
    }

}
