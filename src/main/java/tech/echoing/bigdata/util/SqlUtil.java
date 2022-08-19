package tech.echoing.bigdata.util;

public class SqlUtil {

    private final static String SQL_LIMIT = " LIMIT ";

    /**
     * 最大返回500行
     *
     * @param sql
     * @return
     */
    public static String limit500(String sql) {
        if (!sql.contains(SQL_LIMIT)) {
            sql = sql.replace(";", "");
            sql += SQL_LIMIT + " 500 ";
        }
        return sql;
    }
}