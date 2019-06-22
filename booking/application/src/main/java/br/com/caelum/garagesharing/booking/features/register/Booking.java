package br.com.caelum.garagesharing.booking.features.register;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class Booking {

    @NotNull
    private Long userId;
    @NotNull
    private String garageId;
    @NotNull
    private LocalDateTime start;
    @NotNull
    private LocalDateTime end;

    public Booking(Long userId, String garageId, LocalDateTime booking, LocalDateTime end) {
        this.userId = userId;
        this.garageId = garageId;
        this.start = booking;
        this.end = end;
    }

    public Booking() {
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
}
