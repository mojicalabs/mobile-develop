/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everydaymetrics.shout_it.facade;
import com.everydaymetrics.shout_it.entities.Credential;
import com.everydaymetrics.shout_it.managers.CredentialManager;
import java.util.List;
/**
 *
 * @author jalburquerque
 */
public class Facade {
    
    private static Facade instance;
    
    public static Facade getFacadeInstance() {
        if (instance==null)
        {
            instance = new Facade();
        }
        
        return instance;
               
    }
    
    public int createCredential(Credential credential) {    
        return CredentialManager.getCredentialManager().createCredential(credential);   
    }
    
    public boolean editCredential (Credential credential) {
        return CredentialManager.getCredentialManager().editCredential(credential);
    }
    
    public List<Credential> getAllCredential() {
        return CredentialManager.getCredentialManager().getAllCredential();
    }
    
    
}
