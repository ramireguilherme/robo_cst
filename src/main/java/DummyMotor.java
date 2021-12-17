import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DummyMotor extends Codelet {
    Memory motorMO;
    List<Double> parameters = new ArrayList<>();
    @Override
    public void accessMemoryObjects() {
        if (motorMO == null){
            motorMO =this.getInput("ATUADOR");
        }
    }

    @Override
    public void calculateActivation() {
        //ignore this for now
    }

    @Override
    public void proc() {
        parameters = (List<Double>) motorMO.getI();

        if (!parameters.isEmpty()){
            System.out.println("parametros foram: ");
            System.out.println(parameters.get(0));
            System.out.println(parameters.get(1));
        }
    }
}
