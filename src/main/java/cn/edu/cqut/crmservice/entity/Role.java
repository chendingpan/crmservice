package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */

    private String roleName;

    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;
    /**
     * 角色描述
     */
    private String roleDescribe;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Role{" +
        "roleName = " + roleName +
        ", roleDescribe = " + roleDescribe +
        "}";
    }
}
