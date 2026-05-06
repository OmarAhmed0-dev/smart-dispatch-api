package com.nexus.NexusShip.mapper;

import com.nexus.NexusShip.dto.request.SenderRequest;
import com.nexus.NexusShip.dto.response.SenderResponse;
import com.nexus.NexusShip.model.Sender;
import org.springframework.stereotype.Component;

@Component
public class SenderMapper {

    public Sender toEntity(SenderRequest request) {
        Sender sender = new Sender();
        sender.setFirstName(request.firstName());
        sender.setLastName(request.lastName());
        sender.setEmail(request.email());
        sender.setPassword(request.password());
        sender.setNationalId(request.nationalId());
        sender.setPhoneNumber(request.phoneNumber());
        sender.setGender(request.gender());


        return sender;
    }

    public SenderResponse toResponse(Sender sender) {
        return new SenderResponse(
                sender.getId(),
                sender.getFirstName(),
                sender.getLastName(),
                sender.getGender(),
                sender.getEmail(),
                sender.getPhoneNumber()
        );
    }

}
