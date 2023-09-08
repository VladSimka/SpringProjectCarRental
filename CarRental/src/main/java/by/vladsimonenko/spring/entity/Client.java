package by.vladsimonenko.spring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    @Size(min = 2,message = "имя должно содержать как минимум 2 символа")
    @NotBlank(message = "имя не должно быть пустым")
    private String name;
    @Column(name = "surname")
    @Size(min = 2,message = "фамилия должно содержать как минимум 2 символа")
    @NotBlank(message = "фамилия не должна быть пустой")
    private String surname;
    @Column(name = "passport_series")
    @Pattern(regexp = "[A-Z]{2}",message = "серия паспорта состоит из двух заглавных букв")
    private String passportSeries;
    @Column(name = "passport_id")
    @Pattern(regexp = "\\d{7}",message = "номер паспорта состоит из 7 цифр")
    private String passportId;
    @Column(name = "gmail")
   // @Pattern(regexp = "\\b[A-Za-z0-9._%+-]+@gmail\\.com\\b",message = "некорректный адрес электронной почты")
    private String gmail;

    public Client() {
    }

    public Client(String name, String surname, String passportSeries, String passportId, String gmail) {
        this.name = name;
        this.surname = surname;
        this.passportSeries = passportSeries;
        this.passportId = passportId;
        this.gmail = gmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!Objects.equals(name, client.name)) return false;
        if (!Objects.equals(surname, client.surname)) return false;
        if (!Objects.equals(passportSeries, client.passportSeries))
            return false;
        if (!Objects.equals(passportId, client.passportId)) return false;
        return Objects.equals(gmail, client.gmail);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (passportSeries != null ? passportSeries.hashCode() : 0);
        result = 31 * result + (passportId != null ? passportId.hashCode() : 0);
        result = 31 * result + (gmail != null ? gmail.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", passportSeries='").append(passportSeries).append('\'');
        sb.append(", passportId='").append(passportId).append('\'');
        sb.append(", gmail='").append(gmail).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
