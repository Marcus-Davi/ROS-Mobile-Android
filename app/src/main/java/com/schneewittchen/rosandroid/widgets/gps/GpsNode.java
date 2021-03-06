package com.schneewittchen.rosandroid.widgets.gps;

import com.schneewittchen.rosandroid.widgets.base.BaseData;
import com.schneewittchen.rosandroid.widgets.base.BaseEntity;
import com.schneewittchen.rosandroid.widgets.base.BaseNode;

import org.ros.message.MessageListener;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Subscriber;

import sensor_msgs.NavSatFix;

/**
 * TODO: Description
 *
 * @author Nils Rottmann
 * @version 1.0.0
 * @created on 05.05.20
 * @updated on 05.05.20
 * @modified by
 */

public class GpsNode extends BaseNode<WidgetGpsEntity> {


    @Override
    public void onStart(ConnectedNode connectedNode) {
        Subscriber<NavSatFix> subscriber = connectedNode.newSubscriber(
                widget.subPubNoteEntity.topic,
                widget.subPubNoteEntity.messageType
        );

        subscriber.addMessageListener(navSatFix -> {
            GpsData data = new GpsData(navSatFix);
            data.setId(widget.id);
            listener.onNewData(data);
        });
    }

    @Override
    public void onNewData(BaseData data) {
    }

}
