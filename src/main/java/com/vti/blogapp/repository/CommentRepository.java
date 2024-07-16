package com.vti.blogapp.repository;

import com.vti.blogapp.dto.CommentDto;
import com.vti.blogapp.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository  extends JpaRepository<Comment, Long> {
    //1. Method name
    //tiền tố: findBy, ExistsBy, countBy, deleteBy
    // VD: lấy ra tất cả comment theo name
    List<Comment> findByName(String name);

    //VD: lây ra tất cả cmt có body chứa "search"
    List<Comment> findByNameContaining(String search);
    // VD: Lấy ra tất cả comment theo name hoặc email
    List<Comment> findByNameOrEmail(String name, String email);
    // VD: Lấy ra tất cả comment theo post id
    Page<Comment> findByPostId(Long postId, Pageable pageable);

    // 2. @Query
    @Modifying
    @Query("DELETE FROM Comment WHERE email = :email")
    void deleteByEmail(@Param("email") String email) ;

    @Modifying
    @Query("DELETE FROM Comment WHERE name = ?1 AND email = ?2")
    void deleteByName(String name, String email);

    @Query(value = "SELECT * FORM comment WHERE id >?1", nativeQuery = true)
    Page<CommentDto> findByGreaterThan(Long id, Pageable pageable) ;

}
