import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @Description: TODO
 * @Author: LiYao
 * @CreateTime: 2022-09-22 14:44
 */
public class test {


    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
        LocalDateTime end = LocalDateTime.now();
        System.out.println(Duration.between(now, end).toMillis());
    }

    @Test
    public void test() {
        LocalDateTime now = LocalDateTime.now();
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
        LocalDateTime end = LocalDateTime.now();
        System.out.println(Duration.between(now, end).toMillis());
    }

}
