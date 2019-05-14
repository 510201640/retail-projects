package com.jiang.redis.concurrent;

import com.googlecode.aviator.AviatorEvaluator;
import org.junit.Test;

/**
 * Description:
 *
 * @author jiujiang
 * @date 2019/5/10
 */
public class AviatorTest {


    @Test
    public void test(){
        Long result = (Long) AviatorEvaluator.execute("print('hello world'); 1+2+3 ; 100-1");
        System.err.println(result);

    }

}
