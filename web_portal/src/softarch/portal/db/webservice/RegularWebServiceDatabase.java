package softarch.portal.db.webservice;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import softarch.portal.data.RegularData;
import softarch.portal.db.DatabaseException;
import softarch.portal.db.RegularDatabase;

public class RegularWebServiceDatabase extends WebServiceDatabase
	implements RegularDatabase
{

	public RegularWebServiceDatabase(Properties properties) {
		super(properties);
	}

	public List<RegularData> findRecords(String informationType,
			String queryString) throws DatabaseException {
		// TODO
		throw new DatabaseException("not implemented");
	}

	public List<RegularData> findRecordsFrom(String informationType, Date date)
			throws DatabaseException {
		throw new DatabaseException("not implemented");
	}

	public void add(RegularData rd) throws DatabaseException {
		throw new DatabaseException("not implemented");
	}

	public int getNumberOfRegularRecords(String informationType)
			throws DatabaseException {
		throw new DatabaseException("not implemented");
	}

}
