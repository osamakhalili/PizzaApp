package com.example.pizza.Pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void patchPizza (int id , Pizza pizza) {

        Pizza pizzas =  pizzaRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));

        boolean needUpdate = false;


        if (StringUtils.hasLength(pizza.getName())) {
            pizzas.setName(pizza.getName());
            needUpdate = true;
        }

        if (StringUtils.hasLength(pizza.getPizzaType())) {
            pizzas.setPizzaType(pizza.getPizzaType());
            needUpdate = true;
        }

        if (StringUtils.hasLength(pizza.getPizzaSize())) {
            pizzas.setPizzaSize(pizza.getPizzaSize());
            needUpdate = true;
        }
        if (StringUtils.hasLength(pizza.getNotes())) {
            pizzas.setNotes(pizza.getNotes());
            needUpdate = true;

        }

        if (needUpdate) {
            pizzaRepository.save(pizzas);
        }

    }

    public List<Pizza> findAllPizza() {
        return pizzaRepository.findAll();
    }
    public Optional<Pizza> findPizzaByID(int id ) {
        return pizzaRepository.findById(id);
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
    public void updatePizza(Integer pizzaId,String name, String pizzaType, String pizzaSize, String notes) {
        Pizza pizza = pizzaRepository.findById(pizzaId)
                .orElseThrow(()-> new IllegalStateException("Pizza with id "+ pizzaId +"does not exist"));

        if (name != null &&name.length()>0 &&!Objects.equals(pizza.getName(),name)) {
            pizza.setName(name);
        }

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
