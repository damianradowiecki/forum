package pl.dr.forum.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
public class Topic {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    public Topic(String name){
        this.name = name;
        this.comments = new ArrayList<>();
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    public void addComment(String comment){
        this.comments.add(new Comment(comment));
    }

    public List<Comment> getComments() {
        return this.comments;
    }
}
