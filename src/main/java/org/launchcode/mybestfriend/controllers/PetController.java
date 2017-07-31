package org.launchcode.mybestfriend.controllers;

import org.launchcode.mybestfriend.models.Pet;
import org.launchcode.mybestfriend.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("pet")
public class PetController extends AbstractController {

    @RequestMapping(value="")
    public String index(Model model, HttpServletRequest request){
        User user = getUserFromSession(request.getSession());

        model.addAttribute("pets", petDao.findByOwner(user));
        model.addAttribute("title", "My Pets");

        return "pet/index";
    }

    @RequestMapping(value="add", method= RequestMethod.GET)
    public String displayAddPetForm (Model model){
        model.addAttribute("title", "Add A Pet");
        model.addAttribute(new Pet());
        return "pet/addPet";
    }

    @RequestMapping(value = "add", method=RequestMethod.POST)
    public String processAddPetForm(@ModelAttribute @Valid Pet newPet, Errors errors, HttpServletRequest request){

        if(errors.hasErrors()){
            return "pet/addPet";
        }

        User owner = getUserFromSession(request.getSession());
        newPet.setOwner(owner);

        petDao.save(newPet);
        return "index";
    }
}
