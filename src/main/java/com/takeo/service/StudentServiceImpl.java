package com.takeo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takeo.model.Student;
import com.takeo.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository stuRepo;
	
	
	
	@Override
	public int saveStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println(stuRepo);
		Student saveEnt = stuRepo.save(student);
		
		if(saveEnt!=null)
			return 1;
		else
		return 0;
	}

}
