package com.habuma.spitter.controller;

import com.habuma.spitter.persistence.Spitter;
import com.habuma.spitter.persistence.SpitterDAO;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class HelloController {

    @Autowired
    SpitterDAO spitterDAO;
    
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) throws SQLException {
        
/*        Spitter spitter = new Spitter(null, "pedroperez", "Pedro Pérez", 
                                      "p3dr0", "pedro.perez@gmail.com", true);
        spitterDAO.addSpitter(spitter);*/
        Spitter spitter = spitterDAO.getSpitterById(new Long(2));
        model.addAttribute("message", spitter.toString());
        return "hello";
    }
}
