package nl.hu.avocado.data;


import nl.hu.avocado.domain.OefeningMailContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  OefeningMailContentRepository   extends JpaRepository<OefeningMailContent, Long> {

}