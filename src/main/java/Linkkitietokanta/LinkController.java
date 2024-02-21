package Linkkitietokanta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkController {
    private final LinkRepository linkRepository;

    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

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
