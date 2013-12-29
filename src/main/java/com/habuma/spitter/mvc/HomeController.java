package com.habuma.spitter.mvc;

import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.service.SpitterService;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HomeController {

    public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
    
    @Inject
    private SpitterService spitterService;

    @RequestMapping(value = {"/","/welcome"}, method = RequestMethod.GET)
    @Transactional
    
    public String printWelcome(ModelMap model) throws SQLException {
        List<Spittle> lastSpittles = spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE);
        model.addAttribute("message", lastSpittles);
        return "hello";
    }
}
