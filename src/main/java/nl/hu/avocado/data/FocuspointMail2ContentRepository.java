package nl.hu.avocado.data;

import nl.hu.avocado.domain.FocuspointMail2Content;
import nl.hu.avocado.domain.FocuspointMailContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FocuspointMail2ContentRepository extends JpaRepository<FocuspointMail2Content, Long> {
}
