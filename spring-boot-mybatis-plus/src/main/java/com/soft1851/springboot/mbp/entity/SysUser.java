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
@TableName("sys_user")
@Builder
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId("user_id")
    private Integer userId;

    /**
     * 用户账号
     */
    @TableField("user_account")
    private String userAccount;

    /**
     * 用户密码
     */
    @TableField("user_password")
    private String userPassword;

    /**
     * 用户身份
     */
    @TableField("user_identify")
    private String userIdentify;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
