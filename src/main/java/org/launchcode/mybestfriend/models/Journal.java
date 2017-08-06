package org.launchcode.mybestfriend.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.sql.Blob;

@Entity
public class Journal extends AbstractEntity{

    @NotNull
    private String title;

    @NotNull
    private String entry;

    @ManyToOne
    @JoinColumn(name="pet_uid")
    private Pet owner;


    private Blob picture;

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public Pet getOwner() {
        return owner;
    }

    public void setOwner(Pet owner) {
        this.owner = owner;
    }
}
