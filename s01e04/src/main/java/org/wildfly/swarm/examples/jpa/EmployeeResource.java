package org.wildfly.swarm.examples.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.querydsl.jpa.impl.JPAQuery;

/**
 * @author Ken Finnigan
 */
@Path("/")
@ApplicationScoped
public class EmployeeResource {

	@PersistenceContext
	EntityManager em;

	@GET
	@Produces("application/json")
	public Employee[] get() {
		return new JPAQuery<Employee>(em).from(QEmployee.employee).fetch().toArray(new Employee[0]);
	}
}
