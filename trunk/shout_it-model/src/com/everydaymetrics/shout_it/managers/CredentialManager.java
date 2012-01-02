/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everydaymetrics.shout_it.managers;
import com.everydaymetrics.shout_it.controllers.JpaUtils;
import com.everydaymetrics.shout_it.entities.Credential;
import java.util.List;

/**
 *
 * @author jalburquerque
 */
public class CredentialManager {
    
    private static CredentialManager instance;
    
    public static CredentialManager getCredentialManager() {
        if (instance==null)
        {
            instance = new CredentialManager();
            
        }
        
        return instance;    
    }
    
    public int createCredential(Credential credential) {
        return JpaUtils.createEntity(credential);
    }
    
    public boolean editCredential(Credential credential)
    {
        return JpaUtils.editEntity(credential);
    }
    
    public Credential findCredentialById(int id) {
        return (Credential) JpaUtils.findEntity(new Credential(), id);
    }
    
    public List<Credential> getAllCredential() {
        return JpaUtils.findAllEntities(new Credential());
    }
    
    
    
}
