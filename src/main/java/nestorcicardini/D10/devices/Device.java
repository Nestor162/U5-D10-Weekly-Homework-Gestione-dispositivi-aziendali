package nestorcicardini.D10.devices;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import nestorcicardini.D10.users.User;

@Entity
@Table(name = "devices")
@Data
@NoArgsConstructor
public class Device {
	@Id
	@GeneratedValue
	private UUID id;
	@Enumerated(EnumType.STRING)
	private DeviceType deviceType;
	@Enumerated(EnumType.STRING)
	private DeviceStatus deviceStatus;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public enum DeviceType {
		smartphone, tablet, laptop
	}

	public enum DeviceStatus {
		available, assigned, maintenance, disposed
	}

	public Device(DeviceType deviceType, DeviceStatus deviceStatus) {
		super();
		this.deviceType = deviceType;
		this.deviceStatus = deviceStatus;
	}

}
