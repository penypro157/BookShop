/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

/**
 *
 * @author This PC
 */
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
    private static EntityManagerFactory entityManagerFactory;

    static
    {
        try {
            entityManagerFactory= Persistence.createEntityManagerFactory("BookShop");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}