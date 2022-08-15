package database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryDataBase {
  private static SessionFactory configureSessionFactory(@SuppressWarnings("rawtypes") Class o) throws IOException {

    InputStream inputStream = SessionFactoryDataBase.class.getResourceAsStream("../hibernate.properties");

    Properties hibernateProperties = new Properties();
    hibernateProperties.load(inputStream);

    Configuration configuration = new Configuration();
    configuration.setProperties(hibernateProperties);
    configuration.addAnnotatedClass(o);
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
        .build();
    SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
    return sf;
  }

  public static SessionFactory getSessionFactoryInstance(@SuppressWarnings("rawtypes") Class o) throws Exception {
    return configureSessionFactory(o);
  }

}
