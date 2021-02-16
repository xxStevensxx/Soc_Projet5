package com.safety.net.services;

import org.springframework.stereotype.Component;

import com.safety.net.model.Address;
import com.safety.net.model.ListObject;

@Component
public class AddressServices {

	public boolean addAddress(Address address) {

		return ListObject.listAddress.add(address);

	}

}
