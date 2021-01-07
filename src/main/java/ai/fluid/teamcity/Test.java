package ai.fluid.teamcity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Access(AccessType.FIELD)
public class Test {
	
	
	@Id
	private long id;
	
	private int age;

}
