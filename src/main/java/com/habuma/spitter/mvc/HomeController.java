package com.habuma.spitter.mvc;

import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.service.SpitterService;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HomeController {

    public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
    
    
    private SpitterService spitterService;

    public SpitterService getSpitterService() {
        return spitterService;
    }

    @Inject
    public void setSpitterService(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(value = {"/","/welcome"}, method = RequestMethod.GET)
    @Transactional
    public String showHomePage(Map<String, Object> model) {
        List<Spittle> lastSpittles = spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE);
        model.put("message", lastSpittles);
        return "hello";
    }
}
