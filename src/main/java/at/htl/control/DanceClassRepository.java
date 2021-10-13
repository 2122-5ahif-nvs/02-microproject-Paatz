package at.htl.control;

import at.htl.entities.DanceClass;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Transactional
@ApplicationScoped
public class DanceClassRepository implements PanacheRepository<DanceClass> {

    public DanceClass save(DanceClass danceClassToSave) {
        return getEntityManager().merge(danceClassToSave);
    }

    public List<DanceClass> findAllDanceClasses(){
        return Collections.unmodifiableList(listAll());
    }
}
