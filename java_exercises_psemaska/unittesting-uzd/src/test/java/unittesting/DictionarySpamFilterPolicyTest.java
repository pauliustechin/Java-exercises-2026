package unittesting;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DictionarySpamFilterPolicyTest {

    private DictionarySpamFilterPolicy dictionarySpamFilterPolicy = new DictionarySpamFilterPolicy(Arrays.asList("discount", "best"));

    @Mock
    private Message message = Mockito.mock(Message.class);

    @Test
    public void exceptionTesting() {
        Exception exception = assertThrows(NullPointerException.class, () -> new DictionarySpamFilterPolicy(null));
        assertNull("When trying to create DictionarySpamFilterPolicy object and null parameter is passed, NullPointerException must be thrown",
                exception.getMessage());
    }

    @Test
    public void spamIsNull() {
        assertEquals("When passing null parameter to method isSpam, false value must be returned.",
                false, dictionarySpamFilterPolicy.isSpam(null));
    }

    @Test
    public void msgSubjectIsNull() {
        Mockito.when(message.getSubject()).thenReturn(null);
        Mockito.when(message.getText()).thenReturn("discount");
        assertEquals("When message's subject is null, isSpam method should check text anyways",true, dictionarySpamFilterPolicy.isSpam(message));
    }

    @Test
    public void msgTextIsNull() {
        Mockito.when(message.getText()).thenReturn(null);
        Mockito.when(message.getSubject()).thenReturn("discount");
        assertEquals("When message's text is null, isSpam method should check text anyways",true, dictionarySpamFilterPolicy.isSpam(message));
    }

    @Test
    public void notCaseSensitive() {
        Mockito.when(message.getSubject()).thenReturn("Not spam");
        Mockito.when(message.getText()).thenReturn("DISCOUNT");
        assertEquals("Method isSpam shouldn't be case sensitive",false, dictionarySpamFilterPolicy.isSpam(message));
    }





}
