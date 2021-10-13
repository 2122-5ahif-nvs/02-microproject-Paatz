package at.htl.control;

import at.htl.entities.Room;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class InitBean {

    @Inject
    RoomRepository roomRepository;

    @Transactional
    void onStartUp(@Observes StartupEvent event)
    {
        roomRepository.save(new Room(1,10));
    }

}
