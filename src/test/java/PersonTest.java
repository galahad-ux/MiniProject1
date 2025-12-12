import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    public void testCreatePerson(){
        Person p = new Person("Pa01", "Aaliyah ULAK", "Lokanthali Bhaktapur, Nepal", "98 61 05 08 56");

        assertEquals("Pa01", p.getId());
        assertEquals("Aaliyah ULAK", p.getName());
    }

    @Test
    public void testSetters(){
        Person x = new Person("Pa01", "Aaliyah ULAK", "Lokanthali Bhaktapur, Nepal", "98 61 05 08 56");
        x.setName("Aayushka ULAK");
        x.setAddress("Paris");
        x.setContact("16 54 13 21 54");

        assertEquals("Aayushka ULAK", x.getName());
        assertEquals("Paris",x.getAddress() );
    }

}