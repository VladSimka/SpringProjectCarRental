package by.vladsimonenko.spring.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "description")
    private String description;
    @Column(name = "path_to_image")
    private String pathToImage;

    public Car() {
    }

    public Car(String brand, String model, String description, String pathToImage) {
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.pathToImage = pathToImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!Objects.equals(brand, car.brand)) return false;
        if (!Objects.equals(model, car.model)) return false;
        if (!Objects.equals(description, car.description)) return false;
        return Objects.equals(pathToImage, car.pathToImage);
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (pathToImage != null ? pathToImage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", pathToImage='").append(pathToImage).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
