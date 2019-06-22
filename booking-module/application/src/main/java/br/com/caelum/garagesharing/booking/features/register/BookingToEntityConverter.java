package br.com.caelum.garagesharing.booking.features.register;

import br.com.caelum.garagesharing.booking.shared.domain.BookingEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookingToEntityConverter implements Converter<Booking, BookingEntity> {

    @Override
    public BookingEntity convert(Booking booking) {
        return new BookingEntity(booking.getUserId(), booking.getGarageId(), booking.getStart(), booking.getEnd());
    }
}
