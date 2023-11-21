package com.example.vijayi.ums.db.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "vj_user", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "comment_from")
    private String commentFrom;

    @NonNull
    @Column(name = "comment_to")
    private String commentTo;

    public User(Long id)
    {
        this.id=id;
    }
}
