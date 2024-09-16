package example.cashcard;

import example.cashcard.data.models.CashCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CashCardApplicationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testThatReturnACashCardWhenDataIsSaved() {
        ResponseEntity<CashCard> response = restTemplate.getForEntity("/cashcards/{requestId}", CashCard.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    

}
