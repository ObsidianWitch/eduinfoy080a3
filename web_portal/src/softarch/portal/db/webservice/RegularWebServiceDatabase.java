package softarch.portal.db.webservice;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.apache.axis.AxisFault;

import softarch.portal.data.Book;
import softarch.portal.data.RegularData;
import softarch.portal.db.DatabaseException;
import softarch.portal.db.RegularDatabase;
import librarysearch.soft.LibrarySearchRequest;
import librarysearch.soft.LibrarySearchResponse;
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
		if (informationType.charAt(0) != 'B') {
			throw new DatabaseException("not supported");
		}
		
		List<RegularData> result = new Vector<RegularData>();
		
		try {
			LibrarySearchSOAPBindingStub binding = new LibrarySearchSOAPBindingStub(
				webServiceUrl, new LibrarySearchServiceLocator()
			);
			LibrarySearchRequest request = new LibrarySearchRequest(queryString);
			LibrarySearchResponse response = binding.process(request);
			
			librarysearch.soft.Book[] books = response.getBooks().getBook();
			for(librarysearch.soft.Book book : books) {
				result.add(new Book(book));
			}
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
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
