package by.it.akhmelev.at22.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionCreator {

    Connection get() throws SQLException;
}
