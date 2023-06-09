package nestorcicardini.D10.devices;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nestorcicardini.D10.devices.payloads.RegisterDevicePayload;

@RestController
@RequestMapping("/devices")
public class DeviceController {
	@Autowired
	DeviceService deviceService;

	// CRUD:

	// 1. CREATE (POST METHOD) - http://localhost:3001/devices
	@PostMapping("")
	public Device saveUser(@RequestBody @Validated RegisterDevicePayload body) {
		return deviceService.createDevice(body);
	}

	// 2. READ (GET METHOD) - http://localhost:3001/devices
	@GetMapping("")
	public List<Device> getAllDeces() {
		return deviceService.getAll();
	}

	// 3. READ (GET METHOD) - http://localhost:3001/devices/:deviceId
	@GetMapping("/{deviceId}")
	public Device getSpecificUserById(@PathVariable String deviceId) {
		return deviceService.getDeviceById(UUID.fromString(deviceId));

	}

	// 4. UPDATE (PUT METHOD) - http://localhost:3001/devices/:deviceId + body
	@PutMapping("/{deviceId}")
	public Device updateUser(@PathVariable UUID deviceId,
			@RequestBody Device body) throws Exception {
		return deviceService.findByIdAndUpdate(deviceId, body);
	}

	// 5. DELETE (DELETE METHOD) - http://localhost:3001/devices/:deviceId
	@DeleteMapping("/{deviceId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable UUID deviceId) {
		deviceService.findByIdAndDelete(deviceId);
	}
}
