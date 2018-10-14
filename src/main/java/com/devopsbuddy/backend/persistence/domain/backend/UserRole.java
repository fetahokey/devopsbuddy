package com.devopsbuddy.backend.persistence.domain.backend;

import javax.persistence.*;
import java.io.Serializable;
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
*       TO 10/12/2018 21:39
*/
@Entity
@Table(name="user_role")
public class UserRole implements Serializable{
    /** The serial version UID for serializable classes. */
        private static final long serialVersionUID= 1L;

    /**Default constructor*/
    public UserRole(){

    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (user != null ? !user.equals(userRole.user) : userRole.user != null) return false;
        return role != null ? role.equals(userRole.role) : userRole.role == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
