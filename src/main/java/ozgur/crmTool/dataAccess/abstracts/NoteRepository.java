package ozgur.crmTool.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ozgur.crmTool.entities.concretes.Note;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Integer> {
    @Query("SELECT n FROM Note n WHERE n.isActive= true")
    List<Note> findAllActive();
}
