//package br.edu.ifsul.testes;
//
//import br.edu.ifsul.modelo.Fabricante;
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
//public class TestePersistirFabricante {
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
//        Fabricante f1 = new Fabricante();
//        f1.setNome("Fabrica teste");
//                
//        em.getTransaction().begin();
//        em.persist(f1);
//        em.getTransaction().commit();
//        
//        em.close();
//    }
//    
//}
