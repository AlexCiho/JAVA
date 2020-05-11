package com.company.controller;

import com.company.entity.PersonsEntity;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class PersonController {
    private EntityManagerFactory emf;
    public PersonController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public void create(PersonsEntity person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }
//    public PersonsEntity findByName(String personName) {
//        EntityManager em = emf.createEntityManager();
//        Query query = em.createQuery("select t from Person t where t.name like :name");
//        List persons = query.setParameter("name", personName).getResultList();
//        em.close();
//        return persons.isEmpty() ? null : persons.get(0);
//    }
}
