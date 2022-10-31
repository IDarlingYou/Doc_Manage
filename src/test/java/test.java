import cn.hutool.core.lang.Snowflake;
import cn.hutool.json.JSONArray;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @Description: TODO
 * @Author: LiYao
 * @CreateTime: 2022-09-22 14:44
 */
public class test {

    private Snowflake snowflake;


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
        long id = snowflake.nextId();
        System.out.println(id);
    }

    @Test
    public void test0() {
        String numberGather = "135,146,666,666";
        String[] strings = numberGather.split(",");

        JSONArray array = new JSONArray();
        for (String s : strings) {
            array.add(s);
        }


        System.out.println(array);


    }

}
