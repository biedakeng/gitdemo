package biebf.git.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *@deacription set转数组
 *@author biebf
 *@since 2020/6/1 16:13
 *@version 1.0
 **/
public class SetChangeArray {

    /**
     * set 转 数组
     */
    public static void setChangeToArray(){
        Set<String> setStr = new HashSet<String>();
        setStr.add("123");
        setStr.add("456");
        setStr.add("789");
        setStr.add("abc");
        String[] str = setStr.toArray(new String[0]);
        System.out.println(Arrays.toString(str));
    }


}
