/**
 * LibraryService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package be.library;

public interface LibraryService extends java.rmi.Remote {
    public be.library.Book[] searchForBooks(java.lang.String query) throws java.rmi.RemoteException;
}
