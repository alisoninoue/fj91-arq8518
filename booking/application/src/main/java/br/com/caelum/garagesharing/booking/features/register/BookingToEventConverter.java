package br.com.caelum.garagesharing.booking.features.register;

import br.com.caelum.garagesharing.booking.shared.domain.BookingEntity;
import br.com.caelum.garagesharing.event.UpdatedBookingEvent;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookingToEventConverter implements Converter<BookingEntity, UpdatedBookingEvent> {

    @Override
    public UpdatedBookingEvent convert(BookingEntity bookingEntity) {
        return new UpdatedBookingEvent(bookingEntity.getId(), bookingEntity.getUserId(), bookingEntity.getGarageId(), bookingEntity.getStart(), bookingEntity.getEnd(), bookingEntity.getStatus());
    }
}
