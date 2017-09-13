package com.example.CURD.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

//	private List<Course> topics = new ArrayList<>(Arrays.asList(
//			new Course("spring","Spring Framework","Spring Freamework Description"),
//			new Course("java","java","java Description"),
//			new Course("Javascript","Javascript","Javascript Description")
//			));
	
	public List<Course> getAllCourses(String topicId){
		//return topics;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses :: add);
		return courses;
	}
	
	public Course getCourse(String id)
	{
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}

	public void updateCourse(Course course) {
		
		courseRepository.save(course);
//		for(int i=0; i < topics.size(); i++ ) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i,topic);
//				return; 
//			}
//		}
//		
	}

	public void deleteCourse(String id) {
		//topics.removeIf(t->t.getId().equals(id));
		courseRepository.delete(id);
	}
}
