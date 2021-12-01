package webshop.statics;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticsController {
    private StaticsService staticsService;

    public StaticsController(StaticsService staticsService) {
        this.staticsService = staticsService;
    }
}
