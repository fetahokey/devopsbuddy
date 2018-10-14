package com.devopsbuddy.backend.persistence.repositories;

import com.devopsbuddy.backend.persistence.domain.backend.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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
*       TO 10/13/2018 01:10
*/

@Repository
public interface PlanRepository extends CrudRepository<Plan,Integer>{
}
