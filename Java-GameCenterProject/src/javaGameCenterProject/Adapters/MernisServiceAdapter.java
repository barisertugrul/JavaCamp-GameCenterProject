package javaGameCenterProject.Adapters;

import java.rmi.RemoteException;

import javaGameCenterProject.Abstract.MernisValitadable;
import javaGameCenterProject.Abstract.UserValidationService;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements UserValidationService {

	@Override
	public boolean Validate(MernisValitadable user) {KPSPublicSoap client= new KPSPublicSoapProxy();
	try {
		return client.TCKimlikNoDogrula(Long.parseLong(user.getNationalityId()), user.getFirstName().toUpperCase(), user.getLastName().toUpperCase(), user.getDateOfBirth().getYear());
	} catch (NumberFormatException | RemoteException e) {
		e.printStackTrace();
		return false;
	}
	}

}
