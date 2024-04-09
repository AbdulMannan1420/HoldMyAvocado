package nl.hu.avocado.service;

import nl.hu.avocado.controller.dto.FocuspointDTO;
import nl.hu.avocado.data.FocuspointRepository;
import nl.hu.avocado.domain.Focuspoint;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Transactional
@Service
public class FocuspointService {
    private final FocuspointRepository focuspointRepository;

    public FocuspointService(FocuspointRepository focuspointRepository) {
        this.focuspointRepository = focuspointRepository;
    }

    public FocuspointDTO focuspointIntoDTO(Focuspoint focuspoint) {
        return new FocuspointDTO(focuspoint.getId(), focuspoint.getNaam(), focuspoint.getRanking(), focuspoint.getScore(), focuspoint.getStatus(), focuspoint.getAdvies());
    }

    public Focuspoint dtoIntoFocuspoint(FocuspointDTO dto) {
        return new Focuspoint(dto.getId(), dto.getNaam(), dto.getScore(), dto.getRanking(), dto.getStatus(), dto.getAdvies());
    }

    public void voegFocuspoint(FocuspointDTO focuspointDTO) {
        Focuspoint focuspoint = dtoIntoFocuspoint(focuspointDTO);
        focuspointRepository.save(focuspoint);
    }

    public FocuspointDTO findById(Long id) {
        Focuspoint focuspoint = focuspointRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Focuspoint not found with id: " + id));
        return focuspointIntoDTO(focuspoint);
    }

    public List<FocuspointDTO> getAllFocuspoints() {
        return focuspointRepository.findAll().stream()
                .map(this::focuspointIntoDTO)
                .collect(Collectors.toList());
    }

}
