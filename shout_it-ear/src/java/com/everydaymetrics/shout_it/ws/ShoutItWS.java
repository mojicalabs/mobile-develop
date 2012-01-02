/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everydaymetrics.shout_it.ws;

import com.everydaymetrics.shout_it.entities.Credential;
import com.everydaymetrics.shout_it.sb.shout_it_sbRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author jalburquerque
 */
@WebService(serviceName = "ShoutItWS")
public class ShoutItWS {
    @EJB
    private shout_it_sbRemote ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createCredential")
    public int createCredential(@WebParam(name = "credential")
    Credential credential) {
        return ejbRef.createCredential(credential);
    }

    @WebMethod(operationName = "editCredential")
    public boolean editCredential(@WebParam(name = "credential")
    Credential credential) {
        return ejbRef.editCredential(credential);
    }

    @WebMethod(operationName = "getAllCredential")
    public List<Credential> getAllCredential() {
        return ejbRef.getAllCredential();
    }
    
}
