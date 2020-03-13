package com.gatesma.kafkalearn;



import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright (C), 2020
 * FileName: testAPI
 * Author:   Marlon
 * Email: gatesma@foxmail.com
 * Date:     2020/3/13 14:43
 * Description:
 */
public class testAPI {
    
    
    @Test
    public void test01() {
        Pattern pattern = Pattern.compile("heima*");
        Matcher m = pattern.matcher("heima-hduahdu");
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
        } else {
            System.out.println("NO MATCH");
        }
    }
    
}
