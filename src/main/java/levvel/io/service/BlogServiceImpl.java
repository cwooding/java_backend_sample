package levvel.io.service;

import levvel.io.data.BlogRepository;
import levvel.io.data.CommentRepository;
import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.model.CommentList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;
    private CommentRepository commentRepository;

    @Override
    public void addBlog(Blog blog) {
        // Save the blog
        blogRepository.save(blog);

        // Create a comment section for this Blog
        CommentList commentList = new CommentList(blog.getId(), new ArrayList<>());
        commentRepository.save(commentList);
    }

    @Override
    public Blog getBlog(String id) {
        // Get the blog from the id
        return blogRepository.findById(id).orElseGet(null);
    }

    @Override
    public List<Blog> getBlogs() {
        // Function to get all blogs, useful for debugging
        return blogRepository.findAll();
    }

    @Override
    public void addComment(String id, Comment comment) {
        // Get current comment list for this blog and append comment to it
        CommentList commentList = commentRepository.findById(id).orElseGet(null);
        commentList.addComment(comment);
        commentRepository.save(commentList);
    }

    @Override
    public List<Comment> getComments(String id) {
        // Get the object and extract the list of comments
        CommentList commentList = commentRepository.findById(id).orElseGet(null);
        return commentList.getComments();
    }
}
