package at.htl.control;

import at.htl.entities.DanceGroup;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Transactional
@ApplicationScoped
public class DanceGroupRepository implements PanacheRepository<DanceGroup> {
    public DanceGroup save(DanceGroup danceGroupToSave) {
        return getEntityManager().merge(danceGroupToSave);
    }

    public List<DanceGroup> findAllDanceGroups(){
        return Collections.unmodifiableList(listAll());
    }
}
