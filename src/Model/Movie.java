package Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Movie extends Media {
    public Movie(BigDecimal id, String title, String description, LocalDate premier) {
        super(id, title, description, premier);
    }
}
