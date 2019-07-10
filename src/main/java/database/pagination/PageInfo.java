package database.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageInfo {
    private int numberOfPages;
    private int pageNumber;
    private int dataPerPage;
}
