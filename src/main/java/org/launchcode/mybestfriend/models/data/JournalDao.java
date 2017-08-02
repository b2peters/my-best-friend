package org.launchcode.mybestfriend.models.data;

import org.launchcode.mybestfriend.models.Journal;
import org.springframework.data.repository.CrudRepository;

public interface JournalDao extends CrudRepository<Journal, Integer> {

    public Journal findByOwner(int pet_uid);

}
