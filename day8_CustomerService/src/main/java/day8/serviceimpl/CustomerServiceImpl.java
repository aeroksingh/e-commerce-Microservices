package day8.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day8.controller.globalexception.ResourceNotFoundException;
import day8.entity.Customer;
import day8.repository.CustomerRepository;
import day8.service.CustomerService;

@Service
public class CustomerServiceImpl
        implements CustomerService {

    @Autowired
    CustomerRepository repo;

    @Override
    public Customer addCustomer(Customer customer) {

        return repo.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {

        return repo.findAll();
    }

    @Override
    public Customer getCustomerById(int customerId) {

        return repo.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Customer Not Found With ID : " + customerId
                        ));
    }
    @Override
    public Customer updateCustomer(
            int id,
            Customer customer) {

        Customer oldCustomer =
                repo.findById(id).orElse(null);

        if(oldCustomer != null) {

            oldCustomer.setCustomerName(
                    customer.getCustomerName());

            oldCustomer.setCustomerEmail(
                    customer.getCustomerEmail());

            oldCustomer.setCustomerCity(
                    customer.getCustomerCity());

            return repo.save(oldCustomer);
        }

        return null;
    }

    @Override
    public String deleteCustomer(int id) {

        repo.deleteById(id);

        return "Customer Deleted Successfully";
    }
}