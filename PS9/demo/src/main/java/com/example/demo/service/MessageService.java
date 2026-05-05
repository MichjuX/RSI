package com.example.demo.service;

import com.example.demo.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MessageService {

    private Map<Long, Message> messages = new ConcurrentHashMap<>();

    public MessageService() {
        messages.put(1L, new Message(1L, "Hello World!", "michjux"));
        messages.put(2L, new Message(2L, "Hello Jersey!", "michjux"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public Message getMessage(Long id) {
        return messages.get(id);
    }

    public Message createMessage(Message message) {
        message.setId(messages.size() + 1L);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Long id, Message message) {
        if (id <= 0) {
            return null;
        }
        message.setId(id);
        messages.put(id, message);
        return message;
    }

    public Message deleteMessage(Long id) {
        return messages.remove(id);
    }
}
