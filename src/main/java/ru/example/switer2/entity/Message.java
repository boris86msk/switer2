package ru.example.switer2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "message")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {



    @Id
    @SequenceGenerator(name="messageSequence", sequenceName="message_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="messageSequence")
    private Integer id;

    private String text;

    private String tag;

}
