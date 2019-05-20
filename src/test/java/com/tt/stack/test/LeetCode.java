package com.tt.stack.test;

import java.util.Arrays;

public class LeetCode {

    public boolean isRobotBounded(String instructions) {

        int[] index = {0,0};
        int jiaodu = 0;

        char[] str = instructions.toCharArray();
        for (int i = 0;i<str.length;i++){
            switch (str[i]){
                case 'G':index=go(index,jiaodu);break;
                case 'L': jiaodu=less(jiaodu);break;
                case 'R': jiaodu=add(jiaodu);break;
            }
        }

        if(index[1]>0 && jiaodu == 0 && index[0]==0){
           return false;
        }else
            return true;
    }

    private int add(int jiaodu) {
        if (jiaodu==270)
            jiaodu = 0;
        else
            jiaodu+=90;
        return jiaodu;
    }

    private int less(int jiaodu) {
        if (jiaodu == 0)
            jiaodu = 270;
        else
            jiaodu-=90;
        return jiaodu;
    }


    private int[] go(int[] index,int jiaodu) {
        switch (jiaodu){
            case 0:index[1]++;break;
            case 90:index[0]++;break;
            case 180:index[1]--;break;
            case 270:index[0]--;break;
        }
        return index;
    }


}

