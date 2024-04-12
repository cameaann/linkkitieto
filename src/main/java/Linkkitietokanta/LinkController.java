package Linkkitietokanta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class LinkController {
    private final LinkRepository linkRepository;

    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GetMapping("/")
    public String showMenu(){
        return "index";
    }
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("links", this.linkRepository.findAll());
        return "list";
    }

    @GetMapping("/addLink")
    public String showAddLinkPage(){
        return "addLink";
    }
    @PostMapping("/addLink")
    public String addLink(@RequestParam String title,
                          @RequestParam String url,
                          @RequestParam String description,
                          @RequestParam String keyword){
        if(title.isEmpty() || url.isEmpty() || description.isEmpty() || keyword.isEmpty()){
            return "redirect:/addLink";
        }
        Link nLink = new Link(title, url, description, keyword);
        this.linkRepository.save(nLink);
        return "redirect:/addLink";
    }

    @PostMapping("/list/{id}/delete")
    public String deleteLinkPost(@PathVariable Long id){
        this.linkRepository.deleteById(id);
        return "redirect:/list";
    }
}
