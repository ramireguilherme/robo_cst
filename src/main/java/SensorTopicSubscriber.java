import br.unicamp.cst.bindings.rosjava.RosTopicSubscriberCodelet;
import br.unicamp.cst.core.entities.Memory;

import java.net.URI;

public class SensorTopicSubscriber extends RosTopicSubscriberCodelet {

    public SensorTopicSubscriber(String nodeName, String topic, String messageType, String host, URI masterURI) {
        super(nodeName, topic, messageType, host, masterURI);
    }

    @Override
    public void fillMemoryWithReceivedMessage(Object message, Memory sensoryMemory) {

    }
}
