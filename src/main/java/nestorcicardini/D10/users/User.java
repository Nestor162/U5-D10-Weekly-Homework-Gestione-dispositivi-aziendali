package nestorcicardini.D10.users;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import nestorcicardini.D10.devices.Device;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private UUID id;
	private String username;
	private String name;
	private String surname;
	private String email;
	private String password;

	@OneToMany(mappedBy = "user")
	private List<Device> devices;

	public User(String username, String name, String surname, String email,
			String password) {
		super();
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}

}
