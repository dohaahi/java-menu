package menu.view;

import org.junit.jupiter.api.Test;

class OutputViewTest {
    @Test
    void fn() {
        // """ 는 띄어쓰기 안해도 됨
        System.out.printf("""
                        당첨 통계
                        ---
                        3개 일치 (5,000원) - %d개
                        4개 일치 (50,000원) - %d개
                        5개 일치 (1,500,000원) - %d개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                        6개 일치 (2,000,000,000원) - %d개
                        총 수익률은 %f%%입니다.
                        %,d원
                        %,.2f
                        """.stripIndent(), // trim()도 가능
                1, 2, 3, 4, 5, 110.0, -123456783, -123022.3200000);
    }
}