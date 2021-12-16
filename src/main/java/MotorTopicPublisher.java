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


public abstract class MotorTopicPublisher<T> extends RosTopicPublisherCodelet<T> implements IMotorCodelet {

    protected String id;

    public MotorTopicPublisher(String id, String topic, String messageType, String host, URI masterURI) {
        super(id, topic, messageType, host, masterURI);
        this.id = id;
    }

    /**
     * Returns the id of this RosTopicPublisherMotorCodelet.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of this RosTopicPublisherMotorCodelet.
     *
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
}

