package softarch.portal.db.webservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

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
		
		/*List<RegularData> result = new Vector<RegularData>();
		if (informationType.charAt(0) != 'B') {
			return result;
		}
		
		try {
			LibrarySearchSOAPBindingStub binding = new LibrarySearchSOAPBindingStub(
				webServiceUrl, new LibrarySearchServiceLocator()
			);
			LibrarySearchRequest request = new LibrarySearchRequest(queryString);
			LibrarySearchResponse response = binding.process(request);
			
			librarysearch.soft.Book[] books = response.getBooks().getBook();
			if (books == null) {
				return result;
			}
			
			for(librarysearch.soft.Book book : books) {
				result.add(new Book(book));
			}
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;*/
		try {
			LibrarySearchSOAPBindingStub binding = new LibrarySearchSOAPBindingStub(
				webServiceUrl, new LibrarySearchServiceLocator()
			);
			StringHolder request = new StringHolder(queryString);
			BookList response = binding.process(request);
			
			return parse(response);
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
	
	private softarch.portal.data.Book createBook(be.ac.vub.soft.Book book) {
		String	author = book.getAuthor();
		long	isbn = book.getIsbn();
		int	pages = 0;
		Date publicationDate = new GregorianCalendar(book.getYear(), 0, 1).getTime();
		String	publisher = book.getPublisher();
		String	review = "";
		String	summary = "";
		String	title = book.getTitle();
		Book b = new softarch.portal.data.Book(new Date(),author,isbn, pages, publicationDate, publisher, review, summary, title);
		return b;
	}
	
	private softarch.portal.data.Book createBook(be.library.Book book) {
		String	author = book.getAuthor();
		long	isbn = Long.parseLong(book.getIsbn(), 10);
		int	pages = 0;
		Date	publicationDate = book.getDate().getTime();
		String	publisher = book.getPublisher();
		String	review = "";
		String	summary = "";
		String	title = book.getTitle();
		Book b = new softarch.portal.data.Book(new Date(),author,isbn, pages, publicationDate, publisher, review, summary, title);
		return b;
		
	}
	
	private List<RegularData> parse(BookList booklist) throws Exception {
		List<RegularData> list = new ArrayList<RegularData>();
		for(MessageElement element : booklist.get_any()) {
			if(element.getName().equals("searchBooksResponse")) {
				for (Iterator<MessageElement> iterator = element.getChildren().iterator(); iterator.hasNext();) {
					MessageElement el = iterator.next();
					be.ac.vub.soft.Book book = (be.ac.vub.soft.Book) el.getObjectValue(be.ac.vub.soft.Book.class);
					list.add(createBook(book));
				}
			} else {
				be.library.Book book = (be.library.Book) element.getObjectValue(be.library.Book.class);
				list.add(createBook(book));
			}
		}
		return list;
	}
}
