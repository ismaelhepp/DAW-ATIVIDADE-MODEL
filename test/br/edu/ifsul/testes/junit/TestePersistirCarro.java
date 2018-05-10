package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Fabricante;
import br.edu.ifsul.modelo.Grupo;
import br.edu.ifsul.modelo.Modelo;
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
public class TestePersistirCarro {
    
    EntityManager em;
    
    public TestePersistirCarro() {
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
            Carro c = new Carro();
            Modelo m = new Modelo();
            Fabricante f = new Fabricante();
            Grupo g = new Grupo();
            
            
            em.getTransaction().begin();
            f.setNome("Volks");
            em.persist(f);
            
            g.setNome("Sedan");
            g.setValorDiaria(100.0);
            em.persist(g);
            
            m.setFabricante(f);
            m.setGrupo(g);
            m.setNome("Teste Modelo");
            em.persist(m);
            
            c.setModelo(m);
            
            c.setPlaca("AAA 1111");
            c.setAnoModelo(2010);
            c.setAnoFabricacao(2010);
            c.setVersao("Versao");
            
            em.persist(c);

            
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
    
}
