package SpringBoot_BoardProject.models.board.config;


import SpringBoot_BoardProject.commons.Utils;
import SpringBoot_BoardProject.commons.exceptions.AlertBackException;
import org.springframework.http.HttpStatus;

public class BoardNotFoundException extends AlertBackException {
    public BoardNotFoundException() {
        super(Utils.getMessage("NotFound.board", "error"));
        setStatus(HttpStatus.NOT_FOUND);
    }
}