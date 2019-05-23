package domain;

import java.util.ArrayList;

public class Topic {
    private String topic;
    private ArrayList<Reply> comments;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    private int topicId;

    public Topic(String topic, int topicId) {
        setTopic(topic);
        setComments(new ArrayList<Reply>());
        setTopicId(topicId);

    }

    public void addReply(Reply reply) {
        comments.add(reply);
    }

    public ArrayList<Reply> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Reply> comments) {
        this.comments = comments;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }


}
