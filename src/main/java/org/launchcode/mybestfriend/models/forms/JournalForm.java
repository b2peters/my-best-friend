package org.launchcode.mybestfriend.models.forms;

import org.launchcode.mybestfriend.models.Pet;

import javax.validation.constraints.NotNull;

public class JournalForm {

    @NotNull
    private String title;

    @NotNull
    private String entry;

    @NotNull
    private Pet pet;

    public JournalForm(){}

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

    public Pet getPet() {
        return pet;
    }


}
