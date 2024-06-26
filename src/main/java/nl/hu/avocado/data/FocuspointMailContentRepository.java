package nl.hu.avocado.data;


import nl.hu.avocado.domain.FocuspointMailContent;
import nl.hu.avocado.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  FocuspointMailContentRepository   extends JpaRepository<FocuspointMailContent, Long> {
    FocuspointMailContent  findByTitle(String email);
}
