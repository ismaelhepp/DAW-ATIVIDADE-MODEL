package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Vendedor;
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
public class TestePersistirVendedor {
    
    EntityManager em;
    
    public TestePersistirVendedor() {
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
            
            Vendedor v = new Vendedor();
            v.setAtivo(true);
            v.setNome("Teste nome");
            v.setNomeUsuario("teste_vendedor");
            v.setSenha("senha");
            v.setCpf("84806834815");
            v.setRg("1234567890");
            
            em.getTransaction().begin();
            
            em.persist(v);
            
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
    
}
