package tech.echoing.bigdata.util;

import java.util.List;

public class ArrayUtil {

    private ArrayUtil() {
    }

    /**
     * List不为空，且至少有一条记录
     *
     * @param list
     * @return
     */
    public static boolean isNotEmpty(List<?> list) {
        return !isEmpty(list);
    }

    /**
     * List为空，或list里面没有任何记录
     *
     * @param list
     * @return
     */
    public static boolean isEmpty(List<?> list) {
        boolean flag = false;
        if (list == null || list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    /**
     * toString --> [1,2,3,4]
     *
     * @param a
     * @return
     */
    public static String toString(Object[] a) {
        if (a == null) {
            return "null";
        }

        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(String.valueOf(a[i]));
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(",");
        }
    }
}
