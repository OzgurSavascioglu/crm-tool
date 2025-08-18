package ozgur.crmTool.core.utilities.validation;
import ozgur.crmTool.business.requests.note.CreateNoteRequest;
import ozgur.crmTool.business.requests.note.UpdateNoteRequest;
import ozgur.crmTool.core.utilities.exception.BusinessException;

public class NoteValidationUtility {
    private static final int MAX_AUTHOR_LENGTH=100;

    private static void validateAuthor(String author) throws BusinessException {
        if(author.length() > MAX_AUTHOR_LENGTH)
            throw new BusinessException("Author length is too long");
    }

    public static void validateCreateNote(CreateNoteRequest noteRequest) throws BusinessException {
        validateAuthor(noteRequest.getAuthor());
    }

    public static void validateUpdateNote(UpdateNoteRequest noteRequest) throws BusinessException {
        validateAuthor(noteRequest.getAuthor());
    }
}
