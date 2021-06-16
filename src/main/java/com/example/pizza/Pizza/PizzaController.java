package com.example.pizza.Pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/pizza")
public class PizzaController {

    private final PizzaService pizzaService;
    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public List<Pizza> getPizza() {
    return pizzaService.getPizza();
    }

    @PostMapping
    public void savePizza (@RequestBody Pizza pizza){

        pizzaService.addNewPizza(pizza);
    }
    @DeleteMapping(path = "{pizzaId}")
    public void deletePizza (@PathVariable("pizzaId") Integer pizzaId){
        pizzaService.deletPizza(pizzaId);

    }
    @PutMapping(path = "{pizzaId}")
    public void updatePizza (@PathVariable("pizzaId") Integer pizzaId,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String pizzaType,
                             @RequestParam(required = false) String pizzaSize,
                             @RequestParam(required = false) String notes){

        pizzaService.updatePizza(pizzaId,name,pizzaType,pizzaSize,notes);
    }

}
