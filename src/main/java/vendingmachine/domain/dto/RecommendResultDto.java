package vendingmachine.domain.dto;

import java.util.List;

public record RecommendResultDto(String categories,List<String> results) {
}