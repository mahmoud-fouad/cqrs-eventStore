package com.mfouad.cqrs.axonCQRS.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ConfirmOrderEvent {
    private String orderId;
    
}
