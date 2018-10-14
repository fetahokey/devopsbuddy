package com.devopsbuddy.test;

import com.devopsbuddy.backend.persistence.domain.backend.Plan;
import com.devopsbuddy.backend.persistence.domain.backend.Role;
import com.devopsbuddy.backend.persistence.domain.backend.User;
import com.devopsbuddy.backend.persistence.domain.backend.UserRole;
import com.devopsbuddy.backend.persistence.repositories.PlanRepository;
import com.devopsbuddy.backend.persistence.repositories.RoleRepository;
import com.devopsbuddy.backend.persistence.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
*       TO 10/13/2018 01:12 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RepositoryIntegrationTest {

    @Autowired
    private  PlanRepository planRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    private static final int BASIC_PLAN_ID=1;
    private static final int BASIC_ROLE_ID=1;
    @Before
    public void init(){
        Assert.assertNotNull(planRepository);
        Assert.assertNotNull(roleRepository);
        Assert.assertNotNull(userRepository);
    }

    @Test
    public void testCreateNewPlan() throws Exception{
        Plan basicPlan = createBasicPlan();
        planRepository.save(basicPlan);
        Optional<Plan> retrievedPlan = planRepository.findById(BASIC_PLAN_ID);
        Assert.assertNotNull(retrievedPlan);
    }
    @Test
    public void testCreateNewRole(){
        Role basicRole = createBasicRole();
        roleRepository.save(basicRole);
        Optional<Role> retrievedRole = roleRepository.findById(BASIC_ROLE_ID);
        Assert.assertNotNull(retrievedRole);
    }

    @Test
    public void testCreateNewUser(){
        Plan basicPlan = createBasicPlan();
        planRepository.save(basicPlan);

        User basicUser = createBasicUser();
        basicUser.setPlan(basicPlan);

        Role basicRole = createBasicRole();
        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setRole(basicRole);
        userRole.setUser(basicUser);

        userRoles.add(userRole);

        basicUser.getUserRoles().addAll(userRoles);

        for (UserRole ur: userRoles){
            roleRepository.save(ur.getRole());
        }
        basicUser = userRepository.save(basicUser);
        Optional<User> newlyCreatedUser = userRepository.findById(basicUser.getId());
//        User newlyCreatedUser = userRepository.findbyId(basicUser.getId()); // from the UserRepository interface
        newlyCreatedUser.ifPresent( user -> {
            Assert.assertNotNull(user);
            Assert.assertTrue(user.getId()!=0);
            Assert.assertNotNull(user.getPlan());
            Assert.assertNotNull(user.getPlan().getId());

            Set<UserRole> userRolesSet = user.getUserRoles();
            for (UserRole ur : userRolesSet){
                Assert.assertNotNull(ur.getRole());
                Assert.assertNotNull(ur.getRole().getId());
            }
        });
    }

    private Plan createBasicPlan(){
        Plan plan = new Plan();
        plan.setId(BASIC_PLAN_ID);
        plan.setName("BASIC");
        return plan;
    }

    private Role createBasicRole(){
        Role role =new Role();
        role.setId(BASIC_ROLE_ID);
        role.setName("ROLE_USER");
        return role;
    }

    private User createBasicUser(){
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
