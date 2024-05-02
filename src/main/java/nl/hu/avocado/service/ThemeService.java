package nl.hu.avocado.service;


import nl.hu.avocado.controller.dto.ThemeDTO;

import nl.hu.avocado.data.ThemeRepository;
import nl.hu.avocado.domain.Theme;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Transactional
@Service
public class ThemeService {
    private final ThemeRepository themeRepository;

    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    public ThemeDTO themeIntoDTO(Theme theme) {
        return new ThemeDTO(theme.getId(), theme.getNaam(), theme.getRanking(), theme.getScore(), theme.getLogo(), theme.getAdvies());
    }

    public Theme dtoIntoTheme(ThemeDTO dto) {
        return new Theme(dto.getId(), dto.getNaam(), dto.getScore(), dto.getRanking(), dto.getLogo(), dto.getAdvies());
    }

    public void addTheme(ThemeDTO themeDTO) {
        Theme theme = dtoIntoTheme(themeDTO);
        themeRepository.save(theme);
    }

    public ThemeDTO findById(Long id) {
        Theme theme = themeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Theme not found with id: " + id));
        return themeIntoDTO(theme);
    }

    public List<ThemeDTO> getAllThemes() {
        return themeRepository.findAll().stream()
                .map(this::themeIntoDTO)
                .collect(Collectors.toList());
    }

}
