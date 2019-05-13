package com.example.springboot.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String lastname;

    @Column
    private String firstname;
    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<UserCase> usercase;

    public Boolean addCase (UserCase userCase){
        try{
        userCase.setUser(this);
        this.usercase.add(userCase);
        return true;}
        catch (Exception e){
            return false;
        }
    };

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
