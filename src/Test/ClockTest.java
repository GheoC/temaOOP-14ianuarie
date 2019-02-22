package Test;

import com.sci.tema16ian.Clock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClockTest {

    Clock clock = new Clock();

    @Test
    public void validateTime() {
        boolean corectTime = clock.validateTime(9, 8);
        Assertions.assertEquals(true, corectTime);
    }

}
