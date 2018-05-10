//package br.edu.ifsul.testes;
//
//import br.edu.ifsul.modelo.Cidade;
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
//public class TestePersistirCidade {
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
//        Cidade c1 = new Cidade();
//        c1.setEstado("Teste Grande do Sul");
//        c1.setNome("cidade teste");
//        
//        em.getTransaction().begin();
//        em.persist(c1);
//        em.getTransaction().commit();
//        
//        em.close();
//    }
//    
//}
