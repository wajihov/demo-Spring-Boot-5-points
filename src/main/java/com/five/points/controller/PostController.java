package com.five.points.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.five.points.dao.EmployeRepository;
import com.five.points.dao.PostRepository;
import com.five.points.entities.Employe;
import com.five.points.entities.Post;

@RestController
@RequestMapping("/FivePoints")
public class PostController {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private EmployeRepository employeRepository;

	@GetMapping("/posts")
	public List<Post> getAllPost() {
		return postRepository.findAll();
	}

	@PostMapping("/post")
	public Post addPost(@Valid @RequestBody Post post) {
		return postRepository.save(post);
	}

	@GetMapping("/post/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable(name = "id") Long idPost) {
		Post post = postRepository.findById(idPost).get();
		return ResponseEntity.ok().body(post);
	}

	@PutMapping("/post/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable(value = "id") Long idPost,
			@Valid @RequestBody Post postUpdate) {
		Post post = new Post();
		try {
			post = postRepository.findById(idPost).get();
			post.setContent(postUpdate.getContent());
			post.setDatePost(postUpdate.getDatePost());
			postRepository.save(post);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(post);
		}
		return ResponseEntity.ok().body(post);
	}

	@DeleteMapping("/post/{id}")
	public Map<String, Boolean> deletePost(@PathVariable(value = "id") Long idPost) {
		Post post = postRepository.findById(idPost).get();
		postRepository.delete(post);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@GetMapping("/searchPost")
	public List<Post> searchContent(@RequestParam(defaultValue = "") String mc) {
		return postRepository.searchByChar(mc);
	}

	@PutMapping("/postToEmploye/{idPost}/{idEmp}")
	public void affectPostToEmploye(@PathVariable(value = "idPost") Long idPost,
			@PathVariable(value = "idEmp") Long idEmpl) {
		System.out.println("hello");
		Employe employe = employeRepository.findById(idEmpl).get();
		Post post = postRepository.findById(idPost).get();
		System.out.println("id post : " + idPost);
		System.out.println("id employe : " + idEmpl);
		if (employe != null && post != null) {
			System.out.println("Dans if ");
			employe.getPosts().add(post);
			post.setEmploye(employe);
			employeRepository.save(employe);
			postRepository.save(post);
		}
	}

	@PutMapping("/favorite/{idPost}/{idEmp}")
	public void favorite(@PathVariable(value = "idPost") Long idPost, @PathVariable(value = "idEmp") Long idEmpl) {
		Employe employe = employeRepository.findById(idEmpl).get();
		Post post = postRepository.findById(idPost).get();
		System.out.println("employe : " + employe);
		System.out.println("post : " + post);
		System.out.println("get employeFavorite : " + employe.getFavoritePost());
		System.out.println("get postFavorite : " + post.getFavoriteEmpl());
		if (employe != null && post != null) {
			System.out.println("Hello : " + employe.getFavoritePost());
			employe.getFavoritePost().add(post);
			post.getFavoriteEmpl().add(employe);

			employeRepository.save(employe);
			postRepository.save(post);

			System.out.println("get employeFavorite2 : " + employe.getFavoritePost());
			System.out.println("get postFavorite2 : " + post.getFavoriteEmpl());
		}

	}

}
