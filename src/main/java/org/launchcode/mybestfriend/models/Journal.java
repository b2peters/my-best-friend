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
    @JoinColumn(name="journal_uid")
    private Pet petOwner;

//    Add attribute for img/vid


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
}
