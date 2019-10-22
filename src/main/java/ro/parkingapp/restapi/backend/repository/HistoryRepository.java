package ro.parkingapp.restapi.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.parkingapp.restapi.backend.entity.History;

import java.util.List;

@RepositoryRestResource
public interface HistoryRepository extends CrudRepository<History, Integer> {
    List<History> findAllByRenterUserId(Integer id);
}
