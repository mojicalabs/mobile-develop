/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everydaymetrics.shout_it.sb;

import com.everydaymetrics.shout_it.entities.Credential;
import com.everydaymetrics.shout_it.facade.Facade;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author jalburquerque
 */
@Stateless
public class shout_it_sb implements shout_it_sbRemote {

    @Override
    public int createCredential(Credential credential) {
        return Facade.getFacadeInstance().createCredential(credential);
    }

    @Override
    public boolean editCredential(Credential credential) {
        return Facade.getFacadeInstance().editCredential(credential);
    }

    @Override
    public List<Credential> getAllCredential() {
       return Facade.getFacadeInstance().getAllCredential();
    }
    
}
