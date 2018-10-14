package com.devopsbuddy.enums;

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
*       TO 10/14/2018 10:31
 *
 *       define the possible roles
*/
public enum  RolesEnum {
    BASIC(1,"ROLE_BASIC"),
    PRO(2,"ROLE_PRO"),
    ADMIN(3,"ROLE_ADMIN");

    private final int id;
    private final String roleName;

    RolesEnum(int id, String roleName){
        this.id =id;
        this.roleName=roleName;
    }

    public int getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }
}
