package nl.hu.avocado.controller;

import nl.hu.avocado.controller.dto.FocuspointDTO;
import nl.hu.avocado.service.FocuspointService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/focuspoint")
public class FocuspointController {

    private final FocuspointService focuspointService;

    public FocuspointController(FocuspointService focuspointService) {
        this.focuspointService = focuspointService;
    }

    @PostMapping
    public ResponseEntity<Void> addFocuspoint(@RequestBody FocuspointDTO focuspointDTO) {
        focuspointService.addFocuspoint(focuspointDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FocuspointDTO> getFocuspointById(@PathVariable Long id) {
        FocuspointDTO focuspointDTO = focuspointService.findById(id);
        return ResponseEntity.ok(focuspointDTO);
    }

    @GetMapping
    public ResponseEntity<List<FocuspointDTO>> getAllFocuspoints() {
        List<FocuspointDTO> focuspointDTOs = focuspointService.getAllFocuspoints();
        return ResponseEntity.ok(focuspointDTOs);
    }
}
