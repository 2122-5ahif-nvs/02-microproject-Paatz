package at.htl.control;

import at.htl.entities.Room;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Transactional
@ApplicationScoped
public class RoomRepository implements PanacheRepository<Room> {

    public Room save(Room roomToSave) {
        return getEntityManager().merge(roomToSave);
    }

    public List<Room> findAllRooms(){
        return Collections.unmodifiableList(listAll());
    }
}
