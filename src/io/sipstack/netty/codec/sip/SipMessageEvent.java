/**
 * 
 */
package io.sipstack.netty.codec.sip;

import gov.nist.javax.sip.message.SIPMessage;
import io.netty.channel.ChannelPipeline;

/**
 * Whenever a {@link SipMessage} is received it will be framed and a
 * {@link SipMessageEvent} will be created and passed up through the
 * {@link ChannelPipeline}. The main reason for this object is the need to
 * encapsulate stream based and datagram based connections in Netty 4 (worked
 * differently in Netty 3) as well as to provide a time stamp for when the
 * message was received on the socket (or rather when it was framed)
 * 
 * @author jonas@jonasborjesson.com
 */
public interface SipMessageEvent {

    /**
     * The {@link Connection} over which this {@link SipMessage} was received.
     * 
     * @return
     */
    Connection getConnection();

    /**
     * The framed {@link SipMessage}.
     * 
     * @return
     */
    SIPMessage getMessage();

/**
     * The arrival time of the {@link SipMessage in milliseconds.
     * 
     * @return
     */
    long getArrivalTime();

}
