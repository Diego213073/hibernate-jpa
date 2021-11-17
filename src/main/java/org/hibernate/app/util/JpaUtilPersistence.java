package org.hibernate.app.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtilPersistence {

   private static final EntityManagerFactory entityManagerFactory = builderEntityManagerFactory();


   public static EntityManagerFactory builderEntityManagerFactory(){
     return Persistence.createEntityManagerFactory("hibernate-jpa");
   }

   public static EntityManager getEntityManager(){
     return entityManagerFactory.createEntityManager();
   }

}
