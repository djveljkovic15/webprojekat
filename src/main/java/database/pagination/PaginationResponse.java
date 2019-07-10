package database.pagination;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaginationResponse<T> {
    private T response;
    private PageInfo pageInfo;
}
