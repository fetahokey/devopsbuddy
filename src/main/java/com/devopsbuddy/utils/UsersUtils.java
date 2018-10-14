package com.devopsbuddy.utils;

import com.devopsbuddy.backend.persistence.domain.backend.User;
/**
* <h1>devopsbuddy!</h1>
* The devopsbuddy implements an application that
* simply displays "Hello World!" to the standard output.
* <p>
* Giving proper comments in your program makes it more
* user friendly and it is assumed as a high quality code.
*
*
* @author  OULD KRADDA FATEH
* @version 1.0.0
* @since   2018-10-10
*       TO 10/14/2018 11:23
*/
public class UsersUtils {
    /**
     * Non instantiable
     * */
    private UsersUtils(){
        throw new AssertionError("non instantiable");
    }

    /**
     * Creates a user with a basic attributes set.
     * @return A user entity
     * */
    public static User createBasicUser(){
        User user = new User();
        user.setUsername("BasicUser");
        user.setPassword("password");
        user.setEmail("basiUser@email.com");
        user.setFirstName("Fateh");
        user.setLastName("Oulka");
        user.setPhoneNumber("+213555245588");
        user.setCountry("Algeria");
        user.setEnabled(true);
        user.setDescription("This user is for test purpose !");
        user.setProfileImgeUrl("https://www.blabla.images.com/basicuser");
        return  user;
    }
}
