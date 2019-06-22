package br.com.caelum.garagesharing.booking.features.listeners.calendar;

import br.com.caelum.garagesharing.booking.shared.repositories.UnavailabilityRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UnavailabilityListener {

    private final Converter<UnavailabilityEvent, UnavailabilityEntity> converter;
    private final UnavailabilityRepository unavailabilityRepository;

    public UnavailabilityListener(Converter<UnavailabilityEvent, UnavailabilityEntity> converter, UnavailabilityRepository unavailabilityRepository) {
        this.converter = converter;
        this.unavailabilityRepository = unavailabilityRepository;
    }

    void handle(UnavailabilityEvent event) {
        UnavailabilityEntity entity = converter.convert(event);
        unavailabilityRepository.save(entity);
    }

}
