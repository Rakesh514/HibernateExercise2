import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue
	private int veh_id;
	private String model;
	private int regNumber;
	
	@ManyToMany(mappedBy="vehicles")
	private Set<User> users = new HashSet();
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(int regNumber) {
		this.regNumber = regNumber;
	}

	public int getVeh_id() {
		return veh_id;
	}

	public void setVeh_id(int veh_id) {
		this.veh_id = veh_id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
