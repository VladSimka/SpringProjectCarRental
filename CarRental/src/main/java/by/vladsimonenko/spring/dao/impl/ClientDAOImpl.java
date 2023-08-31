package by.vladsimonenko.spring.dao.impl;

import by.vladsimonenko.spring.dao.ClientDAO;
import by.vladsimonenko.spring.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public ClientDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public void saveClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.save(client);
    }
}
