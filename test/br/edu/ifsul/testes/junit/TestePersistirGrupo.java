package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.modelo.Grupo;
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
public class TestePersistirGrupo {
    
    EntityManager em;
    
    public TestePersistirGrupo() {
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
            Grupo g = new Grupo();
            Acessorios a = new Acessorios();
            
            g.setNome("teste grupo");
            g.setValorDiaria(100.00);
            a.setNome("teste acessorio");

            em.getTransaction().begin();
            em.persist(a);            
            g.getAcessorios().add(a);
            em.persist(g);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
    
}
