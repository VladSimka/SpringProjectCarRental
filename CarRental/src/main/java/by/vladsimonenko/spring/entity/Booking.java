package by.vladsimonenko.spring.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.time.LocalTime;
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    @Valid
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

    private String ex;
    @Column(name = "start_accepted")
    boolean startAccepted;
    @Column(name = "end_accepted")
    boolean endAccepted;

    public Booking() {
    }

    public Booking(Client client, int hours, Car car, LocalTime startDate, double price, boolean startAccepted, boolean endAccepted) {
        this.client = client;
        this.hours = hours;
        this.car = car;
        this.startDate = startDate;
        this.price = price;
        this.startAccepted = startAccepted;
        this.endAccepted = endAccepted;
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

    public boolean isStartAccepted() {
        return startAccepted;
    }

    public void setStartAccepted(boolean startAccepted) {
        this.startAccepted = startAccepted;
    }

    public boolean isEndAccepted() {
        return endAccepted;
    }

    public void setEndAccepted(boolean endAccepted) {
        this.endAccepted = endAccepted;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Booking{");
        sb.append("id=").append(id);
        sb.append(", client=").append(client);
        sb.append(", hours=").append(hours);
        sb.append(", car=").append(car);
        sb.append(", startDate=").append(startDate);
        sb.append(", price=").append(price);
        sb.append(", startAccepted=").append(startAccepted);
        sb.append(", endAccepted=").append(endAccepted);
        sb.append('}');
        return sb.toString();
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }
}
