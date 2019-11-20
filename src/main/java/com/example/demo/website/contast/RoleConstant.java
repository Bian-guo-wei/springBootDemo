package com.example.demo.website.contast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * 认证常量类
 *
 * @author ayne
 * @date 2018-08-24 10:08:15
 */
public class RoleConstant {

    private static final Logger logger = LoggerFactory.getLogger(RoleConstant.class);

    /**
     * 平台及后台超管，可以管理机构
     */
    public static final int SUPER_ADMIN = 1;


    /**
     * 权限枚举类
     */
    public enum RoleEnum {

        SUPER_ADMIN(RoleConstant.SUPER_ADMIN, "超级管理员", "executive"),;

        private int roleId;
        private String roleName;
        private String abbreviation;

        RoleEnum(int roleId, String roleName, String abbreviation) {
            this.roleId = roleId;
            this.roleName = roleName;
            this.abbreviation = abbreviation;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        public void setAbbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public static RoleEnum getByValue(int value) throws NullPointerException {
            for (RoleEnum roleEnum : values()) {
                if (roleEnum.getRoleId() == value) {
                    return roleEnum;
                }
            }
            throw new NullPointerException("未找到角色id: " + value);
        }

        public static String getRoleNameByValue(int value) throws NullPointerException {
            for (RoleEnum roleEnum : values()) {
                if (roleEnum.getRoleId() == value) {
                    return roleEnum.getRoleName();
                }
            }
            logger.warn("getRoleNameByValue -> 未找到角色id: " + value);
            return "未知角色";
        }

        public static Set<String> getRoleAbbreviationByValue(int value) throws NullPointerException {
            Set<String> set = new HashSet<>();
            for (RoleEnum roleEnum : values()) {
                if (roleEnum.getRoleId() >= value) {
                    set.add(roleEnum.getAbbreviation());
                }
            }
//            logger.warn("getRoleAbbreviationByValue -> 未找到角色id: " + value);
            return set;
        }
    }


}
