package br.com.caelum.garagesharing.booking.features.listeners.calendar;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface FindByGarageAndDate {

    @Query("Select u from unavailability u  where u.garageId = :garageId" +
            " and u.start >= :start" +
            " and u.end <= :end")
    UnavailabilityEntity findByGarageIdAndDate(@Param("garageId") String garageId, @Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

}
