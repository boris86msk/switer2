package ru.example.switer2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.switer2.entity.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByTag(String tag);
}
