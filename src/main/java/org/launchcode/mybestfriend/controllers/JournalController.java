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
import java.util.List;

@Controller
@RequestMapping(value="journal")
public class JournalController extends AbstractController{

    @RequestMapping(value="/{pet_uid}")
    public String viewJournal(Model model, @PathVariable int pet_uid){
        Pet pet = petDao.findOne(pet_uid);
        List<Journal> journals = pet.getJournals();
        model.addAttribute("journals", journals);
        return "journal/view";
    }

    @RequestMapping(value="/add/{pet_uid}", method= RequestMethod.GET)
    public String DisplayAddJournal(Model model, @RequestParam int pet_uid, HttpServletRequest request){

        model.addAttribute("title", "Add A New Pet");
        model.addAttribute("pet_uid", pet_uid);
        model.addAttribute(new Journal());
        return ("journal/add");
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String processAddJournal(@ModelAttribute @Valid Journal newJournal, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add A New Pet");
            return "journal/add";
        }

        journalDao.save(newJournal);

        return "/pet/view";

    }
}
