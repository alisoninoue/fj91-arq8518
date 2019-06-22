package br.com.caelum.garagesharing.booking.features.listeners.calendar;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnavailabilityToEntityConverter implements Converter<UnavailabilityEvent, UnavailabilityEntity> {
    @Override
    public UnavailabilityEntity convert(UnavailabilityEvent event) {
        return new UnavailabilityEntity(event.getId(), event.getStart(), event.getEnd(), event.getGarageId());
    }
}
