package com.example.pizza.Pizza;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Pizza implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String  name;
    private String  pizzaType ;
    private String  pizzaSize ;
    private String  Notes ;


    public Pizza() {
    }

    public Pizza(int id, String name, String pizzaType, String pizzaSize, String notes) {
        this.id = id;
        this.name = name;
        this.pizzaType = pizzaType;
        this.pizzaSize = pizzaSize;
        Notes = notes;
    }

    public Pizza(String name, String pizzaType, String pizzaSize, String notes) {
        this.name = name;
        this.pizzaType = pizzaType;
        this.pizzaSize = pizzaSize;
        Notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public String getNotes() {
        return Notes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pizzaType='" + pizzaType + '\'' +
                ", pizzaSize='" + pizzaSize + '\'' +
                ", Notes='" + Notes + '\'' +
                '}';
    }
}
