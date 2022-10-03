package levvel.io.controller;

import levvel.io.BlogTest;
import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.service.BlogService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.mock;

public class BlogControllerTest extends BlogTest {

    private BlogController blogController;

    private Blog blog;
    private Comment comment;

    @BeforeEach
    void setup() throws IOException {
        BlogService blogService = mock(BlogService.class);

        blogController = new BlogController(blogService);

        blog = getBlogFromResource();
        comment = getCommentFromResource();
    }

    @Test
    void testAddBlog() {
        ResponseEntity<Blog> response = blogController.addBlog(blog);

        Assertions.assertEquals(response.getStatusCodeValue(), 200);
    }

    @Test
    void testGetBlog() {
        ResponseEntity<Blog> response = blogController.getBlog(ID);

        Assertions.assertEquals(response.getStatusCodeValue(), 200);
    }

    @Test
    void testAddComment() {
        ResponseEntity<Comment> response = blogController.addComment(ID, comment);

        Assertions.assertEquals(response.getStatusCodeValue(), 200);
    }

    @Test
    void testGetComment() {
        ResponseEntity<List<Comment>> response = blogController.getComments(ID);

        Assertions.assertEquals(response.getStatusCodeValue(), 200);
    }
}
