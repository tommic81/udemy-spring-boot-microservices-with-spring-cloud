package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    void getCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testSaveNewCustomer(){

        CustomerDto customerDto = CustomerDto.builder().name("New Customer").build();

        URI uri = client.saveNewCustomer(customerDto) ;

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer(){

        CustomerDto dto = CustomerDto.builder().name("New Customer2").build();

        client.updateCustomer(UUID.randomUUID(), dto);
    }

    @Test
    void testDeleteCustomer(){

        client.deleteCustomer(UUID.randomUUID());


    }
}