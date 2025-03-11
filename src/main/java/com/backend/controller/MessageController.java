package com.backend.controller;

import com.backend.model.Message;
import com.backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    // Créer un message
    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return messageService.createMessage(message);
    }

    // Récupérer tous les messages
    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    // Récupérer un message par ID
    @GetMapping("/{id}")
    public Optional<Message> getMessageById(@PathVariable UUID id) {
        return messageService.getMessageById(id);
    }

    // Modifier un message
    @PutMapping("/{id}")
    public Message updateMessage(@PathVariable UUID id, @RequestBody Message message) {
        return messageService.updateMessage(id, message);
    }

    // Supprimer un message
    @DeleteMapping("/{id}")
    public boolean deleteMessage(@PathVariable UUID id) {
        return messageService.deleteMessage(id);
    }
}
