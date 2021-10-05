package at.htl.repository;

import at.htl.entity.Dancer;

import javax.enterprise.context.ApplicationScoped;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class RepositoryDancer {
    private static RepositoryDancer instance;
    private List<Dancer> dancers;

    private RepositoryDancer(){
        dancers = createDancers();
    }

    private List<Dancer> createDancers() {
        List<Dancer> dancerList = new LinkedList<>();
        dancerList.add(new Dancer("Felix Rieser", "Wegfeld 3", 17));
        dancerList.add(new Dancer("Patrick Spisak", "Schulstraße 11", 18));
        dancerList.add(new Dancer("Batuhan Özdogan", "Kaplanstraße 12", 19));
        return dancerList;
    }

   public static RepositoryDancer getInstance(){
        if(instance == null){
            instance = new RepositoryDancer();
        }
        return instance;
    }

    public List<Dancer> getDancers(){
        return this.dancers;
    }

    public Dancer removeDancer(String name) {
        Dancer deletedDancer = new Dancer(null, null, 0);
        for (Dancer d : dancers) {
            if (d.getName().equals(name)) {
                deletedDancer = d;
                dancers.remove(d);
            }
        }
        return deletedDancer;
    }

    public Dancer addDancer(String name, String adresse, int age){
        Dancer addDancer = new Dancer(name, adresse, age);
        dancers.add(addDancer);
        return addDancer;
    }

    public Dancer UpdateDancer(Dancer findDancerToUpdate, String name, String address, int age) {
        Dancer updatedDancer = new Dancer(null, null, 0);
        for (Dancer currentDancer : dancers){
            if(currentDancer.getName().equals(findDancerToUpdate.getName())){
                currentDancer.setName(name);
                currentDancer.setAddress(address);
                currentDancer.setAge(age);
                updatedDancer = currentDancer;
            }
        }
        return updatedDancer;
    }

    public boolean searchDancer(String name) {
        boolean found = (boolean) dancers.stream().anyMatch(dancer -> dancer.getName().equals("Vinzent"));

        return found;
    }
}
