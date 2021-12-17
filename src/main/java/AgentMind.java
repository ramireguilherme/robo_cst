import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.MemoryObject;
import br.unicamp.cst.core.entities.Mind;
import br.unicamp.cst.*;
import geometry_msgs.Pose;
import geometry_msgs.PoseStamped;
import geometry_msgs.Twist;
import geometry_msgs.Vector3;
import org.ros.internal.message.Message;
import org.ros.internal.message.RawMessage;
import std_msgs.Header;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


public class AgentMind extends Mind {
    public AgentMind() throws URISyntaxException {
        super();
        MemoryObject atuadorMO;
        MemoryObject sensorMO;
        // Declare Memory Objects
        //Initialize Memory Objects
        atuadorMO = createMemoryObject("ATUADOR");
        sensorMO = createMemoryObject("SENSOR");
        URI uri = new URI("http://127.0.0.1:11311");
        //MotorCodelet motorCodelet = new MotorCodelet("MOTOR","\"/cmd_vel geometry_msgs/Twist\"","127.0.0.1","127.0.0.1" , uri);
        //comentei apenas pra testar com o motor codelet dummy
        DummyMotor motorCodelet = new DummyMotor();
        motorCodelet.addInput(atuadorMO);


        DummyBehavior behavior = new DummyBehavior();
        behavior.addOutput(atuadorMO);

        this.insertCodelet(motorCodelet);
        this.insertCodelet(behavior);

        //Codelet codelet = new Sensor("sensor", "/cmd_vel geometry_msgs/Twist", "std_msgs.String", "127.0.0.1", "http://127.0.0.1:11311");
        start();
    }
    public static void main(String[] args) {
        try{
            AgentMind a = new AgentMind(); // Creates the Agent Mind and start it
        }
        catch (URISyntaxException e){
            System.out.println("URI Exception");
            e.printStackTrace();
        }
    }
}
