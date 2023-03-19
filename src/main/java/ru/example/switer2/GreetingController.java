package ru.example.switer2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.example.switer2.entity.Message;
import ru.example.switer2.repository.MessageRepository;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {


    @Autowired
    private MessageRepository messageRepository;


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/")
    public String addMessage(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message();
        message.setText(text);
        message.setTag(tag);
        messageRepository.save(message);
        Iterable<Message> mess = messageRepository.findAll();
        model.put("messages", mess);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;
        if(filter != null && !filter.isEmpty()) {
            messages = messageRepository.findByTag(filter);
        } else {
            messages = messageRepository.findAll();
        }
        model.put("messages", messages);
        return "main";
    }

}