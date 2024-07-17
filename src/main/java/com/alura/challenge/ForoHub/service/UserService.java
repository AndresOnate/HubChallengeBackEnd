package com.alura.challenge.ForoHub.service;

import com.alura.challenge.ForoHub.controller.user.UserDto;
import com.alura.challenge.ForoHub.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface UserService
{
    User create(UserDto userDto );

    User findById( Long id );

    User findByEmail( String email );

    List<User> all();

    boolean deleteById( Long id );

    User update(UserDto userDto, Long id);
}