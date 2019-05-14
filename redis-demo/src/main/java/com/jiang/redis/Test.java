package com.jiang.redis;

import com.jiang.redis.util.UUIDHexGenerator;

/**
 * Description:
 *
 * @author jiujiang
 * @date 2019/5/9
 */

public class Test {

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            String generate = UUIDHexGenerator.generate();
            System.out.println(generate);
        }

    }

}
