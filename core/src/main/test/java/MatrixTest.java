
import ch.bbw.lorenzheld.GameMatrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixTest {

    GameMatrix GameMatrix = new GameMatrix();

    @BeforeEach
    protected void beforeEach(){
        GameMatrix.setMatrixByK(4, 5, 1);
    }

    @Test
    public void testgetMatrixByK(){
        assertEquals(1, GameMatrix.getMatrixByK(4, 5));
    }


}
