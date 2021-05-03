package coffeeShop;

import java.time.LocalDate;
import java.util.Date;

import coffeeShop.Abstract.BaseCustomerManager;
import coffeeShop.Adapters.MernisServiceAdapter;
import coffeeShop.Concrete.NeroCustomerManager;
import coffeeShop.Concrete.StarbucksCustomerManager;
import coffeeShop.Entities.Customer;

public class Main {

	public static void main(String[] args) {
		
		Customer customer = new Customer(1,"Deniz","Dinler",LocalDate.of(1989, 6, 19),"123455555");
		
//		BaseCustomerManager customerManager1 = new NeroCustomerManager();
//		customerManager1.save(customer);
		
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		customerManager.save(customer);
	}

}
