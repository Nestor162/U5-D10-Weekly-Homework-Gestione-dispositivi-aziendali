package nestorcicardini.D10.users;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import nestorcicardini.D10.devices.Device;

@Entity
@Table(name = "users")
@Data
public class User {
	@Id
	@GeneratedValue
	private UUID id;
	private String username;
	private String name;
	private String surname;
	private String email;

	@OneToMany(mappedBy = "user")
	private List<Device> devices;

	public User(String username, String name, String surname, String email) {
		super();
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

}
