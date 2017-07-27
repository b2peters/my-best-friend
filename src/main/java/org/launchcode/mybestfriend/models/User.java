package org.launchcode.mybestfriend.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User extends AbstractEntity {

    @NotNull
    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9_-]{4,11}", message = "Invaled username")
    private String username;

    @NotNull
    private String pwHash;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //@JoinColumn(name = "pet_uid")
    //private List<Pet> pets;

    public User () {}

    public User(String username, String password){
        this.username = username;
        this.pwHash = hashPassword(password);
    }
    public String getUsername(){
        return username;
    }
    private static String hashPassword(String password){
        return encoder.encode(password);
    }
    public boolean isMatchingPassword(String password){
        return encoder.matches(password, pwHash);
    }
//    protected void addPet(Pet pet){
//        pets.add(pet);
//    }
//    public List<Pet> getPets(){
//        return pets;
//    }

}
