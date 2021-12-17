import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import geometry_msgs.*;
import std_msgs.Header;
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
            Header header = message.;
            header.setFrameId("map");

            Point point = (Point) message.getLinear();
            point.setX(parameters.get(0));
            point.setY(parameters.get(1));
            point.setZ(parameters.get(2));
            Quaternion quaternion = (Quaternion) message.getAngular();


            /*header.setFrameId("map");

            Pose pose = message.getPose();

            Point point = pose.getPosition();
            Quaternion quaternion = pose.getOrientation();

            point.setX(parameters.get(0));
            point.setY(parameters.get(1));
            point.setZ(parameters.get(2));

            pose.setPosition(point);
            pose.setOrientation(quaternion);

            message.setPose(pose);
            message.setHeader(header);*/

            //message.setPoseStamped(poseStamped);
            message.setLinear((Vector3) point);
            message.setAngular((Vector3) quaternion);

            message.setPose(pose);
            message.setHeader(header);

            System.out.println("goal to be printed: " + message.toString());

//message.setGoal(goal);
        }


    }
}