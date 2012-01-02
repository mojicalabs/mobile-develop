/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everydaymetrics.shout_it.sb;

import com.everydaymetrics.shout_it.entities.Credential;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jalburquerque
 */
@Remote
public interface shout_it_sbRemote {
    
    public int createCredential(Credential credential);
    public boolean editCredential(Credential credential);
    public List<Credential> getAllCredential();
    
}
