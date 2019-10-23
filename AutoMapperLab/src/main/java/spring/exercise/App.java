package spring.exercise;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import spring.exercise.dataTransferObjects.BasicEmployeeDto;
import spring.exercise.dataTransferObjects.ManagerDto;
import spring.exercise.entities.Address;
import spring.exercise.entities.City;
import spring.exercise.entities.Employee;
import spring.exercise.repositories.AddressRepository;
import spring.exercise.repositories.CityRepository;
import spring.exercise.repositories.EmployeeRepository;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootApplication
@Component
public class App implements CommandLineRunner {
    private EmployeeRepository employeeRepository;
    private CityRepository cityRepository;
    private AddressRepository addressRepository;

    @Autowired
    public App(EmployeeRepository employeeRepository, CityRepository cityRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.cityRepository = cityRepository;
        this.addressRepository = addressRepository;
    }


    //@Override
    public void run(String... args) {
        advancedMapping();
    }

    private void seedData() throws ParseException {
        var city = new City();
        city.setName("New York");
        cityRepository.saveAndFlush(city);

        var address1 = new Address();
        address1.setCity(city);
        addressRepository.saveAndFlush(address1);

        var address2 = new Address();
        address2.setCity(city);
        addressRepository.saveAndFlush(address2);

//        var address3 = new Address();
//        address1.setCity(city);

        var employee1 = new Employee();
        employee1.setFirstName("Robert");
        employee1.setLastName("Maxwell");
        employee1.setBirthday(new SimpleDateFormat("dd-mm-yyyy").parse("05-06-1992"));
        employee1.setSalary(new BigDecimal("3000"));
        employee1.setAddress(address1);

        var employee2 = new Employee();
        employee2.setFirstName("Michael");
        employee2.setLastName("Anderson");
        employee2.setBirthday(new SimpleDateFormat("dd-mm-yyyy").parse("02-08-1988"));
        employee2.setSalary(new BigDecimal("4000"));
        employee2.setAddress(address2);

        var manager = new Employee();
        manager.setFirstName("Charles");
        manager.setLastName("Richards");
        manager.setBirthday(new SimpleDateFormat("dd-mm-yyyy").parse("30-10-1975"));
        manager.setSalary(new BigDecimal("6000"));
        manager.setAddress(address2);

        employeeRepository.saveAndFlush(employee1);
        employeeRepository.saveAndFlush(employee2);
        employeeRepository.saveAndFlush(manager);
    }

    private void basicMapping(){
        var mapper = new ModelMapper();
        var employee = employeeRepository.findById(1).get();

        var employeeDto = mapper.map(employee, BasicEmployeeDto.class);
        System.out.println(employeeDto);
    }

    private void advancedMapping(){
        var manager = employeeRepository.findById(3).get();
        var mapper = new ModelMapper();
        var managerDto = mapper.map(manager, ManagerDto.class);
    }
}
