package com.newbegin.project.newbegin.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Напишите 'Привет!', для начала...")
    @Length(max = 256, message = "Слишком длинное сообщение, может разбить на два?")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @Temporal(TemporalType.DATE)
    private Date postedAt = new Date();

    @Temporal(TemporalType.TIME)
    private Date postedAtTime = new Date();


    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "post",
            orphanRemoval = true)
    private List<Tag> tagList = new ArrayList<>();

    public void addTag(Tag tag) {
        tagList.add(tag);
        tag.setPost(this);
    }

    private String filename;

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public Post(String text, User user) {
        this.author = user;
        this.text = text;
    }
}
