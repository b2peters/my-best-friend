package org.launchcode.mybestfriend.models.data;

import org.launchcode.mybestfriend.models.Pet;
import org.launchcode.mybestfriend.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetDao extends CrudRepository<Pet, Integer> {

    List<Pet> findByOwner(User user);
}
