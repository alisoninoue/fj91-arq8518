package br.com.caelum.garagesharing.booking.features.listeners.calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Entity(name="unavailability")
public class UnavailabilityEntity {

    @Id
    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private String garageId;


    @Deprecated
    private UnavailabilityEntity() {
    }

    public UnavailabilityEntity(Long id, LocalDateTime start, LocalDateTime end, String garageId) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.garageId = garageId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getGarageId() {
        return garageId;
    }

    public void setGarageId(String garageId) {
        this.garageId = garageId;
    }
}
