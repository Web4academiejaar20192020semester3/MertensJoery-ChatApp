package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Conversation {
    @JsonIgnore
    public Person person1;
    @JsonIgnore
    public Person person2;
    @JsonIgnore
    public ArrayList<Message> messages = new ArrayList<>();

    public Conversation() {
    }

    public Conversation(Person person1, Person person2) {
        this.person1 = person1;
        this.person2 = person2;
        //this.addMessage(new Message("lololol",person1));
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public boolean contains(Person person) {
        if (person1 == person || person2 == person) {
            return true;
        }
        return false;
    }

    public Person getOtherChatter(Person person) {
        if (person1== person) return person2;
        return person1;
    }
}
