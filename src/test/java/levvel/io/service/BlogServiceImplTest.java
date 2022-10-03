package levvel.io.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import levvel.io.BlogTest;
import levvel.io.data.BlogRepository;
import levvel.io.data.CommentRepository;
import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.model.CommentList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Optional.ofNullable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BlogServiceImplTest extends BlogTest {

    private BlogService blogService;

    private BlogRepository blogRepository;
    private CommentRepository commentRepository;

    private Blog blog;
    private Comment comment;
    private CommentList commentList;

    @BeforeEach
    void setup() throws IOException {
        blogRepository = mock(BlogRepository.class);
        commentRepository = mock(CommentRepository.class);

        blogService = new BlogServiceImpl(blogRepository, commentRepository);

        blog = getBlogFromResource();
        comment = getCommentFromResource();

        commentList = new CommentList(blog.getId(), new ArrayList<>());
    }

    @Test
    void testAddBlog() {
        blogService.addBlog(blog);

        verify(blogRepository).save(any());
        verify(commentRepository).save(any());
    }

    @Test
    void testGetBlog() {
        when(blogRepository.findById(any())).thenReturn(ofNullable(blog));

        Blog returnedBlog = blogService.getBlog(ID);

        verify(blogRepository).findById(ID);

        Assertions.assertEquals(blog, returnedBlog);
    }

    @Test
    void testAddComment() {
        when(commentRepository.findById(any())).thenReturn(ofNullable(commentList));

        blogService.addComment(ID, comment);

        verify(commentRepository).findById(any());
        verify(commentRepository).save(any());
    }

    @Test
    void testGetComments() {
        when(commentRepository.findById(any())).thenReturn(ofNullable(commentList));

        List<Comment> comments = blogService.getComments(ID);

        verify(commentRepository).findById(any());

        Assertions.assertEquals(comments, commentList.getComments());
    }
}
