package levvel.io;

import levvel.io.controller.BlogController;
import levvel.io.data.BlogRepository;
import levvel.io.data.CommentRepository;
import levvel.io.service.BlogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class WorkSampleApplicationTests {

	@Autowired
	private BlogController blogController;

	@Autowired
	private BlogService blogService;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Test
	public void contextLoads() {
		assert(blogController != null);
		assert(blogService != null);
		assert(blogRepository != null);
		assert(commentRepository != null);
	}
}
