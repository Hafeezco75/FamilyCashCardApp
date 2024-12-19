package example.cashcard;

import example.cashcard.data.models.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CashCardApplicationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testThatReturnACashCardWhenDataIsSaved() {
        Employee response = restTemplate.getForObject("/employee/check", Employee.class);
        assertThat(response.getEmail()).isEqualTo("TijaniFareed@gmail.com");
    }
    

}
