package example.cashcard;

import example.cashcard.data.models.CashCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CardCashJsonTest {

    private CashCard jacksonTester;

    @Test
    public void testCardCashJson() throws Exception {
        CashCard cashCard = new CashCard(99L, 123.45);
        assertEquals(false, cashCard.equals(new CashCard(99L, 123.45)));

    }

}
