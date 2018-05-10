package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Adicional;
import br.edu.ifsul.modelo.Locacao;
import br.edu.ifsul.modelo.TipoAdicional;
import java.util.Calendar;

import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirLocacao {
    
    EntityManager em;
    
    public TestePersistirLocacao() {
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
    public void teste(){
        boolean exception = false;
        try {
            Locacao l = new Locacao();
            Adicional a = new Adicional();
            TipoAdicional t = new TipoAdicional();
            
            l.setDataLocacao(Calendar.getInstance());
            l.setDataDevolucao(Calendar.getInstance());
            l.setKmFinal(300);
            l.setKmInicial(10);
            l.setValorDiaria(80.00);
            l.setValorTotal(80.00);

            t.setNome("teste tipo");
            t.setValor(100.00);
            a.setValor(100.00);
            
            
            em.getTransaction().begin();
            em.persist(t);
            a.setTipo(t);
            l.adicionarAdicional(a);
            em.persist(l);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
    
}
