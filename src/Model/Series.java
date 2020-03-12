package Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Series extends Media {
    public Series(BigDecimal id, String title, String description, LocalDate premier) {
        super(id, title, description, premier);
    }
}
