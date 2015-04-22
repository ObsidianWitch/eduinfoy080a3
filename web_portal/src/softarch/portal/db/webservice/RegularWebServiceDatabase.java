package softarch.portal.db.webservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.xml.rpc.holders.StringHolder;

import org.apache.axis.message.MessageElement;

import softarch.portal.data.Book;
import softarch.portal.data.RegularData;
import softarch.portal.db.DatabaseException;
import softarch.portal.db.RegularDatabase;
import librarysearch.soft.BookList;
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
		
		try {
			LibrarySearchSOAPBindingStub binding = new LibrarySearchSOAPBindingStub(
				webServiceUrl, new LibrarySearchServiceLocator()
			);
			StringHolder request = new StringHolder(queryString);
			BookList response = binding.process(request);
			
			return getBooks(response);
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
	
	private List<RegularData> getBooks(BookList booklist) throws Exception {
		List<RegularData> result = new Vector<RegularData>();
		
		for(MessageElement element : booklist.get_any()) {
			if(element.getName().equals("searchBooksResponse")) {
				for (Iterator<MessageElement> iterator = element.getChildren().iterator(); iterator.hasNext();) {
					MessageElement el = iterator.next();
					be.ac.vub.soft.Book book = (be.ac.vub.soft.Book) el.getObjectValue(be.ac.vub.soft.Book.class);
					result.add(new Book(book));
				}
			} else {
				be.library.Book book = (be.library.Book) element.getObjectValue(be.library.Book.class);
				result.add(new Book(book));
			}
		}
		return result;
	}
}
