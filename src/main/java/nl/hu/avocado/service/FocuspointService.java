package nl.hu.avocado.service;

import nl.hu.avocado.controller.dto.FocuspointDTO;
import nl.hu.avocado.data.FocuspointMailContentRepository;
import nl.hu.avocado.data.FocuspointMail2ContentRepository;
import nl.hu.avocado.data.FocuspointRepository;
import nl.hu.avocado.data.OefeningMailContentRepository;
import nl.hu.avocado.domain.Focuspoint;
import nl.hu.avocado.domain.Theme;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Transactional
@Service
public class FocuspointService {

    private final FocuspointRepository focuspointRepository;

    private final FocuspointMailContentRepository focuspointMailContentRepository;

    private final OefeningMailContentRepository oefeningMailContentRepository;

    private final FocuspointMail2ContentRepository focuspointMailContent2Repository;

    private final ThemeService themeService;

    public FocuspointService(FocuspointRepository focuspointRepository, FocuspointMailContentRepository focuspointMailContentRepository, OefeningMailContentRepository oefeningMailContentRepository, FocuspointMail2ContentRepository focuspointMail2ContentRepository, ThemeService themeService) {
        this.focuspointRepository = focuspointRepository;
        this.focuspointMailContentRepository = focuspointMailContentRepository;
        this.oefeningMailContentRepository = oefeningMailContentRepository;
        this.focuspointMailContent2Repository = focuspointMail2ContentRepository;
        this.themeService = themeService;
    }

    public FocuspointDTO focuspointIntoDto(Focuspoint focuspoint) {
        List<Long> themes = focuspoint.getThemes().stream().map(Theme::getId).collect(Collectors.toList());
        ;
        return new FocuspointDTO(
                focuspoint.getId(),
                focuspoint.getName(),
                focuspoint.getAdvies(),
                focuspoint.getLogo(),
                themes, focuspoint.getFocuspointMailContent().getId(), focuspoint.getOefeningMailContent().getId(), focuspoint.getFocuspointMail2Content().getId()
        );
    }

    public Focuspoint dtoIntoFocuspoint(FocuspointDTO dto) {
        List<Theme> themes = new ArrayList<>();
        for (Long f : dto.getThemes()) {
            themes.add(themeService.dtoIntoTheme(this.themeService.findById(f)));
        }

        return new Focuspoint(
                dto.getId(),
                dto.getName(),
                dto.getAdvies(),
                dto.getLogo(),
                themes, this.focuspointMailContentRepository.findById(dto.getFocuspointMailContent()).orElseThrow()
                , this.oefeningMailContentRepository.findById(dto.getOefeningMailContent()).orElseThrow(), this.focuspointMailContent2Repository.findById(dto.getFocuspointMail2Content()).orElseThrow());
    }


    public void addFocuspoint(FocuspointDTO focuspointDTO) {
        Focuspoint focuspoint = dtoIntoFocuspoint(focuspointDTO);
        focuspointRepository.save(focuspoint);
    }

    public FocuspointDTO findById(Long id) {
        Focuspoint focuspoint = focuspointRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Focuspoint not found with id: " + id));
        return focuspointIntoDto(focuspoint);
    }

    public List<FocuspointDTO> getAllFocuspoints() {
        return focuspointRepository.findAll().stream()
                .map(this::focuspointIntoDto)
                .collect(Collectors.toList());
    }

}
