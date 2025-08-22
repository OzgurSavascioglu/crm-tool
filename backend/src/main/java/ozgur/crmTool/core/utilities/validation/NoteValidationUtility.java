package ozgur.crmTool.core.utilities.validation;
import ozgur.crmTool.business.requests.note.CreateNoteRequest;
import ozgur.crmTool.business.requests.note.UpdateNoteRequest;
import ozgur.crmTool.core.utilities.exception.BusinessException;


/**
 * Utility class for validating Note-related requests.
 * Contains static methods to ensure that certain fields
 * (like author name length) follow defined business rules.
 */
public class NoteValidationUtility {
    // Maximum allowed length for the "author" field in a note
    private static final int MAX_AUTHOR_LENGTH=100;

    /**
     * Validates that the author name does not exceed the maximum length.
     *
     * @param author The author's name to validate
     * @throws BusinessException if the author name is too long
     */
    private static void validateAuthor(String author) throws BusinessException {
        if(author.length() > MAX_AUTHOR_LENGTH)
            throw new BusinessException("Author length is too long");
    }

    /**
     * Validates fields when creating a new note.
     * Currently checks author field length.
     *
     * @param noteRequest The create note request object
     * @throws BusinessException if validation rules are violated
     */
    public static void validateCreateNote(CreateNoteRequest noteRequest) throws BusinessException {
        validateAuthor(noteRequest.getAuthor());
    }

    /**
     * Validates fields when updating an existing note.
     * Currently checks author field length.
     *
     * @param noteRequest The update note request object
     * @throws BusinessException if validation rules are violated
     */
    public static void validateUpdateNote(UpdateNoteRequest noteRequest) throws BusinessException {
        validateAuthor(noteRequest.getAuthor());
    }
}
