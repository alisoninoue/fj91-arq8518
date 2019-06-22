package br.com.caelum.garagesharing.booking.features.register;


import br.com.caelum.garagesharing.booking.shared.exceptions.BookingNotAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("booking")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Long> create(@Valid @RequestBody Booking booking) throws BookingNotAvailableException {
        Long id = service.createBooking(booking);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }

    @PutMapping("{bookingId}/payment")
    public ResponseEntity<?> payment(@PathVariable Long bookingId) throws Exception {
        service.changeStatusBooking(bookingId, BookingStatus.PAID);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("{bookingId}/cancel")
    public ResponseEntity<?> cancel(@PathVariable Long bookingId) throws Exception {
        service.changeStatusBooking(bookingId, BookingStatus.CANCELLED);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("{bookingId}/checkin")
    public ResponseEntity<?> checkin(@PathVariable Long bookingId) throws Exception {
        service.changeStatusBooking(bookingId, BookingStatus.CHECKIN);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("{bookingId}/checkout")
    public ResponseEntity<?> checkout(@PathVariable Long bookingId) throws Exception {
        service.changeStatusBooking(bookingId, BookingStatus.CHECKOUT);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
