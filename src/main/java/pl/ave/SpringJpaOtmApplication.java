package pl.ave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.ave.dao.ClientDao;
import pl.ave.dao.OrderDao;
import pl.ave.model.Client;
import pl.ave.model.Order;

@SpringBootApplication
public class SpringJpaOtmApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaOtmApplication.class, args);

       Client client = new Client("Majkowy", "Majk", "Wczasowa, Warszawa");
        ClientDao clientDao = ctx.getBean(ClientDao.class);
        clientDao.save(client);
        System.out.println(client);

        Order order = new Order("Frytki", "Frytki z keczupem, dostawa do domu");
        order.setClient(client);
        OrderDao orderDao = ctx.getBean(OrderDao.class);
        orderDao.save(order);

        Client getClient = clientDao.get(1L);
        System.out.println(getClient);
    }

}
