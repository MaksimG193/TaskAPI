
import com.example.SuperHero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperHeroTest {

    @Test
    public void testFindTallestMaleWithJob() {
        SuperHero result = SuperHero.findTallestHero("male", true);
        assertEquals("Batman", result.getName());
    }

    @Test
    public void testFindTallestFemaleWithJob() {
        SuperHero result = SuperHero.findTallestHero("female", true);
        assertEquals("Wonder Woman", result.getName());
    }

    @Test
    public void testFindTallestHeroWithoutFilters() {
        SuperHero result = SuperHero.findTallestHero(null, false);
        assertEquals("Hulk", result.getName());
    }

    @Test
    public void testFindTallestFemaleWithoutJob() {
        SuperHero result = SuperHero.findTallestHero("female", false);
        assertEquals("Catwoman", result.getName());
    }

    @Test
    public void testFindTallestHeroWithoutJob() {
        SuperHero result = SuperHero.findTallestHero(null, false);
        assertEquals("Catwoman", result.getName());
    }

    @Test
    public void testFindTallestHeroWithUnknownCriteria() {
        SuperHero result = SuperHero.findTallestHero("unknown", false);
        assertEquals(null, result);
    }
}