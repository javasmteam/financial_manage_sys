package com.javasm.util;

import cn.hutool.core.lang.ConsoleTable;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.jetbrains.annotations.NotNull;

import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author Zhao YuanMing
 * @Date 2022/4/6 3:47
 * @Version 1.0
 */
public class JDBCUtils {

    private static DataSource ds;
//    private static DruidDataSource ds;

    static {
        try {
            //1.加载配置文件
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("Druid.properties"));
            //2.获取dataSource
//            ds = new DataSource;
//            ds.configFromProperty(pro);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt, Connection conn) {
        close(null, stmt, conn);
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取数据库连接池
     *
     * @return
     */
    public static DataSource getDataSource() {
        return ds;
    }


    /**
     * 增删改执行sql语句
     *
     * @param sql    增删改语句
     * @param params 可变参数
     * @return 影响的行数，失败则返回0
     */
    public static int update(String sql, Object... params) {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = getConnection();
        try {
            return queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(connection);
        }
        return 0;
    }

    /**
     * 修改：同一个事务下
     *
     * @param connection
     * @param sql
     * @param params
     * @return 返回受影响行数
     */
    public static int update(Connection connection, String sql, Object... params) {
        QueryRunner queryRunner = new QueryRunner();
        try {
            return queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * 新增，并且返回新的自增id
     *
     * @param sql
     * @param params
     * @return 受影响行数
     */
    public static int insert(String sql, Object... params) {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = getConnection();
        try {
            return queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(connection);
        }
        return 0;
    }


    /**
     * 新增：同一事务下
     *
     * @param connection
     * @param sql
     * @param params
     * @return 受影响行数
     */
    public static int insert(String sql, Connection connection, Object... params) {
        QueryRunner queryRunner = new QueryRunner();
        try {
            return queryRunner.insert(connection, sql, new ScalarHandler<Long>(), params).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
//
//
//    /**
//     * 数据库查询方法的工具类
//     *
//     * @param sql    查询语句
//     * @param clazz  得到的类名
//     * @param params 可变参数
//     * @param <T>    泛型
//     * @return 返回查询的集合
//     */
//    public <T> List<T> query(String sql, Class clazz, Object... params) {
//        QueryRunner queryRunner = new QueryRunner();
//        jdbcUtils = new JDBCUtils();
//        Connection connection = jdbcUtils.getConnection();
//        try {
//            return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), params);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DbUtils.closeQuietly(connection);
//        }
//        return null;
//    }

    /**
     * 获取set方法名
     *
     * @param str
     * @return
     */
    private static String getMethodName(String str) {
        StringBuilder temp = new StringBuilder("set");
        String[] split = str.split("_");
        for (String s : split) {
            temp.append(s.substring(0, 1).toUpperCase());
            temp.append(s.substring(1));
        }
        return temp.toString();
    }

    /**
     * 查询,返回list集合
     *
     * @param sql
     * @param clazz
     * @param o
     * @param <T>
     * @return
     */
    public static <T> List<T> query(String sql, Class<T> clazz, Object... o) {
        Connection conn = getConnection();
        PreparedStatement prst = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();

        try {
            prst = conn.prepareStatement(sql);
//            填充sql语句
            for (int i = 0; i < o.length; i++) {
                prst.setObject((i + 1), o[i]);
            }
            rs = prst.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 1; i < md.getColumnCount() + 1; i++) {
                    String columnClassName = md.getColumnClassName(i);
                    String columnLabel = md.getColumnLabel(i);
                    String methodName = getMethodName(columnLabel);
                    Method method = clazz.getMethod(methodName, getClass(columnClassName));
                    method.invoke(t, rs.getObject(columnLabel));
                }
                list.add(t);
            }
        } catch (SQLException | IllegalAccessException | NoSuchMethodException | InvocationTargetException |
                 InstantiationException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn, prst, rs);
        }
        return list;
    }

    /**
     * 返回查找到的第一条对象
     *
     * @param sql
     * @param clazz
     * @param o
     * @param <T>
     * @return
     */
    public static <T> T find(String sql, Class<T> clazz, Object... o) {
        List<T> list = query(sql, clazz, o);
        if (list.size() == 0 || list == null) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 获取数据类型对应的Class对象
     *
     * @param name
     * @return
     */
    private static Class getClass(@NotNull String name) {
        if ("java.sql.Date".equals(name) || "java.sql.Timestamp".equals(name)) {
            name = "java.util.Date";
        }
        Class ca = null;
        try {
            ca = Class.forName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ca;
    }
//    /**
//     * 获取单个对象值
//     *
//     * @param sql    输入的sql语句
//     * @param clazz
//     * @param params 可变参数
//     * @param <T>
//     * @return
//     */
//    public  <T> @Nullable T get(String sql, Class clazz, Object... params) {
//        QueryRunner queryRunner = new QueryRunner();
//        Connection connection = jdbcUtils.getConnection();
//        try {
//            return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), params);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DbUtils.closeQuietly(connection);
//        }
//        return null;
//    }


    /**
     * 统计数据
     *
     * @param sql    输入sql语句
     * @param params 可变参数
     * @return 返回统计结果
     */
    public static Long count(String sql, Object... params) {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler<Long>(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 分页查询
     *
     * @param sql      分页查询语句
     * @param page     页数(最小为1)
     * @param pageSize 分页大小
     */
    public void pageQuery(String sql, int pageSize, int page) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        RowSetFactory factory;
        try {
            // 获取数据库的链接
            conn = getConnection();
            // 设置RS游标移动类型
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            // 结果集元数据信息对象
            ResultSetMetaData metaData = rs.getMetaData();
            // 建立能够产生CachedRowSet的工厂
            factory = RowSetProvider.newFactory();
            CachedRowSet cachedRs = factory.createCachedRowSet();
            // 最关联的两句
            // 设置每页的大小
            cachedRs.setPageSize(pageSize);
            // 第一个参数：将Rs中query到的结果集输入到cachedRs中
            // 第二个参数：从第(page - 1) * pageSize + 1行开始抓取结果集，一次抓取一页
            cachedRs.populate(rs, (page - 1) * pageSize + 1);

            ConsoleTable consoleTable = new ConsoleTable();
            // 打印列名
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                consoleTable.addHeader(metaData.getColumnName(i + 1));
//                System.out.print(metaData.getColumnName(i + 1) + "\t");
            }
            consoleTable.print();
            // 对分页的结果集进行处理
            while (cachedRs.next()) {
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    consoleTable.addBody(cachedRs.getString(i + 1));
                    consoleTable.print();
//                    System.out.print(cachedRs.getString(i + 1) + "\t");
                }
                consoleTable.print();
//                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放与JDBC有关的资源
            close(rs, st, conn);
        }
    }
}
