/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everydaymetrics.shout_it.test;

import org.junit.Ignore;
import com.everydaymetrics.shout_it.entities.Credential;
import com.everydaymetrics.shout_it.facade.Facade;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yamil
 */
public class FacadeTest {
    
    public FacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Ignore
     public void createCredential() {
        Credential credential = new Credential();
        credential.setName("Yamil Alburquerque");
        credential.setUsername("yamilan");
        credential.setPassword("pass1234");
        Facade.getFacadeInstance().createCredential(credential);
    }
    
    @Ignore
    public void findCredentialById(){
        Credential credential = new Credential();
        credential = Facade.getFacadeInstance().findCredentialById(1);
        System.out.println("The #1 credential is for user " + credential.getName());
    }   
    
    @Test
    public void editCredential(){
        Credential credential = new Credential();
        credential = Facade.getFacadeInstance().findCredentialById(1);
        credential.setName("José Alburquerque");
        Facade.getFacadeInstance().editCredential(credential);
        
    }
}
