import br.unicamp.cst.bindings.rosjava.*;
import br.unicamp.cst.core.entities.Memory;
import geometry_msgs.Point;
import geometry_msgs.Pose;
import geometry_msgs.PoseStamped;
import geometry_msgs.Quaternion;
import org.ros.internal.message.Message;
import std_msgs.Header;
import java.util.List;
import java.net.URI;


public class MotorTopicPublisher<Twist> extends RosTopicPublisherCodelet<Twist> {

    protected String nodeName;

    protected String topic;

    protected String messageType;

    protected Memory motorMemory;

    protected Twist message;
    public MotorTopicPublisher(String nodeName, String topic, String messageType, String host, URI masterURI) {
        super(nodeName, topic, messageType, host, masterURI);
    }

    @Override
    public void fillMessageToBePublished(Memory motorMemory, Twist message) {

        List<Float> parameters = (List<Float>) motorMemory.getI();
        //do the magic
        if(parameters != null){
            Header header = message.getHeader();
            header.setFrameId("map");

            Pose pose = message.getPose();

            Point point = pose.getPosition();
            Quaternion quaternion = pose.getOrientation();

            point.setX(parameters.get(0));
            point.setY(parameters.get(1));
            point.setZ(parameters.get(2));

//quaternion.setX(parameters.get(3));
//quaternion.setY(parameters.get(4));
//quaternion.setZ(parameters.get(5));
//quaternion.setW(parameters.get(6));
//fill

            pose.setPosition(point);
            pose.setOrientation(quaternion);

            message.setPose(pose);
            message.setHeader(header);

//message.setPoseStamped(poseStamped);

            System.out.println("goal to be printed: " + message.toString());

//message.setGoal(goal);
        }


    }
}
