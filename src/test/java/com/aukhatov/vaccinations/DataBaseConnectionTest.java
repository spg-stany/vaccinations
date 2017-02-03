package com.aukhatov.vaccinations;

import com.aukhatov.vaccinations.dao.Patient;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataBaseConnectionTest extends TestCase {
    public void testConnect() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Patient patient = new Patient(111L);
        session.save(patient);
        session.getTransaction().commit();
        session.close();
    }
}
