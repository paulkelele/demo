package database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryGeneric {

    private SessionFactory sessionfactory() throws IOException {
        InputStream inputStream = SessionFactoryDataBase.class.getResourceAsStream("../hibernate.properties");

        Properties hibernateProperties = new Properties();
        hibernateProperties.load(inputStream);

        Configuration configuration = new Configuration();
        configuration.setProperties(hibernateProperties);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        return sf;
    }

    public SessionFactory getSessionFactoryInstance() throws Exception {
        return sessionfactory();
    }

}