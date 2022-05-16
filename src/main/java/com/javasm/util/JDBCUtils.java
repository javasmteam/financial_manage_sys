package com.javasm.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author: 云勇
 * @date: 2022/5/9 17:28
 * @description:
 */


public class JDBCUtils {

    private static DruidDataSource druid;
    static {
        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("Druid.properties");
        Properties properties = new Properties();
        druid = new DruidDataSource();
        try {
            properties.load(resourceAsStream);
            druid.configFromPropety(properties);
            resourceAsStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = druid.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //    更新数据 -- 非事务
    public static int update(String sql, Object... o) {
        Connection conn = getConn();
        int i = update(conn, sql, o);
        DbUtils.closeQuietly(conn);
        return i;
    }

    //    更新数据 -- 事务
    public static int update(Connection conn, String sql, Object... o) {
        int s = -1;
        PreparedStatement psmt = null;
        try {
            psmt = conn.prepareStatement(sql);
            for (int i = 0; i < o.length; i++) {
                psmt.setObject((i + 1), o[i]);
            }
            s = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(psmt);
        }
        return s;
    }

    //    查询 -- 事务
    public static <T> List<T> query(Connection conn, String sql, Class<T> clazz, Object... o) {
        ResultSet rst = null;
        ResultSetMetaData rsmd = null;
        PreparedStatement psmt = null;
        List<T> list = new ArrayList<>();

        try {
            psmt = conn.prepareStatement(sql);
            for (int i = 0; i < o.length; i++) {
                psmt.setObject((i + 1), o[i]);
            }
            rst = psmt.executeQuery();
            rsmd = rst.getMetaData();

            while (rst.next()) {
                T t = clazz.newInstance();
                for (int j = 0; j < rsmd.getColumnCount(); j++) {
                    String columnClassName = rsmd.getColumnClassName(j + 1);
                    String columnLabel = rsmd.getColumnLabel(j + 1);
                    String methodName = getMethod(columnLabel);
                    Method method = clazz.getMethod(methodName, getClass(columnClassName));
                    Object value = rst.getObject(columnLabel);
                    method.invoke(t, value);
                }
                list.add(t);
            }

        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(rst);
            DbUtils.closeQuietly(psmt);
        }
        return list;
    }

    //    查询 -- 非事务
    public static <T> List<T> query(String sql, Class<T> clazz, Object... o) {
        Connection conn = getConn();
        List<T> list = query(conn, sql, clazz, o);
        DbUtils.closeQuietly(conn);
        return list;
    }

    //    查询单个 -- 事务
    public static <T> T find(Connection conn, String sql, Class<T> clazz, Object... o) {
        List<T> list = query(conn, sql, clazz, o);
        if (list.size() < 1) {
            return null;
        } else {
            return list.get(0);
        }
    }

    //   添加数据 -- 事务
    public static Integer add(Connection conn, String sql, Object... o) {
        QueryRunner queryRunner = new QueryRunner();
        Integer i = null;
        try {
            //  ResultHandler : 定义数据以什么方式, 什么类型返回
            i = queryRunner.insert(conn, sql, new ScalarHandler<Long>(), o).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    //  添加数据 -- 非事务
    public static Integer add(String sql, Object... o) {
        Connection conn = getConn();
        Integer i = add(conn, sql, o);
        DbUtils.closeQuietly(conn);
        return i;
    }

    //   查询单个 -- 非事务
    public static <T> T find(String sql, Class<T> clazz, Object... o) {
        List<T> list = query(sql, clazz, o);
        if (list.size() < 1) {
            return null;
        } else {
            return list.get(0);
        }
    }

    //  查询数据库数据条数 -- 事务
    public static Integer size(Connection conn, String sql) {
        QueryRunner queryRunner = new QueryRunner();
        Integer i = null;
        try {
            i = queryRunner.query(conn, sql, new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    // 查询数据库数据条数 -- 非事务
    public static Integer size(String sql) {
        Connection conn = getConn();
        Integer i = size(conn, sql);
        DbUtils.closeQuietly(conn);
        return i;
    }

    //获取set方法名
    private static String getMethod(String s) {
        StringBuilder sb = new StringBuilder("set");
        String[] ss = s.split("_");
        for (String s1 : ss) {
            sb.append(s1.substring(0, 1).toUpperCase());
            sb.append(s1.substring(1));
        }
        return sb.toString();
    }

    //获取数据库数据类型
    private static Class getClass(String s) {
        if (s.equals("java.sql.Date") || s.equals("java.sql.Timestamp")) {
            s = "java.util.Date";
        }
        Class clazz = null;
        try {
            clazz = Class.forName(s);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    /**
     * 将对象t添加到table表中 --非事务
     *
     * @param table
     * @param t
     * @param <T>
     * @return
     */
    public <T> Integer insert(String table, T t) {
        Connection conn = JDBCUtils.getConn();
        Integer o = insert(conn, table, t);
        DbUtils.closeQuietly(conn);
        return o;

    }

    /**
     * 将对象t添加到table表中--事务
     *
     * @param conn
     * @param table
     * @param t
     * @param <T>
     * @return
     */
    public <T> Integer insert(Connection conn, String table, T t) {
        List<String> list = new ArrayList<>();
        PreparedStatement prst = null;
        ResultSet rs = null;
        int count = 0;
        String sql = "SELECT " + table + ".* FROM " + table + " WHERE FALSE;";

        try {

            prst = conn.prepareStatement(sql);
            rs = prst.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
//            拼接sql语句
            String s = JDBCUtils.InsertSql(table, md, list);
//            获取对象t中的属性值
            List<Object> fill = new ArrayList<>();
            JDBCUtils.fillObject(fill, list, t);
//            填充sql语句
            Object[] o = fill.toArray();
            QueryRunner qr = new QueryRunner();
            count = qr.update(conn, s, o);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(prst);
            DbUtils.closeQuietly(rs);
        }
        return count;
    }

    /**
     * 拼接插入sql语句
     *
     * @param table
     * @param md
     * @param list
     * @return
     * @throws SQLException
     */
    public static String InsertSql(String table, ResultSetMetaData md, List<String> list) throws SQLException {
        StringBuilder sql1 = new StringBuilder("INSERT INTO " + table + "(");
//            获取全部字段名,拼接插入的sql语句
        for (int i = 1; i < md.getColumnCount() + 1; i++) {
            if (!md.isAutoIncrement(i)) {
                list.add(md.getColumnName(i));
            }
        }
//            拼接sql语句中的字段需填充的字段名
        for (int i = 0; i < list.size(); i++) {
            sql1.append(list.get(i));
            if (i < list.size() - 1) {
                sql1.append(",");
            }
        }
//            拼接sql语句中的占位符
        sql1.append(") VALUES(");
        for (int i = 0; i < list.size(); i++) {
            sql1.append("?");
            if (i < list.size() - 1) {
                sql1.append(",");
            }
        }
//            拼接sql语句);
        sql1.append(");");
        return sql1.toString();
    }

    /**
     * 拼接get方法
     *
     * @param str
     * @return
     */
    public static String getGMN(String str) {
        StringBuilder temp = new StringBuilder("get");
        String[] split = str.split("_");
        for (String s : split) {
            temp.append(s.substring(0, 1).toUpperCase());
            temp.append(s.substring(1));
        }
        return temp.toString();
    }

    /**
     * 获取对象t的属性值
     *
     * @param fill
     * @param list
     * @param t
     * @param <T>
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static <T> void fillObject(List<Object> fill, List<String> list, T t) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = t.getClass();
        for (int i = 0; i < list.size(); i++) {
            String gmn = getGMN(list.get(i));
            Method method = aClass.getMethod(gmn);
            fill.add(method.invoke(t));

        }
    }

    //获取sql语句
    public static String getSql(String key) {
        String property = null;
        Properties properties = new Properties();
        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("sql.properties");
        try {
            properties.load(resourceAsStream);
            property = properties.getProperty(key);
            resourceAsStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                resourceAsStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return property;
    }
}
