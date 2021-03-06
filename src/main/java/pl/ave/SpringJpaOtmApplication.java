package pl.ave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.ave.dao.ClientDao;
import pl.ave.dao.OrderDao;
import pl.ave.dao.ProductDao;
import pl.ave.model.Client;
import pl.ave.model.Order;
import pl.ave.model.Product;

@SpringBootApplication
public class SpringJpaOtmApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaOtmApplication.class, args);

        Client client = new Client("Majkowy", "Majk", "Wczasowa, Warszawa");
        Order order = new Order("Frytki z keczupem, dostawa do domu");
        Product product1 = new Product("Frytki", 5.99, "dostawa");
        Product product2 = new Product("Bataty", 9.99, "dostawa");
        order.getProducts().add(product1);
        order.getProducts().add(product2);
        client.addOrder(order);

        ClientDao clientDao = ctx.getBean(ClientDao.class);
        clientDao.save(client);

        Client getClient = clientDao.get(client.getId());
        System.out.println(getClient);


        clientDao.removeAllOrders(client);


        ctx.close();
    }
}

