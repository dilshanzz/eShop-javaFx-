package dao.util;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory = createSessionFactory();

    private static SessionFactory createSessionFactory() {
        try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();
            Metadata metadata = new MetadataSources(standardRegistry)
                    .addAnnotatedClass(User.class)
                     .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Orders.class)
                    .addAnnotatedClass(Part.class)
                    .addAnnotatedClass(Auser.class)
                    .addAnnotatedClass(Item.class)
                   // .addAnnotatedClass(OrderData.class)
                    .addAnnotatedClass(UsedParts.class)
//                    .addAnnotatedClass((Report.class))


                    .getMetadataBuilder()
                    .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                    .build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            // Log or print the exception details
            ex.printStackTrace();
            throw new ExceptionInInitializerError("Failed to create SessionFactory: " + ex.getMessage());
        }
    }

    public static Session getSession(){
        return  sessionFactory.openSession();
    }
}
