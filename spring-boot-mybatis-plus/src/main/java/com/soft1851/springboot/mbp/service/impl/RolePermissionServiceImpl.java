package com.soft1851.springboot.mbp.service.impl;

import com.soft1851.springboot.mbp.entity.RolePermission;
import com.soft1851.springboot.mbp.entity.SysPermission;
import com.soft1851.springboot.mbp.mapper.RolePermissionMapper;
import com.soft1851.springboot.mbp.service.RolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Johnny
 * @since 2020-04-16
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {
    @Resource
    private  RolePermissionMapper rolePermissionMapper;

    @Override
    public List<SysPermission> getRoleById(int id) {
        return rolePermissionMapper.getRoleById(id);
    }

}
