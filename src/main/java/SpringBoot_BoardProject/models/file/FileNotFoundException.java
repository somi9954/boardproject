package SpringBoot_BoardProject.models.file;

import SpringBoot_BoardProject.commons.Utils;
import SpringBoot_BoardProject.commons.exceptions.CommonException;
import org.springframework.http.HttpStatus;

public class FileNotFoundException extends CommonException {

    public FileNotFoundException() {
        super(Utils.getMessage("NotFound.file", "error"), HttpStatus.NOT_FOUND);
    }
}