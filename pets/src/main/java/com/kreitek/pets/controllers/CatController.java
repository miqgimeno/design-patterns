package com.kreitek.pets.controllers;

import com.kreitek.pets.Controller;
import com.kreitek.pets.domain.Cat;
import com.kreitek.pets.infraestructure.bd.DbService;
import com.kreitek.pets.Logger;

import java.util.List;

public class CatController implements Controller {

    // TODO Logger declaration
    Logger logger = new Logger();

    @Override
    public String executePut(String petName, String ownerName, String telephone) {
        // TODO logger.debug("CatController.executePut " + petName + "," + ownerName + "," + telephone);
        Cat cat = new Cat(petName, ownerName, telephone);
        DbService dbService = DbService.getInstance();
        dbService.addNewCat(cat);
        return logger.debug("CatController.executePut " + petName + "," + ownerName + "," + telephone);
    }

    @Override
    public String executeGet() {
        // TODO logger.debug("CatController.executeGet CATS");
        DbService dbService = DbService.getInstance();
        List<Cat> cats = dbService.getCats();
        String response = "";
        for (Cat cat:cats) {
            response += cat.toString() + "\r\n";
        }

        return logger.debug("CatController.executeGet CATS");
    }
}
