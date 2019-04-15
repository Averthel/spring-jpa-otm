package pl.ave.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="client_order")
public class Order {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_order")
    private Long id;
    @ManyToMany
    @JoinTable(name = "order_products",
            joinColumns = {@JoinColumn(name="order_id", referencedColumnName="id_order")},
            inverseJoinColumns = {@JoinColumn(name="product_id", referencedColumnName="id_product")}
    )
    private List<Product> products;
    @Column(name="details", length = 512)
    private String orderDetails;
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    Order(){}

    public Order(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String toString() {
        return "Order [id=" + id + ", product=" + products
                + ", orderDetails=" + orderDetails + ", "
                + client.getFirstName() + " " + client.getLastName() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (getId() != null ? !getId().equals(order.getId()) : order.getId() != null) return false;
        if (getProducts() != null ? !getProducts().equals(order.getProducts()) : order.getProducts() != null)
            return false;
        if (getOrderDetails() != null ? !getOrderDetails().equals(order.getOrderDetails()) : order.getOrderDetails() != null)
            return false;
        return getClient() != null ? getClient().equals(order.getClient()) : order.getClient() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getProducts() != null ? getProducts().hashCode() : 0);
        result = 31 * result + (getOrderDetails() != null ? getOrderDetails().hashCode() : 0);
        result = 31 * result + (getClient() != null ? getClient().hashCode() : 0);
        return result;
    }
}
