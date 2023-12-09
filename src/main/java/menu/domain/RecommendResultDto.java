package menu.domain;

import java.util.List;

public record RecommendResultDto(String categories, List<String> recommendResults) {
}
