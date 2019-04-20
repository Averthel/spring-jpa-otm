package pl.ave.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clients")
public class Client implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_client")
    private long id;
    @Column(name="firstname", nullable = false)
    private String firstName;
    @Column(name="lastname", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String address;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order){
        order.setClient(this);
        getOrders().add(order);
    }

    Client(){}

    public Client(String firstname, String lastname, String adress) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.address = adress;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", address=" + address + orders.size()
                + ",\n orders=" + orders + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (getId() != client.getId()) return false;
        if (getFirstName() != null ? !getFirstName().equals(client.getFirstName()) : client.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(client.getLastName()) : client.getLastName() != null)
            return false;
        if (address != null ? !address.equals(client.address) : client.address != null) return false;
        return getOrders() != null ? getOrders().equals(client.getOrders()) : client.getOrders() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (getOrders() != null ? getOrders().hashCode() : 0);
        return result;
    }
}
