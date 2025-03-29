package com.example.springbootPractice10;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Arrays;

@Service
public class TopicService {

    private List <Topic> topics = new ArrayList<>( Arrays.asList(


            new Topic(1, "Java", "Java description"),

            new Topic(2, "Springboot", "Springboot description")

    ));

    public List <Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(int id) {
        return topics.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null); // Safer alternative to avoid NoSuchElementException
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, int id) {
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId() == (id)) {
                topics.set(i, topic);
                return;
            }
        }

    }

    public Topic deleteTopic(int id) {
        topics.removeIf(t -> t.getId() == (id));
        return null;
    }

}
