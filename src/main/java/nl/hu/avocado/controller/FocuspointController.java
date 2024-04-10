package nl.hu.avocado.controller;

import nl.hu.avocado.controller.dto.FocuspointDTO;
import nl.hu.avocado.service.FocuspointService;
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
    public void addFocuspoint(@RequestBody FocuspointDTO focuspointDTO) {
        focuspointService.voegFocuspoint(focuspointDTO);
    }
    @GetMapping("/{id}")
    public FocuspointDTO getFocuspointById(@PathVariable Long id) {
        return focuspointService.findById(id);
    }

    @GetMapping
    public List<FocuspointDTO> getAllFocuspoints() {
        return focuspointService.getAllFocuspoints();
    }

}
