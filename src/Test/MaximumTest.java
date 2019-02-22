package Test;

import com.sci.tema16ian.Maximum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumTest {

    private Maximum maximum = new Maximum();

    @Test
    public void getMax() {
        int res = maximum.getMax(53, 35);
        Assertions.assertEquals(53, res);
    }


}
