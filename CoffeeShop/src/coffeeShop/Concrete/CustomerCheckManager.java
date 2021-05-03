package coffeeShop.Concrete;

import coffeeShop.Abstract.CustomerCheckService;
import coffeeShop.Entities.Customer;

public class CustomerCheckManager implements CustomerCheckService{

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		System.out.println("Person is valid.");
		return true;
	}


}
