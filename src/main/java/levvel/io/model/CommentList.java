package levvel.io.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
public class CommentList {

    @Id
    String blogId;

    List<Comment> comments;

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
