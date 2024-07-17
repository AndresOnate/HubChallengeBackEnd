package com.alura.challenge.ForoHub.model;


import com.alura.challenge.ForoHub.controller.user.UserDto;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.BCrypt;
import java.util.*;


@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String lastName;
    
    String email;

    String passwordHash;

    List<RoleEnum> roles;

    Date createdAt;

    

    public User(String name, String lastName, String email, String passwordHash) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public User(Long id, String name, String lastName, String email, String passwordHash) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public User()
    {
    }


    public User( UserDto userDto )
    {
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        createdAt = new Date();
        roles = new ArrayList<>( Collections.singleton( RoleEnum.USER ) );
        passwordHash = BCrypt.hashpw( userDto.getPassword(), BCrypt.gensalt() );
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public List<RoleEnum> getRoles()
    {
        return roles;
    }

    public void update( UserDto userDto )
    {
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        if ( userDto.getPassword() != null )
        {
            this.passwordHash = BCrypt.hashpw( userDto.getPassword(), BCrypt.gensalt() );
        }
    }



}
