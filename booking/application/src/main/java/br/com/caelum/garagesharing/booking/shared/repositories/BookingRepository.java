package br.com.caelum.garagesharing.booking.shared.repositories;

import br.com.caelum.garagesharing.booking.shared.domain.BookingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<BookingEntity, Long> {
}
