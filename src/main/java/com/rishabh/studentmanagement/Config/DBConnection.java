package com.rishabh.studentmanagement.Config;

import com.rishabh.studentmanagement.Util.DataSourceUtil;

import java.sql.Connection;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        return DataSourceUtil.getDataSource().getConnection();
    }
}
