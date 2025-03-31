import org.example.services.CatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CatServiceTest {
    @Mock
    private CatService catService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCat() {
        String name = "Tom";
        Date birthdate = new Date();
        String color = "Grey";

        catService.createCat(name, birthdate, color);

        verify(catService, times(1)).createCat(name, birthdate, color);
    }

    @Test
    public void testChangeName() {
        Integer id = 1;
        String newName = "Jerry";

        catService.changeName(id, newName);

        verify(catService, times(1)).changeName(id, newName);
    }
}
