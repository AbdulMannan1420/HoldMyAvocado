package nl.hu.avocado.data;

import nl.hu.avocado.domain.Focuspoint;
import nl.hu.avocado.domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FocuspointRepository  extends JpaRepository<Focuspoint, Long> {

}
