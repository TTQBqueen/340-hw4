package com.csc340.HW4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * AnimalsController.java.
 * Includes all REST API endpoint mappings for the Animal object.
 */
@Controller
@RequestMapping("/animals")

public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals .
     * http://localhost:8080/animals/all
     *
     * @return a list of Animals  objects.
     */
    @GetMapping("/all")
//    public List<Animal> getAllAnimals() {
//        return service.getAllAnimals();
//    }
    public String getAllAnimals(Model model) {
        model.addAttribute("animalList", service.getAllAnimals());
        //return service.getAllStudents();
        return "animal-list";
    }


    @GetMapping("/{animalId}")
//    public Animal getOneAnimal(@PathVariable int animalId) {
//        return service.getAnimalById(animalId);
//    }
    public String getOneAnimal(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getAnimalById(animalId));
        model.addAttribute("title", animalId);
        return "animal-details";
    }


    /**
     * Get a list of Animals based on their name.
     * <a href="http://localhost:8080/animles?name=cat">...</a>
     *
     * @param name the search key.
     * @return A list of Student objects matching the search key.
     */
    @GetMapping("")
    public String getAnimalsByNameContains(@RequestParam(name = "name", defaultValue = "cat") String name, Model model) {
        model.addAttribute("animalList", service.getAnimalsByNameContains(name));
        model.addAttribute("title", "Animal Name: " + name);
        return "animal-list";
    }


    @PostMapping("/new")
    public String addNewAnimal(@ModelAttribute("animal") Animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/animals/all";
    }

    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        Animal animal = new Animal();
        //attach user list
        model.addAttribute("animalList", service.getAllAnimals());
        return "/animal-create";
    }

    /**
     * Show the update form.
     *
     * @param animalId
     * @param model
     * @return
     */
    @GetMapping("/update/{animalId}")
    public String showUpdateForm(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getAnimalById(animalId));
        return "animal-update";
    }

    /**
     * Perform the update.
     *
     * @param animal
     * @return
     */
    @PostMapping("/update")
    public String updateStudent(Animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/animals/" + animal.getAnimalId();
    }

    /**
     * Delete a Animal object.
     * http://localhost:8080/animals/delete/2
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animals.
     */
    @GetMapping("/delete/{animalId}")
    public String deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return "redirect:/animals/all";
    }


//Not Needed

    /**
     * Get a list of Animals based on their classication.
     * http://localhost:8080/animals/class
     *
     * @param classification the search key.
     * @return A list of Animals objects matching the classification key.
     */

    @GetMapping("/class")
    public String getAnimalsByClassification(@RequestParam(name = "classification", defaultValue = "manmmals") String classification, Model model) {
        model.addAttribute("classification", service.getAnimalsByClassification(classification));
        return "animal-list";
    }

    /**
     * Get a list of Animals based on their name.
     * http://localhost:8080/animals/search?name=blue
     *
     * @param name the search key.
     * @return A list of Animal objects matching the search key.
     */

    @GetMapping("/search")
    public List<Animal> getAnimalsByNameContains(@RequestParam(name = "name", required = false) String name) {
        return service.getAnimalsByNameContains(name);
    }
}