package com.objectDB.objectDB.dao;

import com.objectDB.objectDB.models.Plan;
import com.objectDB.objectDB.models.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PlanDaoImp implements PlanDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public String registrar() {
        Plan plan1=new Plan("Plan 1");
        Plan plan2=new Plan("Plan 2");
        Plan plan3=new Plan("Plan 3");
        Plan plan4=new Plan("Plan 4");
        Plan plan5=new Plan("Plan 5");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/objectDB.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(plan1);
        em.persist(plan2);
        em.persist(plan3);
        em.persist(plan4);
        em.persist(plan5);
        em.getTransaction().commit();

        return "OK";
    }

    @Override
    public List<Plan> getPlanes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/objectDB.odb");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select p from Plan p");
        List<Plan> listaPlan = (List<Plan>) query.getResultList();
        return listaPlan;
    }
}
