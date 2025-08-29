package ozgur.crmTool.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ozgur.crmTool.entities.concretes.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
