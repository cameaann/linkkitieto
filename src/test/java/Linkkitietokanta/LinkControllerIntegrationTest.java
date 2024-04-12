package Linkkitietokanta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LinkControllerIntegrationTest {
    @Autowired
    private LinkController linkController;

    @Autowired
    private LinkRepository linkRepository;

    @Test
    void addLink_should_add_link_to_repository() {
        linkController.addLink("test link", "https://test.com", "test", "test");

        List<Link> links = linkRepository.findAll();
        Assertions.assertEquals(1, links.size());
        Assertions.assertEquals("test link", links.get(0).getTitle());
    }
}
