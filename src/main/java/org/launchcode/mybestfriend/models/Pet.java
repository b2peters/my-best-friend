package org.launchcode.mybestfriend.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Pet extends AbstractEntity{

    @NotNull
    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9_-]{2,11}", message = "Invalid petName")
    private String petName;

    @ManyToOne
    private User owner;

    @NotNull
    @Size(min=1, message="Please indicate the type of pet")
    private String petType;

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }
}
