package coffeeShop.Abstract;

import coffeeShop.Entities.Customer;

public interface CustomerCheckService {
	boolean checkIfRealPerson(Customer customer);
}
