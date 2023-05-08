package com.terminator.event;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class EventRepository implements PanacheMongoRepository<Event> {

    public Event findByTitle(String title){
        return find("title", title).firstResult();
    }

    public List<Event> findOrderByTitle(){
        return listAll(Sort.by("title"));
    }
}
