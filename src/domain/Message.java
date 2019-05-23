package domain;

public class Message {
    public String message;
    public Person sender;
    public Message(String message, Person sender){
        this.message=message;
        this.sender=sender;
    }
}
