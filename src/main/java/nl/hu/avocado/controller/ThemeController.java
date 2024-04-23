package nl.hu.avocado.controller;


import nl.hu.avocado.controller.dto.ThemeDTO;
import nl.hu.avocado.service.ThemeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theme")
public class ThemeController {

    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @PostMapping
    public void addTheme(@RequestBody ThemeDTO themeDTO) {
        themeService.addTheme(themeDTO);
    }

    @GetMapping("/{id}")
    public ThemeDTO getThemeById(@PathVariable Long id) {
        return themeService.findById(id);
    }

    @GetMapping
    public List<ThemeDTO> getAllThemes() {
        return themeService.getAllThemes();
    }

}
