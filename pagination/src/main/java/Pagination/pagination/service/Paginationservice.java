package Pagination.pagination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import Pagination.pagination.Entity.User;
import Pagination.pagination.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
public class Paginationservice {

	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private EntityManager entitymanager;
	
	public Page<User>getallstudents(int page,int size){
		Pageable pageable=PageRequest.of(page, size);
		return userrepository.findAll(pageable);
		
	}
	public User addStudents(User user) {
		System.out.println("Updating user with id: " + user.getId());
	    System.out.println("New Name: " + user.getName());
	    System.out.println("New Email: " + user.getEmail());
		return userrepository.save(user);
	}
	public User updatestudents(User user,Long id) {
		User user1 =userrepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
		
		if(user.getName()!=null) {
			user1.setName(user.getName());
		}
		if(user.getEmail()!=null) {
			user1.setEmail(user.getEmail());
		}
		return userrepository.save(user1);
		
		
	}
	public void deletestudent(Long id) {
		if(!userrepository.existsById(id)) {
			throw new RuntimeException("not found the id"+id);
		}
		userrepository.deleteById(id);
	}
}
