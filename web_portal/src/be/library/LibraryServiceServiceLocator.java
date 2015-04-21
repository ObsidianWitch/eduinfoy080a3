/**
 * LibraryServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package be.library;

public class LibraryServiceServiceLocator extends org.apache.axis.client.Service implements be.library.LibraryServiceService {

    public LibraryServiceServiceLocator() {
    }


    public LibraryServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LibraryServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LibraryService
    private java.lang.String LibraryService_address = "http://localhost:8080/NationalLibrary/services/LibraryService";

    public java.lang.String getLibraryServiceAddress() {
        return LibraryService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LibraryServiceWSDDServiceName = "LibraryService";

    public java.lang.String getLibraryServiceWSDDServiceName() {
        return LibraryServiceWSDDServiceName;
    }

    public void setLibraryServiceWSDDServiceName(java.lang.String name) {
        LibraryServiceWSDDServiceName = name;
    }

    public be.library.LibraryService getLibraryService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LibraryService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLibraryService(endpoint);
    }

    public be.library.LibraryService getLibraryService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            be.library.LibraryServiceSoapBindingStub _stub = new be.library.LibraryServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getLibraryServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLibraryServiceEndpointAddress(java.lang.String address) {
        LibraryService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (be.library.LibraryService.class.isAssignableFrom(serviceEndpointInterface)) {
                be.library.LibraryServiceSoapBindingStub _stub = new be.library.LibraryServiceSoapBindingStub(new java.net.URL(LibraryService_address), this);
                _stub.setPortName(getLibraryServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("LibraryService".equals(inputPortName)) {
            return getLibraryService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://library.be", "LibraryServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://library.be", "LibraryService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LibraryService".equals(portName)) {
            setLibraryServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
