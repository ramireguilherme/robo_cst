import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.MemoryObject;
import br.unicamp.cst.core.entities.Mind;
import br.unicamp.cst.*;
import java.net.URI;


public class AgentMind extends Mind {
    public AgentMind() {
        super();
        MemoryObject atuadorMO;
        MemoryObject sensorMO;
        // Declare Memory Objects
        //Initialize Memory Objects
        atuadorMO = createMemoryObject("ATUADOR");
        sensorMO =createMemoryObject("SENSOR");

        Codelet codelet = new Sensor("sensor", "/cmd_vel geometry_msgs/Twist", "std_msgs.String", "127.0.0.1", "http://127.0.0.1:11311");
        start();
    }
    public static void main(String[] args) {
        AgentMind a = new AgentMind(); // Creates the Agent Mind and start it
    }
}
