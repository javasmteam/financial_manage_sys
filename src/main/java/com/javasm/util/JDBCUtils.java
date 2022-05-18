package com.javasm.util;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.SneakyThrows;
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
//
//    private static DruidDataSource druid;
//
//    static {
//        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("Druid.properties");
//        Properties properties = new Properties();
//        druid = new DruidDataSource();
//        try {
//            properties.load(resourceAsStream);
//            druid.configFromPropety(properties);
//            resourceAsStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://124.221.202.55:2396/financial_manage_sys","web_db","4ibmJ7Cxj2Zwf577");
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
    public static <T> Integer insert(String table, T t) {
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
    public static <T> Integer insert(Connection conn, String table, T t) {
        List<Object> params = new ArrayList<>();
        PreparedStatement prst = null;
        ResultSet rs = null;
        int count = 0;
        String sql = "SELECT " + table + ".* FROM " + table + " WHERE FALSE;";

        try {
            //获取表结构
            prst = conn.prepareStatement(sql);
            rs = prst.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
//            拼接sql语句
            String s = JDBCUtils.InsertSql(table, md, params, t);
//            填充sql语句
            Object[] o = params.toArray();
            QueryRunner qr = new QueryRunner();
            count = qr.update(conn, s, o);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
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
     * @return
     * @throws SQLException
     */
    @SneakyThrows
    private static <T> String InsertSql(String table, ResultSetMetaData md, List<Object> fill, T t) throws SQLException, NoSuchMethodException {
        //插入sql语句
        StringBuilder sql1 = new StringBuilder("INSERT INTO " + table + "(");
        //泛型T的Class对象
        Class<?> aClass = t.getClass();
        //保存表的字段名
        List<String> list = new ArrayList<>();

//            遍历表格全部字段
        for (int i = 1; i < md.getColumnCount() + 1; i++) {
            //  反射调用get方法获取Bean类的字段值
            String gmn = getGMN(md.getColumnLabel(i));
            Method method = aClass.getMethod(gmn);
            Object paramObj = method.invoke(t);

            //  若字段值不为空,保存字段和字段值
            if(paramObj!=null){
                list.add(md.getColumnLabel(i));
                fill.add(paramObj);
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
    private static String getGMN(String str) {
        StringBuilder temp = new StringBuilder("get");
        String[] split = str.split("_");
        for (String s : split) {
            temp.append(s.substring(0, 1).toUpperCase());
            temp.append(s.substring(1));
        }
        return temp.toString();
    }

    //获取sql语句
    public static String getSql(String key) {
        String property = null;
        Properties properties = new Properties();
        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("UserBackup.properties");
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
