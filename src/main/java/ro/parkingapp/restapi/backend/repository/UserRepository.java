package ro.parkingapp.restapi.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.parkingapp.restapi.backend.entity.User;

import java.math.BigDecimal;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT user.firstName FROM User user WHERE id=?1")
    String getFirstNameById(Integer id);

    @Query("SELECT user.lastName FROM User user WHERE id=?1")
    String getLastNameById(Integer id);

    @Query("SELECT user.phoneNumber FROM User user WHERE id=?1")
    String getPhoneNumberById(Integer id);

    @Query("SELECT user.email FROM User user WHERE email=?1")
    String checkEmail(String email);

    @Query("SELECT user.password FROM User user WHERE email=?1")
    String checkPasswordByEmail(String email);

    @Query("SELECT user.id FROM User user WHERE email=?1")
    int getIdByEmail(String email);

    @Query("SELECT user.credits FROM User user WHERE id=?1")
    BigDecimal getCreditsByUserId(Integer id);
}
