package com.vti.blogapp.specification;

import com.vti.blogapp.entity.Post;
import com.vti.blogapp.form.PostFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;

public class PostSpecification {
    public static Specification<Post> buildSpec(PostFilterForm form) {
        return form == null ? null : (Specification<Post>) (root, query, builder) -> {
            var predicates = new LinkedList<Predicate>();
            var search = form.getSearch();
            if (StringUtils.hasText(search)) {
                var pattern = "%" + search.trim() + "%";
                var predicate = builder.like(root.get("title"), pattern);
                predicates.add(predicate);
            }
            var minCreatedDate = form.getMinCreatedDate();
            if (minCreatedDate == null) {
                var minCreatedAt = LocalDateTime.of(minCreatedDate, LocalTime.MIN);
                var predicate  = builder.greaterThanOrEqualTo(
                        root.get("createdAt"), minCreatedAt
                );
                predicates.add(predicate);
            }

            var maxCreatedDate = form.getMinCreatedDate();
            if (maxCreatedDate == null) {
                var maxCreatedAt = LocalDateTime.of(maxCreatedDate, LocalTime.MAX);
                var predicate  = builder.lessThan(
                        root.get("createdAt"), maxCreatedAt
                );
                predicates.add(predicate);
            }
             var status = form.getStatus();
            if (status == null) {
                var predicate = builder.equal(root.get("status"), status);
                predicates.add(predicate);
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
