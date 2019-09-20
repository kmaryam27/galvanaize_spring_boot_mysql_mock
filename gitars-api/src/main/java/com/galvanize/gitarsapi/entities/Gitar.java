package com.galvanize.gitarsapi.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "gitar")
public class Gitar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 20)
    private String model;
    @Size(max = 20)
    private String brand;
    private int strings;

    public Gitar(@Size(max = 20) String model, @Size(max = 20)  String brand,  int strings) {
        this.model = model;
        this.brand = brand;
        this.strings = strings;
    }

    public Gitar(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStrings() {
        return strings;
    }

    public void setStrings(int strings) {
        this.strings = strings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gitar gitar = (Gitar) o;
        return strings == gitar.strings &&
                id.equals(gitar.id) &&
                model.equals(gitar.model) &&
                brand.equals(gitar.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, brand, strings);
    }

    @Override
    public String toString() {
        return "Gitar{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", strings=" + strings +
                '}';
    }
}
