package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.service.MessageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageResource {

    @Autowired
    private MessageService messageService;

    @GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping(value = "/{messageId}", produces = { MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE })
    public Message getMessage(@PathVariable("messageId") Long id) {
        return messageService.getMessage(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message createMessage(@RequestBody Message message) {
        return messageService.createMessage(message);
    }

    @PutMapping(value = "/{messageId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message updateMessage(@PathVariable("messageId") Long id, @RequestBody Message message) {
        return messageService.updateMessage(id, message);
    }

    @DeleteMapping(value = "/{messageId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Message deleteMessage(@PathVariable("messageId") Long id) {
        return messageService.deleteMessage(id);
    }

    @GetMapping(value = "/test/{matrixParam}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String testParams(
            @RequestParam(value = "queryParam", required = false) String queryParam,
            @RequestHeader(value = "headerParam", required = false) String headerParam,
            @MatrixVariable(value = "matrix", pathVar = "matrixParam", required = false) String matrixParam,
            @RequestHeader HttpHeaders headers,
            HttpServletRequest request) {
        return "Query Param: " + queryParam + "\n" +
                "Header Param: " + headerParam + "\n" +
                "Matrix Param: " + matrixParam + "\n" +
                "Context Absolute Path: " + request.getRequestURL().toString();
    }
}
