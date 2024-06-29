package nl.hu.avocado.controller;

import nl.hu.avocado.controller.dto.OefeningMailContentDTO;
import nl.hu.avocado.service.OefeningMailContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oefeningContent")
public class OefeningMailContentController {

    private final OefeningMailContentService oefeningMailContentService;

    public OefeningMailContentController(OefeningMailContentService oefeningMailContentService) {
        this.oefeningMailContentService = oefeningMailContentService;
    }

    @PostMapping
    public ResponseEntity<Void> addContent(@RequestBody OefeningMailContentDTO oefeningMailContentDTO) {
        oefeningMailContentService.addContent(oefeningMailContentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public OefeningMailContentDTO getOefeningMailContentById(@PathVariable Long id) {
        return oefeningMailContentService.findById(id);
    }
}
