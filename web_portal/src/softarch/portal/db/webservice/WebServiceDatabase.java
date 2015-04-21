package softarch.portal.db.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class WebServiceDatabase {
	protected URL webServiceUrl;
	
	public WebServiceDatabase(Properties properties) {
		try {
			this.webServiceUrl = new URL(properties.getProperty("webServiceUrl"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}