package softarch.portal.db.webservice;

import java.util.Properties;

public class WebServiceDatabase {
	protected String webServiceUrl;
	
	public WebServiceDatabase(Properties properties) {
		this.webServiceUrl = properties.getProperty("webServiceUrl");
	}
}