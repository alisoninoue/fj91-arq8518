package br.com.caelum.garagesharing.event;

import java.time.LocalDateTime;

public class UpdatedBookingEvent {

    private Long Id;
    private Long userId;
    private String garageId;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long status;
    private LocalDateTime timestamp = LocalDateTime.now();

    @Deprecated
    public UpdatedBookingEvent() {
    }

    public UpdatedBookingEvent(Long id, Long userId, String garageId, LocalDateTime start, LocalDateTime end, Long status) {
        Id = id;
        this.userId = userId;
        this.garageId = garageId;
        this.start = start;
        this.end = end;
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Long getId() {
        return Id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getGarageId() {
        return garageId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public Long getStatus() {
        return status;
    }
}
