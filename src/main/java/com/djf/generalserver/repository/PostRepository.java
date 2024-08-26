package com.djf.generalserver.repository;

import com.djf.generalserver.model.Post;
import com.djf.generalserver.model.PostRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
