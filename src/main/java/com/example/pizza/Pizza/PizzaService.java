package com.example.pizza.Pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class PizzaService {


    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public void addNewPizza(Pizza pizza) {

        pizzaRepository.save(pizza);

    }

    public List<Pizza> getPizza() {
        return pizzaRepository.findAll();
    }

    public void deletPizza(int pizzaId) {

       boolean exists= pizzaRepository.existsById(pizzaId);

       if (!exists) {
           throw  new IllegalStateException(
                   "Pizza with id "+ pizzaId +"does not exist");

       }

       pizzaRepository.deleteById(pizzaId);

    }
    @Transactional
    public void updatePizza(Integer pizzaId, String pizzaType, String pizzaSize, String notes) {
        Pizza pizza = pizzaRepository.findById(pizzaId)
                .orElseThrow(()-> new IllegalStateException("Pizza with id "+ pizzaId +"does not exist"));

        if (pizzaType != null &&pizzaType.length()>0 &&!Objects.equals(pizza.getPizzaType(),pizzaType)) {
            pizza.setPizzaType(pizzaType);
        }
        if (pizzaSize != null &&pizzaSize.length()>0 &&!Objects.equals(pizza.getPizzaSize(),pizzaSize)) {
            pizza.setPizzaSize(pizzaSize);
        }
        if (notes != null &&notes.length()>0 &&!Objects.equals(pizza.getNotes(),notes)) {
            pizza.setNotes(notes);
        }

    }
}
