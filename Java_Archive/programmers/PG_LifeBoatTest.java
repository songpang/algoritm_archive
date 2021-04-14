import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PG_LifeBoatTest {

    @Test
    void solutionTest() {
        Assertions.assertEquals(1, PG_LifeBoat.solution(new int[]{40, 40, 40, 40, 40}, 240));
    }
}