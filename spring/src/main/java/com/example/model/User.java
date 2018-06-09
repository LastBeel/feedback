package com.example.model;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import static java.util.Objects.requireNonNull;

@Entity
@Table(name = "user")
public class User implements UserDetails {
  //  private static final long serialVersionUID = 2396654715019746670L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "username")
    private String username;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "password")
    private String password;

    public User(@JsonProperty("id") final Integer id,
         @JsonProperty("username") final String username,
         @JsonProperty("password") final String password) {
        super();
        this.id = requireNonNull(id);
        this.username = requireNonNull(username);
        this.password = requireNonNull(password);
    }

    public User(){}


    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
