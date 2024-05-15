package nl.hu.avocado.data;

import nl.hu.avocado.domain.Theme;
import nl.hu.avocado.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
