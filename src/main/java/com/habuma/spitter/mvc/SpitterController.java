package com.habuma.spitter.mvc;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.service.SpitterService;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.validation.Valid;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ralvarado
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    @Inject
    private SpitterService spitterService;
    @Value("${imag.spitter.directory}")
    private String imageDirectory;

    public String getImageDirectory() {
        return imageDirectory;
    }

    public void setImageDirectory(String imageDirectory) {
        this.imageDirectory = imageDirectory;
    }

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
    public String createSpitterProfile(Model model) {
        model.addAttribute(new Spitter());
        return "spitter/edit";
    }

    @Transactional
    @RequestMapping(method = POST)
    public String addSpitterFromForm(@Valid Spitter spitter, BindingResult bindingResult,
            @RequestParam(value = "image", required = false) MultipartFile image) {
        try {
            validateImage(image);
        }catch (ImageUploadException e) {
            bindingResult.reject(e.getMessage());
        }
        
        if (bindingResult.hasErrors()) {
            return "spitter/edit";
        }
        try {
            String imageFileName = spitter.getUsername() + "_48x48.png";
            saveImage(imageFileName, image);
        } catch (ImageUploadException e) {
            bindingResult.reject(e.getMessage());
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

    private void validateImage(MultipartFile image) throws ImageUploadException {
        String contentType = image.getContentType();
        if (!contentType.equals("image/png")) {
            throw new ImageUploadException("OnlyPNGImages");
        }
    }

    private void saveImage(String imageFileName, MultipartFile image) throws ImageUploadException {
        try {
            String fullPath = imageDirectory + imageFileName;
            URI uri = new URI(fullPath);
            File file = new File(uri);
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(SpitterController.class.getName()).log(Level.SEVERE, null, ex);
            throw new ImageUploadException("Unable to save image");
        } catch (URISyntaxException ex) {
            Logger.getLogger(SpitterController.class.getName()).log(Level.SEVERE, null, ex);
            throw new ImageUploadException("Unable to save image");
        }
    }
}
