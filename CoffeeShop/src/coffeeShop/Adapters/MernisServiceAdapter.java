package coffeeShop.Adapters;

import java.rmi.RemoteException;

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
			result = client.TCKimlikNoDogrula(
					Long.parseLong(customer.getNationalityId()) , 
					customer.getFirstName().toUpperCase(), 
					customer.getLastName().toUpperCase(), 
					customer.getDateOfBirth().getYear()
					);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("Not a real person");
		return result;
	}
	
}
