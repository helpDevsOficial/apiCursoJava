package net.helpdevs.clientApi.Service;

import net.helpdevs.clientApi.Dto.ClientDto;
import net.helpdevs.clientApi.Entity.Client;

import java.util.List;

public interface ClientService {

    Client find(int id);
    List<Client> findAll();
    Client update(int idClient, ClientDto client);
    Client insert(ClientDto client);
    void delete(int idClient);
}
