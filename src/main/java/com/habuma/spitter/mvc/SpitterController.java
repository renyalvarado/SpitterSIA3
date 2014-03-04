package com.habuma.spitter.mvc;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.service.SpitterService;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ralvarado
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    @Inject
    private SpitterService spitterService;

    public SpitterService getSpitterService() {
        return spitterService;
    }

    public void setSpitterService(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(value = "/spittles", method = GET)
    public String listSpittlesForSpitter(
            @RequestParam("spitter") String username, Model model) {
        Spitter spitter = spitterService.getSpitter(username);
        List<Spittle> spittleList = spitterService.getSpittlesForSpitter(spitter);
        model.addAttribute(spitter);
        model.addAttribute("spittleList", spittleList);
        return "spittles/list";
    }
    
    @RequestMapping(method = GET, params = "new")
    public String createSpitterProfile (Model model) {
        model.addAttribute(new Spitter());
        return "spitter/edit";
    }

    @Transactional
    @RequestMapping(method = POST)
    public String addSpitterFromForm(@Valid Spitter spitter, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "spitter/edit";
        }
        spitterService.saveSpitter(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }
    
    @RequestMapping(value = "/{username}", method = GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        Spitter spitter = spitterService.getSpitter(username);
        model.addAttribute(spitter);
        return "spitter/view";
    }
}
