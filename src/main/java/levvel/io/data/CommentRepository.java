package levvel.io.data;

import levvel.io.model.CommentList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<CommentList, String> {
}
