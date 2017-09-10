package spock

/**
 * @author chanwook
 */
class Publisher {

    List<Subscriber> subscribers = []

    int messageCount = 0

    void send(String message) {
        subscribers*.receive(message)
        messageCount++
    }
}
