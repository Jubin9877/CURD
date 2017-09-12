package com.example.CURD.TopicController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicrepository;

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring","Spring Framework","Spring Freamework Description"),
			new Topic("java","java","java Description"),
			new Topic("Javascript","Javascript","Javascript Description")
			));
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topics = (List<Topic>) topicrepository.findAll();
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicrepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		topicrepository.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		
		topicrepository.save(topic);
//		for(int i=0; i < topics.size(); i++ ) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i,topic);
//				return; 
//			}
//		}
//		
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t->t.getId().equals(id));
		topicrepository.delete(id);
	}
}
