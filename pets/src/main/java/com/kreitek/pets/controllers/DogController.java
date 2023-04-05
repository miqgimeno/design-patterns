package com.kreitek.pets.controllers;

import com.kreitek.pets.Controller;
import com.kreitek.pets.domain.Cat;
import com.kreitek.pets.domain.Dog;
import com.kreitek.pets.infraestructure.bd.DbService;
import com.kreitek.pets.Logger;

import java.util.List;

public class DogController implements Controller {

    // TODO Logger declaration
    Logger logger = new Logger();

    public String executePut(String petName, String ownerName, String telephone) {
        // TODO logger.debug("DogController.executePut " + petName + "," + ownerName + "," + telephone);
        Dog dog = new Dog(petName, ownerName, telephone);
        DbService dbService = DbService.getInstance();
        dbService.addNewDog(dog);
        return logger.debug("DogController.executePut " + petName + "," + ownerName + "," + telephone);
    }

    @Override
    public String executeGet() {
        // TODO logger.debug("DogController.executeGet DOGS");
        DbService dbService = DbService.getInstance();
        List<Dog> dogs = dbService.getDogs();
        String response = "";
        for (Dog dog:dogs) {
            response += dog.toString() + "\r\n";
        }
        return logger.debug("DogController.executeGet DOGS");
    }
}
