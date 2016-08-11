package com.grameenfoundation.ictc.utils;

/**
 * Created by David on 6/9/2016.
 */

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

public class QueueManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueManager.class);

    public static final String NO_MESSAGE = "no message";

    private static final String QUEUE_NAME = "salesforce";

    private String clientId;
    private Connection connection;
    private Session session;
    private Queue queue;
    private MessageProducer messageProducer;
    private MessageConsumer messageConsumer;
    private String DEFAULT_BROKER_URL = "tcp://localhost:6616";

    public QueueManager() { }

    private void create(String clientId) throws JMSException {
        this.clientId = clientId;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_URL);
        connection = connectionFactory.createConnection();
        connection.setClientID(clientId);
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        queue = session.createQueue(QUEUE_NAME);
    }

    public void createProducer(String clientId) throws JMSException {
        create(clientId);
        messageProducer = session.createProducer(queue);
    }

    public void createConsumer(String clientId) throws JMSException {
        create(clientId);
        messageConsumer = session.createConsumer(queue);
    }

    public void openConnection() throws JMSException {
        connection.start();
    }

    public void closeConnection() throws JMSException {
        connection.close();
    }

    public void setConsumerListener(MessageListener ml) throws JMSException {
        messageConsumer.setMessageListener(ml);
    }


    public void send(String xml) throws JMSException {
        TextMessage textMessage = session.createTextMessage(xml);
        messageProducer.send(textMessage);
        LOGGER.debug(clientId + ": posted '{}'", xml);
    }

    public String get() throws JMSException {

        String payload = NO_MESSAGE;

        Message message = messageConsumer.receive();

        if (message != null) {
            TextMessage textMessage = (TextMessage) message;
            payload = textMessage.getText();
            System.out.println(clientId + ": pulled '{" + payload + "}'");
        } else {
            System.out.println(clientId + ": no data received");
        }

        return payload;
    }
}
