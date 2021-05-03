package coffeeShop.Adapters;


import java.util.Locale;

import coffeeShop.Abstract.CustomerCheckService;
import coffeeShop.Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CustomerCheckService {

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		KPSPublicSoap client = new KPSPublicSoapProxy();

		boolean result = false;
		
		try {
			System.out.println("Identity check is progressing...");
			
			System.out.println("TC id: " + Long.parseLong(customer.getNationalityId()) 
			+ "\nFirst Name: " + customer.getFirstName().toUpperCase(new Locale("tr","TR"))
			+ "\nLast Name: " + customer.getLastName().toUpperCase(new Locale("tr","TR"))
			+ "\nBirth Year: " + customer.getDateOfBirth().getYear());
			
			result = client.TCKimlikNoDogrula(
					Long.parseLong(customer.getNationalityId()) , 
					customer.getFirstName().toUpperCase(new Locale("tr","TR")), 
					customer.getLastName().toUpperCase(new Locale("tr","TR")), 
					customer.getDateOfBirth().getYear()
					);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}
		return result;
	}
	
}
