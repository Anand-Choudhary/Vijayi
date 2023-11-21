package com.example.vijayi.cms.db.model;

import com.example.vijayi.ums.db.model.User;
import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Entity
@Table(name = "vj_comment", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "message")
    private String message;


    @Column(name = "comment_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "user_id")
    private User user;


    @PrePersist
    void beforeCreate() {
        if (this.createdAt == null) {
            this.setCreatedAt(new Date());
        }
    }

}
