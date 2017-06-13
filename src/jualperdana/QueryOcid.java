/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jualperdana;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author user
 */
public class QueryOcid {
    public void Add(Object object) {
        
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JualPerdanaPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
                em.persist(object);
                em.getTransaction().commit();
        } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
        } finally {
                em.close();
        }
    
}

public void update(long a,String b,String c){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JualPerdanaPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        em.createQuery("UPDATE tableperdana e SET e.nama=?1,e.alamat=?2 WHERE e.id=?3",tableperdana.class).setParameter(1, b).setParameter(2, c).setParameter(3, a).executeUpdate();       
        em.getTransaction().commit();
  }

public void hapus(long id){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JualPerdanaPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        int hapusyu=em.createQuery("DELETE FROM tableperdana e WHERE e.id=:par").setParameter("par", id).executeUpdate();
        em.getTransaction().commit();
          
  }

public void Show() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JualPerdanaPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM tableperdana e");
        List<tableperdana> result = query.getResultList();
        for (tableperdana e : result) {
                 System.out.println("ID AGEN :"+ e.getId() + "\n NAMA :" + e.getNama()+ "\n alamat :" +e.getAlamat());   
        }
}
}