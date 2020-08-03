import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MommifierTest {
    Mommifier mommifier = new Mommifier();
    @Test
    void should_insert_mommy_when_vowels_over_thirty_percent_and_has_continuous_set_of_vowels() {
        String mommifiedString1 = mommifier.mommify("kaakaak");
        String mommifiedString2 = mommifier.mommify("kaak");
        assertEquals("kamommyakamommyak", mommifiedString1);
        assertEquals("kamommyak", mommifiedString2);
    }

    @Test
    void should_not_insert_mommy_when_vowels_under_thirty_percent_or_not_have_continuous_set_of_vowels() {
        String notMommifiedString1 = mommifier.mommify("ddmmmm");
        String notMommifiedString2 = mommifier.mommify("dddssammmm");
        assertEquals(notMommifiedString1, "ddmmmm");
        assertEquals(notMommifiedString2, "dddssammmm");
    }

    
}
