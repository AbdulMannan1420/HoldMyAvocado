package nl.hu.avocado.controller;


import nl.hu.avocado.controller.dto.FocuspointMail2ContentDTO;
import nl.hu.avocado.service.FocuspointMail2ContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theme_content")
public class FocuspointMail2ContentController {

    private final FocuspointMail2ContentService focuspointMail2ContentService;

    public FocuspointMail2ContentController(FocuspointMail2ContentService focuspointMail2ContentService) {
        this.focuspointMail2ContentService = focuspointMail2ContentService;
    }

    @PostMapping
    public ResponseEntity<Void> addContent2(@RequestBody FocuspointMail2ContentDTO focuspointMail2ContentDTO) {
        focuspointMail2ContentService.addContent(focuspointMail2ContentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FocuspointMail2ContentDTO> getContent(@PathVariable Long id) {
        return ResponseEntity.ok(focuspointMail2ContentService.findById(id));
    }

}
