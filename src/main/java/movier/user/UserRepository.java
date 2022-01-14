package movier.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE username =  ?1", nativeQuery = true)
    User findUserByUsername(String username);

    @Query(value = "SELECT * FROM user WHERE email =  ?1", nativeQuery = true)
    User findUserByEmail(String email);

    //TODO
    @Transactional
    @Modifying
    @Query(
            value = "INSERT INTO user (username, email, password) values (:username, :email, :password)",
            nativeQuery = true)
    void insertUser(@Param("username") String username,
                    @Param("email") String email,
                    @Param("password") String password);
}
