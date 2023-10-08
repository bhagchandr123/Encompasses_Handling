package com.example.Encompasses_Handling.service;

import com.example.Encompasses_Handling.model.Address;
import com.example.Encompasses_Handling.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.orElse(null);
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address updatedAddress) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            Address existingAddress = address.get();
            existingAddress.setLandmark(updatedAddress.getLandmark());
            existingAddress.setZipcode(updatedAddress.getZipcode());
            existingAddress.setDistrict(updatedAddress.getDistrict());
            existingAddress.setState(updatedAddress.getState());
            existingAddress.setCountry(updatedAddress.getCountry());
            // Update other fields as needed
            return addressRepository.save(existingAddress);
        }
        return null;
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
