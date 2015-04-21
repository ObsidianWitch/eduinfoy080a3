package be.library;

public class LibraryServiceProxy implements be.library.LibraryService {
  private String _endpoint = null;
  private be.library.LibraryService libraryService = null;
  
  public LibraryServiceProxy() {
    _initLibraryServiceProxy();
  }
  
  public LibraryServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initLibraryServiceProxy();
  }
  
  private void _initLibraryServiceProxy() {
    try {
      libraryService = (new be.library.LibraryServiceServiceLocator()).getLibraryService();
      if (libraryService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)libraryService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)libraryService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (libraryService != null)
      ((javax.xml.rpc.Stub)libraryService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public be.library.LibraryService getLibraryService() {
    if (libraryService == null)
      _initLibraryServiceProxy();
    return libraryService;
  }
  
  public be.library.Book[] searchForBooks(java.lang.String query) throws java.rmi.RemoteException{
    if (libraryService == null)
      _initLibraryServiceProxy();
    return libraryService.searchForBooks(query);
  }
  
  
}