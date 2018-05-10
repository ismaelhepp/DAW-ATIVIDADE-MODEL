package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cliente;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ismael F. Hepp <ismaelhepp.ifsul@gmail.com>
 * 
 */
public class TestePersistirCliente {
    
    EntityManager em;
    
    public TestePersistirCliente() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste() {
        Boolean exception = false;
        
        try {
            
            Cliente c = new Cliente();
            
            c.setNome("Teste nome");
            c.setBairro("Teste bairro");
            c.setCep("999-99999");
            c.setCpf("57221996482");
            c.setEndereco("Rua 1, 10");
            c.setRg("1234567890");
            c.setTelefone("(54) 9999-9999");
            
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
    
}
