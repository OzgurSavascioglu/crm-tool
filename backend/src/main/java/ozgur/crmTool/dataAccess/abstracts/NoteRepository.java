package ozgur.crmTool.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ozgur.crmTool.entities.concretes.Note;

import java.util.List;

/**
 * Repository interface for managing Note entities.
 *
 * Extends JpaRepository, which provides built-in CRUD methods.
 * Additional custom queries for Note can be defined here.
 */
public interface NoteRepository extends JpaRepository<Note,Integer> {

    /**
     * Retrieves all notes that are marked as active.
     *
     * @return List of active notes
     */
    @Query("SELECT n FROM Note n WHERE n.isActive= true")
    List<Note> findAllActive();
}
