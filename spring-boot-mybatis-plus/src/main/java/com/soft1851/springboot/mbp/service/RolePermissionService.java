package com.soft1851.springboot.mbp.service;

import com.soft1851.springboot.mbp.entity.RolePermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft1851.springboot.mbp.entity.SysPermission;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Johnny
 * @since 2020-04-16
 */
public interface RolePermissionService extends IService<RolePermission> {
    List<SysPermission> getRoleById(int id);
}
