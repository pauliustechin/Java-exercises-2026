package unittesting;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;


public class SpamFilterTest {

    private SpamFilter spamFilter;

    @Before
    public void setUp() {
        SpamFilterPolicy spamFilterPolicy = new DictionarySpamFilterPolicy(Arrays.asList("discount", "best"));
        spamFilter = new SpamFilter(spamFilterPolicy);
    }

    @Test
    public void exceptionTesting() {
        Exception exception = assertThrows(NullPointerException.class, () -> new SpamFilter(null));
        assertNull("When trying to create SpamFilter object and null parameter is passed, NullPointerException must be thrown",
                exception.getMessage());
    }

    @Test
    public void emptyDictionary() {
        assertEquals("When passing empty list to filter method, returned list must be empty",
                Collections.emptyList(), spamFilter.filter(new ArrayList<>()));
        assertEquals("When passing null to filter method, returned list must be empty",
                Collections.emptyList(), spamFilter.filter(null));
    }

    @Test
    public void allSpam() {
        Message msg1 = new Message("spam1", "best");
        Message msg2 = new Message("spam2", "discount");
        List<Message> lst = new ArrayList<>();
        lst.add(msg1);
        lst.add(msg2);
        assertEquals("When all passed messages are spam, returned list length must be equal to provided list length.",
                2, spamFilter.filter(lst).toArray().length);
    }

    @Test
    public void noSpam() {
        Message msg1 = new Message("msg1", "text1");
        Message msg2 = new Message("msg2", "text2");
        List<Message> lst = new ArrayList<>();
        lst.add(msg1);
        lst.add(msg2);
        assertEquals("When passing no spam messages, returned list length must be 0.",
                0, spamFilter.filter(lst).toArray().length);
    }

    @Test
    public void someSpam() {
        Message msg1 = new Message("spam1", "best");
        Message msg2 = new Message("spam2", "discount");
        Message msg3 = new Message("msg1", "text1");
        Message msg4 = new Message("msg2", "text2");
        List<Message> lst = new ArrayList<>();
        lst.add(msg1);
        lst.add(msg2);
        lst.add(msg3);
        lst.add(msg4);
        assertEquals("When some messages are spam, returned list length must be equal to a number of spam messages.",
                2, spamFilter.filter(lst).toArray().length);
    }

}
