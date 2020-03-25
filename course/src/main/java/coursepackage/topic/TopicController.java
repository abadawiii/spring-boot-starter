package coursepackage.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    // NEW CHALLENGE -- POST request to add a topic to list of topics - given parameters
    @RequestMapping(method = RequestMethod.POST, value = "/addTopic") // by default, mapping is a GET
    public void addTopic(@RequestBody Topic topic){ // request payload will contain a JOSN representation
        // JSON representation will be automatically converted into an instance or object
        // And that object will be passed on to the method to post
        // POST body to Topic object and then add that to list of topics

        /*
        Now the real question is where does spring-boot fetch the payload from?

        since this is a POST request, we are gonna need to use POSTMAN (browser can't do it)


        {
	        "id": "999",
	        "name":"Arabic",
	        "description": "Modern standard Arabic",
	        "score": 45
        }

        JOSN rep --> addTopic Controller ---> create an object out of it

        my question no is how do we pass a huge pay load like that in real life situation (no postman)
         */

        topicService.addTopic(topic);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/updateTopic/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(topic, id);
    }


}
