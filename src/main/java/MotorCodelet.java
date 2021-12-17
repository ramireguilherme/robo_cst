import br.unicamp.cst.core.entities.Memory;
import geometry_msgs.*;

import java.net.URI;
import java.util.List;

public class MotorCodelet extends MotorTopicPublisher<Twist> {
    public MotorCodelet(String nodeName, String topic, String messageType, String host, URI masterURI) {
        super(nodeName, topic, messageType, host, masterURI);
    }

    @Override
    public void fillMessageToBePublished(Memory motorMemory, Twist message) {
        List<Float> parameters = (List<Float>) motorMemory.getI();
//do the magic
        if(parameters != null){
            Vector3 linear = message.getLinear();
            Vector3 angular = message.getAngular();

            linear.setX(parameters.get(0));
            linear.setY(0);
            linear.setZ(0);

            angular.setX(0);
            angular.setY(0);
            angular.setZ(parameters.get(1));

            message.setLinear(linear);
            message.setAngular(angular);
        }

    }


}
