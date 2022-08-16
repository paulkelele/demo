package database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entities.Amitie;
import entities.Commentaire;
import entities.Personne;

public class SessionFactoryDataBase {
  private  SessionFactory configureSessionFactory( ) throws IOException {

    InputStream inputStream = SessionFactoryDataBase.class.getResourceAsStream("../hibernate.properties");

    Properties hibernateProperties = new Properties();
    hibernateProperties.load(inputStream);

    Configuration configuration = new Configuration();
    configuration.setProperties(hibernateProperties);
    configuration.addPackage("entities");
    configuration
    .addAnnotatedClass(Personne.class)
    .addAnnotatedClass(Commentaire.class)
    .addAnnotatedClass(Amitie.class)
     ;
     
//    configuration.addAnnotatedClass(Amitie.class);
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
        .build();
    SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
    return sf;
  }

  public SessionFactory getSessionFactoryInstance() throws Exception {
    return configureSessionFactory();
  }

  // public  SessionFactory getCurrentSession() throws IOException {
  //   Configuration configuration = new Configuration();
  //   Properties settings = new Properties();
  //   settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
  //   settings.put(Environment.URL, "jdbc:mysql://localhost:3306/jsp?serverTimezone=Europe/Paris");
  //   settings.put(Environment.USER, "root");
  //   settings.put(Environment.PASS, "cerise");
  //   settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
  //    settings.put(Environment.SHOW_SQL, "true");

  //   settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

     

  //   configuration.setProperties(settings);
  //   configuration.addAnnotatedClass(Personne.class); //sınıflar bu şekilde eklenecek.
  //   configuration.addAnnotatedClass(Commentaire.class); //sınıflar bu şekilde eklenecek.

  //   ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
  //     .applySettings(configuration.getProperties()).build();
  //    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
  //   return sessionFactory;
  // }

}
