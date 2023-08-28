package by.vladsimonenko.spring.entity;

import jakarta.persistence.*;

import java.time.LocalTime;
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "hours")
    private int hours;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @Column(name = "start_date")
    private LocalTime startDate;
    @Column(name = "price")
    private double price;
    @Column(name = "accepted")
    boolean accepted;

    public Order() {
    }

    public Order(Client client, int hours, Car car, LocalTime startDate, double price, boolean accepted) {
        this.client = client;
        this.hours = hours;
        this.car = car;
        this.startDate = startDate;
        this.price = price;
        this.accepted = accepted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalTime startDate) {
        this.startDate = startDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
