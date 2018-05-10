//package br.edu.ifsul.testes;
//
//import br.edu.ifsul.modelo.Grupo;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
///**
// * 
// * @author Ismael F. Hepp
// * 
// */
//
//public class TestePersistirGrupo {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        EntityManagerFactory emf = 
//            Persistence.createEntityManagerFactory("DAW-2018-1-5N1-ModelPU");
//        
//        EntityManager em = emf.createEntityManager();
//        
//        Grupo g1 = new Grupo();
//        g1.setNome("grupo teste");
//        g1.setValorDiaria(10.0);
//        
//        em.getTransaction().begin();
//        em.persist(g1);
//        em.getTransaction().commit();
//        
//        em.close();
//    }
//    
//}
