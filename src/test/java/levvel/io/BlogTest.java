package levvel.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import levvel.io.model.Blog;
import levvel.io.model.Comment;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public abstract class BlogTest {

    protected static final String ID = "fake_id";

    protected Blog getBlogFromResource() throws IOException {
        File file = new File(
                Objects.requireNonNull(this.getClass().getClassLoader().getResource("addBlog.json")).getFile()
        );

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(file, Blog.class);
    }

    protected Comment getCommentFromResource() throws IOException {
        File file = new File(
                Objects.requireNonNull(this.getClass().getClassLoader().getResource("addComment.json")).getFile()
        );

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(file, Comment.class);
    }
}
