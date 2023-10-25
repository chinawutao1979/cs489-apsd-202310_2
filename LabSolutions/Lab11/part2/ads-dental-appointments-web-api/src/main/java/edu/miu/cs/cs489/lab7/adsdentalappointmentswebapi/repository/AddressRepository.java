package edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.repository;

import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
