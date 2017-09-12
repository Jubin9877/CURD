package com.example.CURD.TopicController.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.CURD.TopicController.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseservice;
 
	@RequestMapping("/topics/{id}/courses")
	public List<Course>getallCourses(@PathVariable String id) {
		return courseservice.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getTop(@PathVariable String id) {
		return courseservice.getCourse(id);
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses" ,method= RequestMethod.POST)
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseservice.addCourse(course);
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses/{id}" ,method= RequestMethod.PUT)
	public void updateCourse(@RequestBody Course course,@PathVariable String topicId,@PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		courseservice.updateCourse(course);
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses/{id}" ,method= RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id) {
		courseservice.deleteCourse(id);
	}
}
