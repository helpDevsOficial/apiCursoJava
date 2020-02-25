package net.helpdevs.clientApi.Service.impl;

import junit.framework.TestCase;
import net.helpdevs.clientApi.Controller.Exceptions.type.DataIntegrationException;
import net.helpdevs.clientApi.Entity.Client;
import net.helpdevs.clientApi.Repository.ClientRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

public class ClientServiceImplTest extends TestCase {

    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientRepository clientRepository;

    @Before
    public void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindSuccess() {
        try {
            Mockito.when(clientRepository.findById(any(Integer.class)))
                    .thenReturn(Optional.of(Client.builder()
                            .email("teste@teste.com")
                            .name("teste teste")
                            .id(1)
                            .build()));

            Client client = clientService.find(any(Integer.class));
            Assert.assertEquals("teste teste", client.getName());
        } catch (Exception ex) {
            Assert.fail();
        }
    }

    @Test
    public void testClientNotFound() {
        try {
            Mockito.when(clientRepository.findById(any(Integer.class)))
                    .thenReturn(Optional.empty());

            Client client = clientService.find(any(Integer.class));
            Assert.fail();
        } catch (DataIntegrationException ex) {
            Assert.assertEquals(ex.getMessage(),"Cliente não existe");
        }
    }
}