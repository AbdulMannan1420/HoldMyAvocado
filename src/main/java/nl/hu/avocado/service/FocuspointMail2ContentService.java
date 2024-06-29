package nl.hu.avocado.service;


import nl.hu.avocado.controller.dto.FocuspointMail2ContentDTO;
import nl.hu.avocado.data.FocuspointMail2ContentRepository;
import nl.hu.avocado.domain.FocuspointMail2Content;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Transactional
@Service
public class FocuspointMail2ContentService {
    private final FocuspointMail2ContentRepository focuspointMail2ContentRepository;

    public FocuspointMail2ContentService(FocuspointMail2ContentRepository focuspointMail2ContentRepository) {
        this.focuspointMail2ContentRepository = focuspointMail2ContentRepository;
    }


    public FocuspointMail2ContentDTO focuspointMail2ContentIntoDto(FocuspointMail2Content focuspointMail2Content) {
        return new FocuspointMail2ContentDTO(
                focuspointMail2Content.getId(),
                focuspointMail2Content.getArticle_title(),
                focuspointMail2Content.getArticle_text(),
                focuspointMail2Content.getArticle_URL(),
                focuspointMail2Content.getArticle_imageURL(),
                focuspointMail2Content.getSn1_title(),
                focuspointMail2Content.getSn1_text(),
                focuspointMail2Content.getSn1_URL(),
                focuspointMail2Content.getSn1_imageURL(),
                focuspointMail2Content.getSn2_title(),
                focuspointMail2Content.getSn2_text(),
                focuspointMail2Content.getSn2_URL(),
                focuspointMail2Content.getSn2_imageURL(),
                focuspointMail2Content.getSn3_title(),
                focuspointMail2Content.getSn3_text(),
                focuspointMail2Content.getSn3_URL(),
                focuspointMail2Content.getSn3_imageURL()
        );
    }

    public FocuspointMail2Content dtoIntoFocuspointMail2Content(FocuspointMail2ContentDTO dto) {
        return new FocuspointMail2Content(
                dto.getId(),
                dto.getArticle_title(),
                dto.getArticle_text(),
                dto.getArticle_URL(),
                dto.getArticle_imageURL(),
                dto.getSn1_title(),
                dto.getSn1_text(),
                dto.getSn1_URL(),
                dto.getSn1_imageURL(),
                dto.getSn2_title(),
                dto.getSn2_text(),
                dto.getSn2_URL(),
                dto.getSn2_imageURL(),
                dto.getSn3_title(),
                dto.getSn3_text(),
                dto.getSn3_URL(),
                dto.getSn3_imageURL()
        );
    }

    public void addContent(FocuspointMail2ContentDTO focuspointMail2ContentDTO) {
        FocuspointMail2Content focuspointMail2Content = dtoIntoFocuspointMail2Content(focuspointMail2ContentDTO);
        focuspointMail2ContentRepository.save(focuspointMail2Content);
    }

    public FocuspointMail2ContentDTO findById(Long id) {
        FocuspointMail2Content focuspointMail2Content = focuspointMail2ContentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("FocuspointMail2Content not found with id: " + id));
        return focuspointMail2ContentIntoDto(focuspointMail2Content);


    }

}
