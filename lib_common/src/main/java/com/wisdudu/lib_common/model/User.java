package com.wisdudu.lib_common.model;

/**
 * 文件描述：
 * <p>
 * 作者：   Created by sven on 2017/9/26.
 */

public class User {


    /**
     * uid : 1261
     * nickname : 姚志鹏
     * username : 18502345807
     * qq :
     * sex : 1
     * age : 107
     * faces : http://wisdudu.oss-cn-shenzhen.aliyuncs.com/kt_o_5.jpg
     */

    private String uid;
    private String nickname;
    private String username;
    private String qq;
    private int sex;
    private int age;
    private String faces;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFaces() {
        return faces;
    }

    public void setFaces(String faces) {
        this.faces = faces;
    }
}
