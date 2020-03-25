package coursepackage.topic;

/*
Business service
Ideally -> singleton services
Services can be injected into many Controller classes

interseting how the topic service is created in the <topic> package
Probably to maintain 1:1 mapping between Controller : Service

 */

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@Service
public class TopicService {

    // Building response (ideally fetch data from DB)
    private List<Topic> topics = new ArrayList<>(Arrays.asList(  // make a new copy of it so that it becoes immutable
            new Topic("spring", "Spring Framework", "Spring description", 3), // I am using the constructor
            new Topic("123", "Ahmed BAdawi", "Software Engineer II", 4),
            new Topic("java", "Python", "Golang", 2)
    ));

    // - Format response as a hashmap -
    public HashMap<String, Topic> getIdHash(List<Topic> topics){
        HashMap<String, Topic> d = new HashMap<>();
        for (int i=0; i<topics.size(); i++){
            String key = topics.get(i).getId();
            Topic val = topics.get(i);
            d.put(key, val);
        }
        return d;
    }

    // returning the response
    public List<Topic> getAllTopics(){
        return topics;
    }

    // utility function to debug topics:
    public void printTopics(List<Topic> topics){
        for (int i=0; i<topics.size(); i++){
            System.out.println("id : " + topics.get(i).getId());
            System.out.println("name : " + topics.get(i).getName());
            System.out.println("description : " + topics.get(i).getDescritpion());
            System.out.println("score : " + topics.get(i).getScore());
            System.out.println(" ");
        }
    }

    // utility function to debug an individual topic
    public  void printTopic(Topic topic) {
        System.out.println(topic.getId() + topic.getName() + topic.getDescritpion() + String.valueOf(topic.getScore()));
    }


    public Double getPercentile(String id){

        // (1) Get topic given id
        HashMap<String, Topic> d = getIdHash(topics);

        // debug the hashmap
        d.entrySet().forEach(entry->{
            System.out.println("{ " + entry.getKey() + " : " + entry.getValue().getName() + " }");
        });

        Topic targetTopic = d.get(id);
        int targetScore = targetTopic.getScore();

        // (2) values less than target topic:
        Double lessThan = 0.0;
        for (int i=0; i<topics.size(); i++){
            if (topics.get(i).getScore() < targetScore) {
                lessThan ++;
            }
        }

        // (3) Percentile formula
        Double p = lessThan/topics.size();

        return p*100;
    }


    public Topic getTopicById(String id){
        for (int i=0; i<topics.size(); i++){
            if (topics.get(i).getId().equals(id)){
                return topics.get(i);
            }
        }
        // not found -> return invalid None topic
        return new Topic("None", "None", "None", -1);
    }

    // POST meth
    public void addTopic(Topic topic){
        topics.add(topic);
    }
}
