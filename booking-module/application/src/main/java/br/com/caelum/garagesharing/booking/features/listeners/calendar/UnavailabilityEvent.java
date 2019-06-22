package br.com.caelum.garagesharing.booking.features.listeners.calendar;

import java.time.LocalDateTime;

public class UnavailabilityEvent {

    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private String garageId;

    public UnavailabilityEvent(Long id, LocalDateTime start, LocalDateTime end, String garageId) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.garageId = garageId;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public String getGarageId() {
        return garageId;
    }
}
