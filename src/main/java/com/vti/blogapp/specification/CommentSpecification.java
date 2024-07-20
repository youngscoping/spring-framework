package com.vti.blogapp.specification;

import com.vti.blogapp.entity.Comment;
import com.vti.blogapp.form.CommentFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.LinkedList;

public class CommentSpecification {
    public static Specification<Comment> buildSpec(CommentFilterForm form) {
        return form == null ? null : (Specification<Comment>) (root, query, builder) -> {
            var predicates = new LinkedList<Predicate>();

            var search = form.getSearch();
            if (StringUtils.hasText(search)) {
                var pattern = "%" + search.trim() + "%";
                var hasNameLike = builder.like(root.get("name"), pattern);
                var hasEmailLike = builder.like(root.get("email"), pattern);
                var predicate = builder.or(hasNameLike, hasEmailLike);
                predicates.add(predicate);
            }
            var postId = form.getPostId();
            if (postId != null) {
                var predicate = builder.equal(root.get("post").get("id"), postId);
                predicates.add(predicate);
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        } ;
    }
}
