package metier.Test;

import ahmed.foudi.smartbank.metier.CreditMetierImp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CreditMetierImpTest {
    @Test
    public void simpleCalculMensualite(){
        CreditMetierImp cmi = new CreditMetierImp();
        assertEquals(6675.2812459889,cmi.CalculerMensualiteCredit(200000,30));
    }
  
}