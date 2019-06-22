package br.com.caelum.garagesharing.booking.shared.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "booking")
public class BookingEntity {

    @Id
    @GeneratedValue
    private Long Id;
    private Long userId;
    private String garageId;
    private LocalDateTime start;
    private LocalDateTime end;
    private LocalDateTime occuredOn;
    private Long status;


    @Deprecated
    private BookingEntity() {
    }

    public BookingEntity(Long userId, String garageId, LocalDateTime start, LocalDateTime end) {
        this.userId = userId;
        this.garageId = garageId;
        this.start = start;
        this.end = end;
        this.occuredOn = LocalDateTime.now();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getGarageId() {
        return garageId;
    }

    public void setGarageId(String garageId) {
        this.garageId = garageId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public LocalDateTime getOccuredOn() {
        return occuredOn;
    }

    public Long getStatus() {
        return status;
    }
}
