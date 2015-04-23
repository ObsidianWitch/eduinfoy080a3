package softarch.portal.db.webservice;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.xml.rpc.holders.StringHolder;

import softarch.portal.data.Book;
import softarch.portal.data.RegularData;
import softarch.portal.db.DatabaseException;
import softarch.portal.db.RegularDatabase;
import librarysearch.soft.LibrarySearchServiceLocator;
import librarysearch.soft.LibrarySearchSOAPBindingStub;

public class RegularWebServiceDatabase extends WebServiceDatabase
	implements RegularDatabase
{
	public RegularWebServiceDatabase(Properties properties) {
		super(properties);
	}

	public List<RegularData> findRecords(String informationType,
			String queryString) throws DatabaseException {
		
		List<RegularData> result = new Vector<RegularData>();
		
		try {
			LibrarySearchSOAPBindingStub binding = new LibrarySearchSOAPBindingStub(
				webServiceUrl, new LibrarySearchServiceLocator()
			);
			StringHolder request = new StringHolder(queryString);
			librarysearch.soft.Book[] books = binding.process(request);
			
			for (librarysearch.soft.Book book : books) {
				result.add(new Book(book));
			}
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
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
