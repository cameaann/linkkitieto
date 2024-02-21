package unitTests;

import Linkkitietokanta.LinkController;
import Linkkitietokanta.LinkRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class LinkControllerTest {

    @Mock
    private LinkRepository linkRepository;

    @Mock
    private Model model;

    @InjectMocks
    private LinkController linkController;

    @Test
    void showList() {
        String pageName = linkController.showList(model);

        Assertions.assertEquals("index", pageName);
        Mockito.verify(linkRepository, times(1)).findAll();
        Mockito.verify(model).addAttribute(eq("links"), any(List.class));
    }
}