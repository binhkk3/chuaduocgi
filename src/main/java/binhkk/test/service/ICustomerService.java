package binhkk.test.service;

import binhkk.test.model.Customer;
import binhkk.test.repository.ICustomerRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerService extends IGenaralService<Customer> {
}
