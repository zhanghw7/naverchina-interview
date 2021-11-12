package com.zhw.interview.naverchina.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description test problem 1
 * @Author Zhang Hongwei
 * @Date 2021/11/12 9:49
 */
class Problem1Test {

    @Test
    void topologicalSortTest() {
        Problem1.Task f = new Problem1.Task('F');
        Problem1.Task d = new Problem1.Task('D');
        Problem1.Task a = new Problem1.Task('A', Collections.singletonList(d));
        Problem1.Task c = new Problem1.Task('C', Collections.singletonList(a));
        Problem1.Task h = new Problem1.Task('H', Collections.singletonList(c));
        Problem1.Task e = new Problem1.Task('E', Collections.singletonList(f));
        Problem1.Task g = new Problem1.Task('G', Arrays.asList(a, e));
        Problem1.Task b = new Problem1.Task('B', Arrays.asList(e, g));

        Problem1 problem1 = new Problem1();
        problem1.topologicalSort(Arrays.asList(b, h));
    }
}