package Linkkitietokanta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkController {

    @Autowired
    private LinkRepository linkRepository;

    @GetMapping("/")
    public String showList(Model model){
        model.addAttribute("links", this.linkRepository.findAll());
        return "index";
    }

    @PostMapping("/")
    public String addLink(@RequestParam String title){
        Link nLink = new Link(title);
        this.linkRepository.save(nLink);
        return "redirect:/";
    }


}
