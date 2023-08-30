package by.vladsimonenko.spring.dao;

import by.vladsimonenko.spring.entity.Client;

import java.util.List;

public interface ClientDAO {
    List<Client> getAllClients();
}
