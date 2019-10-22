package ro.parkingapp.restapi.backend.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.parkingapp.restapi.backend.entity.Facilities;

@RepositoryRestResource
public interface FacilitiesRepository extends CrudRepository<Facilities, Integer> {
}
