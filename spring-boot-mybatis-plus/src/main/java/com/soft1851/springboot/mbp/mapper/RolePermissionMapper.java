package com.soft1851.springboot.mbp.mapper;

import com.soft1851.springboot.mbp.entity.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1851.springboot.mbp.entity.RoleUser;
import com.soft1851.springboot.mbp.entity.SysPermission;
import com.soft1851.springboot.mbp.entity.SysRole;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Johnny
 * @since 2020-04-16
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
    List<SysPermission> getRoleById(int id);
}
