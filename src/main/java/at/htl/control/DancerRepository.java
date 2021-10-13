package at.htl.control;

import at.htl.entities.Dancer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Transactional
@ApplicationScoped
public class DancerRepository implements PanacheRepository<Dancer> {

    public Dancer save(Dancer dancerToSave) {
        return getEntityManager().merge(dancerToSave);
    }

    public List<Dancer> findAllDancers(){
        return Collections.unmodifiableList(listAll());
    }
}
