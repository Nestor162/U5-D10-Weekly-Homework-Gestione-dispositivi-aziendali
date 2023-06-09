package nestorcicardini.D10.devices;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nestorcicardini.D10.devices.Device.DeviceStatus;
import nestorcicardini.D10.devices.Device.DeviceType;
import nestorcicardini.D10.devices.payloads.RegisterDevicePayload;
import nestorcicardini.D10.exceptions.NotFoundException;
import nestorcicardini.D10.users.User;
import nestorcicardini.D10.users.UserRepository;

@Service
public class DeviceService {

	@Autowired
	private DeviceRepository deviceRepo;

	@Autowired
	private UserRepository userRepo;

	public Device createDevice(RegisterDevicePayload payload) {

		Device createdDevice = new Device(
				DeviceType.valueOf(payload.getDeviceType()),
				DeviceStatus.valueOf(payload.getDeviceStatus()));

		// Se al momento della creazione viene specificato l'utente che sarà
		// collegato a quel dispositivo verrà settato l'utente. Altrimenti si
		// lascia il null per eventualmente settarlo in un altro momento
		if (payload.getUserId() != null) {

			User user = userRepo.findById(UUID.fromString(payload.getUserId()))
					.orElseThrow(() -> new NotFoundException("User not found"));

			createdDevice.setUser(user);
		}

		return deviceRepo.save(createdDevice);
	}

	public List<Device> getAll() {
		return deviceRepo.findAll();
	}

	public Device getDeviceById(UUID id) {
		return deviceRepo.findById(id).orElseThrow(
				() -> new NotFoundException("Device not found for id: " + id));
	}

	public Device findByIdAndUpdate(UUID id, Device device)
			throws NotFoundException {
		Device found = this.getDeviceById(id);

		found.setId(id);
		found.setDeviceStatus(device.getDeviceStatus());
		found.setDeviceType(device.getDeviceType());
		found.setDeviceStatus(device.getDeviceStatus());
		found.setUser(device.getUser());
		return deviceRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Device found = this.getDeviceById(id);
		deviceRepo.delete(found);
	}

}
