/**
 * LibraryServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package be.library;

public interface LibraryServiceService extends javax.xml.rpc.Service {
    public java.lang.String getLibraryServiceAddress();

    public be.library.LibraryService getLibraryService() throws javax.xml.rpc.ServiceException;

    public be.library.LibraryService getLibraryService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
