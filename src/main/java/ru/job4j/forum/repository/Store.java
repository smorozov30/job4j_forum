package ru.job4j.forum.repository;

import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.Topic;

import java.util.List;

public interface Store {
    void save(Topic topic);
    List<Topic> getTopics();
    Topic getTopicById(int id);
    void save(Post post);
    Post getPostById(int id);
}
