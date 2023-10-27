package com.workrideshare.controller;

import com.workrideshare.model.Address;
import com.workrideshare.model.Commuter;
import com.workrideshare.repository.AddressRepository;
import com.workrideshare.repository.CommuterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired(required=true)
	private AddressRepository advertRepository;

	@Autowired
	private CommuterRepository commuterRepository;

	@RequestMapping(value = "/api/commuter/new",
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<String> createCommuter(@RequestBody Map<String, String> payload) {
		Address homeAddress = new Address();
		homeAddress.setCity(payload.get("home_address_city"));
		homeAddress.setStreetAddress(payload.get("home_address"));
		homeAddress.setLatitude(payload.get("home_address_lat"));
		homeAddress.setLongitude(payload.get("home_address_long"));
		homeAddress.setState(payload.get("home_address_state"));
		homeAddress.setCountry(payload.get("home_address_country"));

		Address workAddress = new Address();
		workAddress.setStreetAddress(payload.get("work_address"));
		workAddress.setCity(payload.get("work_city"));
		workAddress.setLatitude(payload.get("work_address_lat"));
		workAddress.setLongitude(payload.get("work_address_long"));
		workAddress.setState(payload.get("home_address_state"));
		workAddress.setCountry(payload.get("home_address_country"));

		advertRepository.save(homeAddress);
		advertRepository.save(workAddress);
		createCommuter(payload.get("name"),payload.get("email") , payload.get("phone"), "active",  homeAddress,  workAddress);
		String responseMessage = "Commuter Created Successfully";
		String jsonResponse = "{\"message\": \"" + responseMessage + "\"}";

		return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);

	}

	public void createCommuter(String name, String email, String phoneNumber, String status, Address homeAddress, Address workAddress) {
		Commuter commuter = new Commuter();
		commuter.setName(name);
		commuter.setEmail(email);
		commuter.setPhoneNumber(phoneNumber);
		commuter.setStatus(status);
		commuter.setHomeAddress(homeAddress);
		commuter.setWorkAddress(workAddress);
		commuter.setCreated(new Date());
		commuterRepository.save(commuter);
	}
}
