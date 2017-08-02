package org.launchcode.mybestfriend.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.launchcode.mybestfriend.models.Journal;
import org.launchcode.mybestfriend.models.Pet;
import org.launchcode.mybestfriend.models.User;
import org.launchcode.mybestfriend.models.data.PetDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller(value="journal")
public class JournalController extends AbstractController{

    @RequestMapping(value="/{pet_uid}")
    public String viewJournal(Model model, @PathVariable int pet_uid){
        Pet pet = petDao.findOne(pet_uid);
        model.addAttribute("pet", pet);
        return "journal/view";
    }

    @RequestMapping(value="/add/{pet_uid}", method= RequestMethod.GET)
    public String DisplayAddJournal(Model model){
        model.addAttribute("title", "Add A New Pet");
        model.addAttribute(new Journal());
        return ("journal/add");
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String processAddJournal(@ModelAttribute @Valid Journal newJournal, Errors errors, @RequestParam int pet_uid, Model model, HttpServletRequest request){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add A New Pet");
            return "journal/add";
        }
        Pet petOwner = petDao.findOne(pet_uid);
        newJournal.setPetOwner(petOwner);

        journalDao.save(newJournal);

        return "/pet/view";

    }
}
