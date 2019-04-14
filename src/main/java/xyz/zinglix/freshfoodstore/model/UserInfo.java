package xyz.zinglix.freshfoodstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo {
    @Id
    Long id;
    String email;
    String realname;
    String nickname;
    String phone;
    String address;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public UserInfo(Long id, String nickname, String phone, String address) {
        this.id = id;
        this.nickname = nickname;
        this.phone = phone;
        this.address = address;
    }

    public UserInfo() {
        nickname="";
        phone="";
        address="";
    }
    public UserInfo(Long id) {
        this.id=id;
        nickname="";
        phone="";
        address="";
    }
}
