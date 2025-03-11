package com.backend.service;

import com.backend.model.Message;
import com.backend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    // Créer un message
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    // Récupérer tous les messages
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    // Récupérer un message par son ID
    public Optional<Message> getMessageById(UUID id) {
        return messageRepository.findById(id);
    }

    // Modifier un message
    public Message updateMessage(UUID id, Message newMessage) {
        if (messageRepository.existsById(id)) {
            newMessage.setId(id);
            return messageRepository.save(newMessage);
        }
        return null;
    }

    // Supprimer un message
    public boolean deleteMessage(UUID id) {
        if (messageRepository.existsById(id)) {
            messageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
