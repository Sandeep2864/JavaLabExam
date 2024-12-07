package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Insert records
        Client client1 = new Client();
        client1.setName("John Doe");
        client1.setGender("Male");
        client1.setAge(30);
        client1.setLocation("New York");
        client1.setEmailAddress("john.doe@example.com");
        client1.setMobileNumber("1234567890");

        session.save(client1);

        transaction.commit();

        // Print all records
        List<Client> clients = session.createQuery("from Client", Client.class).list();
        for (Client client : clients) {
            System.out.println("Client [ID=" + client.getId() + ", Name=" + client.getName() +
                               ", Gender=" + client.getGender() + ", Age=" + client.getAge() +
                               ", Location=" + client.getLocation() + ", Email=" + client.getEmailAddress() +
                               ", Mobile=" + client.getMobileNumber() + "]");
        }

        session.close();
        sessionFactory.close();
    }
}
