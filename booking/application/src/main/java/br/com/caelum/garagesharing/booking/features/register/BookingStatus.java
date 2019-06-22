package br.com.caelum.garagesharing.booking.features.register;

public enum BookingStatus {
    CREATED(1L),
    PAID(2L),
    CHECKIN(3L),
    CHECKOUT(4L),
    CANCELLED(5L);

    private Long id;

    public Long getId() {
        return id;
    }

    BookingStatus(Long id) {
        this.id = id;
    }
}
