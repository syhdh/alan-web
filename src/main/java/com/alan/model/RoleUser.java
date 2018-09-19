package com.alan.model;

import java.io.Serializable;

/**
 * role_user
 * @author 
 */
public class RoleUser implements Serializable {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 住址
     */
    private String address;

    /**
     * 家乡编号
     */
    private String area;

    /**
     * 星级
     */
    private Integer importanc;

    /**
     * 自评
     */
    private String introduce;

    /**
     * 登录时间
     */
    private String loginTime;

    /**
     * 离线时间
     */
    private String loginOut;

    /**
     * 登录次数
     */
    private Integer loginTimes;

    /**
     * 登录名
     */
    private String loginName;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getImportanc() {
        return importanc;
    }

    public void setImportanc(Integer importanc) {
        this.importanc = importanc;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginOut() {
        return loginOut;
    }

    public void setLoginOut(String loginOut) {
        this.loginOut = loginOut;
    }

    public Integer getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RoleUser other = (RoleUser) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getImportanc() == null ? other.getImportanc() == null : this.getImportanc().equals(other.getImportanc()))
            && (this.getIntroduce() == null ? other.getIntroduce() == null : this.getIntroduce().equals(other.getIntroduce()))
            && (this.getLoginTime() == null ? other.getLoginTime() == null : this.getLoginTime().equals(other.getLoginTime()))
            && (this.getLoginOut() == null ? other.getLoginOut() == null : this.getLoginOut().equals(other.getLoginOut()))
            && (this.getLoginTimes() == null ? other.getLoginTimes() == null : this.getLoginTimes().equals(other.getLoginTimes()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getImportanc() == null) ? 0 : getImportanc().hashCode());
        result = prime * result + ((getIntroduce() == null) ? 0 : getIntroduce().hashCode());
        result = prime * result + ((getLoginTime() == null) ? 0 : getLoginTime().hashCode());
        result = prime * result + ((getLoginOut() == null) ? 0 : getLoginOut().hashCode());
        result = prime * result + ((getLoginTimes() == null) ? 0 : getLoginTimes().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", age=").append(age);
        sb.append(", sex=").append(sex);
        sb.append(", address=").append(address);
        sb.append(", area=").append(area);
        sb.append(", importanc=").append(importanc);
        sb.append(", introduce=").append(introduce);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", loginOut=").append(loginOut);
        sb.append(", loginTimes=").append(loginTimes);
        sb.append(", loginName=").append(loginName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}