package br.com.caelum.garagesharing.booking.features.register;


import br.com.caelum.garagesharing.booking.features.listeners.calendar.UnavailabilityEntity;
import br.com.caelum.garagesharing.booking.shared.domain.BookingEntity;
import br.com.caelum.garagesharing.booking.shared.exceptions.BookingNotAvailableException;
import br.com.caelum.garagesharing.booking.shared.exceptions.BookingNotFoundException;
import br.com.caelum.garagesharing.booking.shared.repositories.BookingRepository;
import br.com.caelum.garagesharing.booking.shared.repositories.UnavailabilityRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class BookingService {

    private BookingRepository bookingRepository;
    private UnavailabilityRepository unavailabilityRepository;
    private BookingToEntityConverter converter;
    private final ApplicationEventPublisher publisher;
    private final BookingToEventConverter eventConverter;

    public BookingService(BookingRepository bookingRepository, UnavailabilityRepository unavailabilityRepository, BookingToEntityConverter converter, ApplicationEventPublisher publisher, BookingToEventConverter eventConverter) {
        this.bookingRepository = bookingRepository;
        this.unavailabilityRepository = unavailabilityRepository;
        this.converter = converter;
        this.publisher = publisher;
        this.eventConverter = eventConverter;
    }

    Long createBooking(Booking booking) throws BookingNotAvailableException {
        if (isAvailable(booking)) {
            BookingEntity entity = converter.convert(booking);
            entity.setStatus(BookingStatus.CREATED.getId());
            return bookingRepository.save(entity).getId();
        } else {
            throw new BookingNotAvailableException("Booking not available");
        }
    }

    public void changeStatusBooking(Long id, BookingStatus status) throws Exception {
        Optional<BookingEntity> booking = bookingRepository.findById(id);
        booking.orElseThrow(() -> new BookingNotFoundException());
        BookingEntity entity = booking.get();
        entity.setStatus(status.getId());
        bookingRepository.save(entity);
        publisher.publishEvent(eventConverter.convert(entity));

    }


    private boolean isAvailable(Booking booking) {
        UnavailabilityEntity unavailability = unavailabilityRepository.findByGarageIdAndDate(booking.getGarageId(), booking.getStart(), booking.getEnd());
        return Objects.isNull(unavailability);
    }
}
