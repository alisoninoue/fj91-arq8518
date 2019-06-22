package br.com.caelum.garagesharing.booking.shared.repositories;

import br.com.caelum.garagesharing.booking.features.listeners.calendar.FindByGarageAndDate;
import br.com.caelum.garagesharing.booking.features.listeners.calendar.SaveUnavailability;
import br.com.caelum.garagesharing.booking.features.listeners.calendar.UnavailabilityEntity;
import org.springframework.data.repository.Repository;


public interface UnavailabilityRepository extends
        Repository<UnavailabilityEntity, Long>,
        SaveUnavailability,
        FindByGarageAndDate {
}
