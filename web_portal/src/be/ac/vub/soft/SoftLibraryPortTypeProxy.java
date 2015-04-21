package be.ac.vub.soft;

public class SoftLibraryPortTypeProxy implements be.ac.vub.soft.SoftLibraryPortType {
  private String _endpoint = null;
  private be.ac.vub.soft.SoftLibraryPortType softLibraryPortType = null;
  
  public SoftLibraryPortTypeProxy() {
    _initSoftLibraryPortTypeProxy();
  }
  
  public SoftLibraryPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initSoftLibraryPortTypeProxy();
  }
  
  private void _initSoftLibraryPortTypeProxy() {
    try {
      softLibraryPortType = (new be.ac.vub.soft.SoftLibraryServiceLocator()).getsoap();
      if (softLibraryPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)softLibraryPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)softLibraryPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (softLibraryPortType != null)
      ((javax.xml.rpc.Stub)softLibraryPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public be.ac.vub.soft.SoftLibraryPortType getSoftLibraryPortType() {
    if (softLibraryPortType == null)
      _initSoftLibraryPortTypeProxy();
    return softLibraryPortType;
  }
  
  public be.ac.vub.soft.Book[] getAllBooks(java.lang.Object all) throws java.rmi.RemoteException{
    if (softLibraryPortType == null)
      _initSoftLibraryPortTypeProxy();
    return softLibraryPortType.getAllBooks(all);
  }
  
  public be.ac.vub.soft.Book[] searchBooks(java.lang.String query) throws java.rmi.RemoteException{
    if (softLibraryPortType == null)
      _initSoftLibraryPortTypeProxy();
    return softLibraryPortType.searchBooks(query);
  }
  
  
}