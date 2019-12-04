package com.five.points.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.five.points.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	@Query("Select p from Post p where p.content like %:x% ")
	public List<Post> searchByChar(@Param("x") String mc);

}
