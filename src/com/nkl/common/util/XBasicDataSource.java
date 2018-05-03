package com.nkl.common.util;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author:cyj
 * @data:2018/4/24 11:52
 * @describe:
 */
public class XBasicDataSource extends BasicDataSource {
    @Override
    public synchronized void close() throws SQLException {
        System.out.println("......输出数据源Driver的url：" + DriverManager.getDriver(url));
        DriverManager.deregisterDriver(DriverManager.getDriver(url));
        super.close();
    }
}
