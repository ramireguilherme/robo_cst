import geometry_msgs.Twist;
import geometry_msgs.Vector3;
import org.ros.internal.message.RawMessage;

public class TwistMsg implements Twist {

    @Override
    public Vector3 getLinear() {
        return null;
    }

    @Override
    public void setLinear(Vector3 vector3) {

    }

    @Override
    public Vector3 getAngular() {
        return null;
    }

    @Override
    public void setAngular(Vector3 vector3) {

    }

    @Override
    public RawMessage toRawMessage() {
        return null;
    }
}
