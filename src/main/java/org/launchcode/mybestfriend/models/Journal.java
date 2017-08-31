package org.launchcode.mybestfriend.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Journal extends AbstractEntity{

    @NotNull
    private String title;

    @NotNull
    private String entry;

    @ManyToOne
    @JoinColumn(name="pet_uid")
    private Pet owner;


    private String picFileName;

    public String getPicFileName() {
        return picFileName;
    }

    public void setPicFileName(String filename) {
        this.picFileName = filename;
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
