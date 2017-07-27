package org.launchcode.mybestfriend.models;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue
    private int uid;

    @NotNull
    @Size(min=2, max=15)
    private String name;

    public int getUid(){
        return this.uid;
    }

    public String getName() {
        return name;
    }
}
