import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import com.google.common.primitives.Doubles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DummyBehavior extends Codelet {
    Memory motorMO;
    List<Double> parameters = Doubles.asList(0, 0);
    @Override
    public void accessMemoryObjects() {
        if (motorMO == null){
            motorMO =this.getOutput("ATUADOR");
        }
    }

    @Override
    public void calculateActivation() {
        //ignore this for now
    }

    @Override
    public void proc() {
        Random rand = new Random();

        Double out  = rand.nextDouble();
        parameters.set(0, out);
        parameters.set(1, out);

        motorMO.setI(parameters);
    }
}
