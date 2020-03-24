package coursepackage.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService; // depency injection


    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        /*
        creating an array of topic objects and returning it. Because the method is annoted to behave as REST
        it will automatically convert the array into JSON object
         */
        return topicService.getAllTopics();

    }


    // return a single topic
    @RequestMapping("/topic")
    public Topic getTopic(){
        return topicService.getAllTopics().get(1);
    }

    @RequestMapping("/getPercentile/{id}")
    public Double getPercentile(@PathVariable String id){
        return topicService.getPercentile(id);
    }

    @RequestMapping("/getTopicById/{id}")
    public Topic getTopicById(@PathVariable String id){       // ---> I want to pass the id in the URL (?)
        return topicService.getTopicById(id);
    }

    /*
        - same controller class
        - different end point
        - the endpoint uses the same
     */
}
