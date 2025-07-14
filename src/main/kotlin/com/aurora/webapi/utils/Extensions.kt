import com.aurora.webapi.utils.PageResponse
import org.springframework.data.domain.Page

fun <T> Page<T>.toPageResponse(): PageResponse<T> {
    return PageResponse(
        content = this.content,
        pageNumber = this.number,
        pageSize = this.size,
        totalElements = this.totalElements,
        totalPages = this.totalPages,
        isLast = this.isLast
    )
}
