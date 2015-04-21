package softarch.portal.db.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import softarch.portal.data.Book;
import softarch.portal.data.RegularData;
import softarch.portal.db.DatabaseException;
import softarch.portal.db.RegularDatabase;

public class RegularJSONDatabase extends JSONDatabase implements RegularDatabase {
	
	private String dbUrl;

	public RegularJSONDatabase(Properties properties) {
		super(properties);
		dbUrl = properties.getProperty("dbJSONUrl");
	}

	public List<RegularData> findRecords(String informationType,
			String queryString) throws DatabaseException 
	{
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		List<RegularData> result = new Vector<RegularData>();
		
		if (informationType.charAt(0) == 'B') {
			JsonArray booksArray = getBooks();
			
			for (JsonElement bookElement : booksArray) {
				JsonObject bookObject = (JsonObject) bookElement;
				
				if (bookObject.get("author").getAsString().equals(queryString)) {
					Book book = (Book) gson.fromJson(bookObject, Book.class);
					
					result.add(book);
				}
			}
			
			return result;
		}
		
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
	
	private JsonArray getBooks() throws DatabaseException {
		JsonParser parser = new JsonParser();
		File booksFile = new File(dbUrl + "/books.json");
		JsonArray jsonParsed = null;
		
		try {
			JsonElement jsonElement = parser.parse(new FileReader(booksFile));
			jsonParsed = jsonElement.getAsJsonArray();
		}
		catch (FileNotFoundException e) {
			throw new DatabaseException(
				"File not found Exception: " + e.getMessage()
			);
		}  
		
		return jsonParsed;
	}
}
