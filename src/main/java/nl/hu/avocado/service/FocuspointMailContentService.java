package nl.hu.avocado.service;


import nl.hu.avocado.controller.dto.FocuspointDTO;
import nl.hu.avocado.controller.dto.FocuspointMailContentDTO;
import nl.hu.avocado.data.FocuspointMailContentRepository;
import nl.hu.avocado.data.FocuspointRepository;
import nl.hu.avocado.domain.Focuspoint;
import nl.hu.avocado.domain.FocuspointMailContent;
import nl.hu.avocado.domain.Theme;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class FocuspointMailContentService {
    private final FocuspointMailContentRepository focuspointMailContentRepository;

    public FocuspointMailContentService(FocuspointMailContentRepository focuspointMailContentRepository) {
        this.focuspointMailContentRepository = focuspointMailContentRepository;
    }

    public FocuspointMailContentDTO focuspointMailContentIntoDto(FocuspointMailContent focuspointMailContent) {
        return new FocuspointMailContentDTO(
                focuspointMailContent.getId(),
                focuspointMailContent.getTitle(),
                focuspointMailContent.getText(),
                focuspointMailContent.getURL(),
                focuspointMailContent.getImageURL(),
                focuspointMailContent.getDyk1_tekst(),
                focuspointMailContent.getDyk1_URL(),
                focuspointMailContent.getDyk2_tekst(),
                focuspointMailContent.getDyk2_URL(),
                focuspointMailContent.getDyk3_tekst(),
                focuspointMailContent.getDyk3_URL(),
                focuspointMailContent.getSnc1_tekst(),
                focuspointMailContent.getSnc1_URL(),
                focuspointMailContent.getSnc1_imageURL(),
                focuspointMailContent.getSnc2_tekst(),
                focuspointMailContent.getSnc2_URL(),
                focuspointMailContent.getSnc2_imageURL(),
                focuspointMailContent.getSnc3_tekst(),
                focuspointMailContent.getSnc3_URL(),
                focuspointMailContent.getSnc3_imageURL()
        );
    }

    public FocuspointMailContent dtoIntoFocuspointMailContent(FocuspointMailContentDTO dto) {
        return new FocuspointMailContent(
                dto.getId(),
                dto.getTitle(),
                dto.getText(),
                dto.getURL(),
                dto.getImageURL(),
                dto.getDyk1_tekst(),
                dto.getDyk1_URL(),
                dto.getDyk2_tekst(),
                dto.getDyk2_URL(),
                dto.getDyk3_tekst(),
                dto.getDyk3_URL(),
                dto.getSnc1_tekst(),
                dto.getSnc1_URL(),
                dto.getSnc1_imageURL(),
                dto.getSnc2_tekst(),
                dto.getSnc2_URL(),
                dto.getSnc2_imageURL(),
                dto.getSnc3_tekst(),
                dto.getSnc3_URL(),
                dto.getSnc3_imageURL()
        );
    }

    public void addFocuspointMailContent(FocuspointMailContentDTO focuspointMailContentDTO) {
        FocuspointMailContent focuspointMailContent = dtoIntoFocuspointMailContent(focuspointMailContentDTO);
        focuspointMailContentRepository.save(focuspointMailContent);
    }

    public FocuspointMailContent findByTitle(String title) {
        return focuspointMailContentRepository.findByTitle(title);
    }

    public List<FocuspointMailContentDTO> getAllFocuspointMailContents() {
        return focuspointMailContentRepository.findAll().stream()
                .map(this::focuspointMailContentIntoDto)
                .collect(Collectors.toList());
    }

}
