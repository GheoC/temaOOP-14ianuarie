package Test;

import com.sci.tema16ian.Temperatura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TemperaturaTest {

    Temperatura temperatura = new Temperatura();

    @Test
    public void convertTemp() {
        double res = temperatura.convertTemp(98.60);
        Assertions.assertEquals(37, res);
    }
}
