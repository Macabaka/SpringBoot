package com.soft1851.springboot.mbp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Johnny
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_permission")
@Builder
public class SysPermission extends Model<SysPermission> {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    @TableId("p_id")
    private Integer pId;

    /**
     * 权限父级id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 权限名称
     */
    @TableField("p_name")
    private String pName;

    /**
     * 权限类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 权限路径
     */
    @TableField("path")
    private String path;


    @Override
    protected Serializable pkVal() {
        return this.pId;
    }

}
