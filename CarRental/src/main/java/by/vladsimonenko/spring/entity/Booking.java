package by.vladsimonenko.spring.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Objects;

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
    private Timestamp startDate;
    @Column(name = "price")
    private double price;

    @Column(name = "start_accepted")
    boolean startAccepted;
    @Column(name = "end_accepted")
    boolean endAccepted;

    public Booking() {
    }

    public Booking(Client client, int hours, Car car, Timestamp startDate, double price, boolean startAccepted, boolean endAccepted) {
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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (hours != booking.hours) return false;
        if (Double.compare(booking.price, price) != 0) return false;
        if (startAccepted != booking.startAccepted) return false;
        if (endAccepted != booking.endAccepted) return false;
        if (!Objects.equals(client, booking.client)) return false;
        if (!Objects.equals(car, booking.car)) return false;
        return Objects.equals(startDate, booking.startDate);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = client != null ? client.hashCode() : 0;
        result = 31 * result + hours;
        result = 31 * result + (car != null ? car.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (startAccepted ? 1 : 0);
        result = 31 * result + (endAccepted ? 1 : 0);
        return result;
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
}
