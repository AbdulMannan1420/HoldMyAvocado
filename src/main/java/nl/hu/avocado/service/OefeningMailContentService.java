package nl.hu.avocado.service;

import nl.hu.avocado.controller.dto.OefeningMailContentDTO;
import nl.hu.avocado.data.OefeningMailContentRepository;
import nl.hu.avocado.domain.OefeningMailContent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Transactional
@Service
public class OefeningMailContentService {

    private final OefeningMailContentRepository oefeningMailContentRepository;

    public OefeningMailContentService(OefeningMailContentRepository oefeningMailContentRepository) {
        this.oefeningMailContentRepository = oefeningMailContentRepository;
    }
    public OefeningMailContentDTO oefeningMailContentIntoDto(OefeningMailContent oefeningMailContent) {
        return new OefeningMailContentDTO(
                oefeningMailContent.getId(),
                oefeningMailContent.getQuizContent_URL(),
                oefeningMailContent.getQuiz_URL()
        );
    }

    public OefeningMailContent dtoIntoOefeningMailContent(OefeningMailContentDTO dto) {
        return new OefeningMailContent(
                dto.getQuizContent_URL(),
                dto.getQuiz_URL()
        );
    }

    public void addContent(OefeningMailContentDTO oefeningMailContentDTO) {
        OefeningMailContent oefeningMailContent = dtoIntoOefeningMailContent(oefeningMailContentDTO);
        oefeningMailContentRepository.save(oefeningMailContent);

    }

    public OefeningMailContentDTO findById(Long id) {
        OefeningMailContent oefeningMailContent = oefeningMailContentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("OefeningMailContent not found with id: " + id));
        return oefeningMailContentIntoDto(oefeningMailContent);
    }




}
