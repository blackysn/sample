package Pagination.pagination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Pagination.pagination.Entity.User;
import Pagination.pagination.service.Paginationservice;

@RestController
@RequestMapping("/api-students")
public class PaginationController {
	@Autowired
	private Paginationservice paginationservice;
    
	@GetMapping
	public Page<User>getAllStudents(@RequestParam(defaultValue="0")int page,@RequestParam(defaultValue="5")int size){
		return paginationservice.getallstudents(page, size);
		
	}
	@PostMapping
	public ResponseEntity<User> addstudents(@RequestBody User user) {
		User saveuser=paginationservice.addStudents(user);
		return new ResponseEntity<>(saveuser,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public User updatestudents(@RequestBody User user,@PathVariable Long id) {
		return paginationservice.updatestudents(user, id);
	}
	@DeleteMapping("/{id}")
	public void deletemapping(@PathVariable Long id) {
		 paginationservice.deletestudent(id);
		
	}
}
