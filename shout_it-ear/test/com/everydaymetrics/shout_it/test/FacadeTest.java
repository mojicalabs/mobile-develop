/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everydaymetrics.shout_it.test;

import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Ignore;
import com.everydaymetrics.shout_it.entities.Credential;
import java.util.List;
import java.util.ArrayList;
import com.everydaymetrics.shout_it.facade.Facade;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jalburquerque
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
         credential.setEmail("yamil.alburquerque@gmail.com");
         credential.setAvatar("/avatars/yamilan.jpg");
         credential.setPhrase("frase de prueba");   
         Facade.getFacadeInstance().createCredential(credential);
     }
     
     //Buscar ejemplo de cambio_funcionarios del edit e implementar.
     @Test
     public void editCredential(){
         Credential credential = new Credential();
         credential.setId(1);
         credential.setName("José Alburquerque");
         Facade.getFacadeInstance().editCredential(credential);
     }
     
     @Ignore
     public void getAllCredential() {
         List<Credential> credentialList = new ArrayList();
         credentialList = Facade.getFacadeInstance().getAllCredential();
         for (int i = 0 ; i < credentialList.size() ; i++)
         {
         System.out.println("List of credentials by name: " + credentialList.get(i).getName());
         }
     }
}
