package nl.hu.avocado.controller;

import nl.hu.avocado.controller.dto.FocuspointDTO;
import nl.hu.avocado.controller.dto.FocuspointMailContentDTO;
import nl.hu.avocado.domain.FocuspointMailContent;
import nl.hu.avocado.service.FocuspointMailContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/focuspointContent")
public class FocuspointMailContentController {
    private final FocuspointMailContentService focuspointMailContentService;

    public FocuspointMailContentController(FocuspointMailContentService focuspointMailContentService) {
        this.focuspointMailContentService = focuspointMailContentService;
    }

    @PostMapping
    public ResponseEntity<Void> addContent(@RequestBody FocuspointMailContentDTO focuspointMailContentDTO) {
        focuspointMailContentService.addFocuspointMailContent(focuspointMailContentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{title}")
    public FocuspointMailContent getFocuspointMailContentById(@PathVariable String title) {
        FocuspointMailContent focuspointMailContentDTO = focuspointMailContentService.findByTitle(title);
        return focuspointMailContentDTO;
    }

    @GetMapping
    public ResponseEntity<List<FocuspointMailContentDTO>> getAllFocuspointMailContent() {
        List<FocuspointMailContentDTO> focuspointMailContentDTO = focuspointMailContentService.getAllFocuspointMailContents();
        return ResponseEntity.ok(focuspointMailContentDTO);
    }

}
