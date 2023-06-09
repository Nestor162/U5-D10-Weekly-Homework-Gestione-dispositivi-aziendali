package nestorcicardini.D10.devices;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "devices")
public class Device {
	@Id
	@GeneratedValue
	private UUID id;

}
