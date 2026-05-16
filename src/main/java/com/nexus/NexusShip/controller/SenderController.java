package com.nexus.NexusShip.controller;

import com.nexus.NexusShip.dto.request.SenderRequest;
import com.nexus.NexusShip.dto.response.SenderResponse;
import com.nexus.NexusShip.dto.update.UserUpdateRequest;
import com.nexus.NexusShip.service.SenderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/senders")
@RequiredArgsConstructor
public class SenderController {
    private final SenderService senderService;

    //Register a new sender
    @PostMapping("/register")
    public ResponseEntity<SenderResponse> registerSender(@Valid @RequestBody SenderRequest request) {
        return new ResponseEntity<>(senderService.registerSender(request), HttpStatus.CREATED);
    }

    //Get all Senders
    @GetMapping
    public ResponseEntity<List<SenderResponse>> getAllSenders() {
        return ResponseEntity.ok(senderService.findAllSenders());
    }

    //Get Sender by id

    @GetMapping("/{id}")
    public ResponseEntity<SenderResponse> getSenderById(@PathVariable Long id) {
        return ResponseEntity.ok(senderService.findSenderById(id));

    }

    //Update Sender
    @PutMapping("/{id}")
    public ResponseEntity<SenderResponse> updateSender(@PathVariable Long id, @Valid @RequestBody UserUpdateRequest request) {
        return ResponseEntity.ok(senderService.updateSender(id, request));
    }

    //Delete Sender
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSender(@PathVariable Long id) {
        senderService.deleteSender(id);
        return ResponseEntity.noContent().build();
    }


}
