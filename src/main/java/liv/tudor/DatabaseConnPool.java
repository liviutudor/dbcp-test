package liv.tudor;

import com.google.common.base.MoreObjects;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConnPool {

  public ConnectionSettings getConnectionSettings() {
    return connectionSettings;
  }

  public void setConnectionSettings(ConnectionSettings connectionSettings) {
    this.connectionSettings = connectionSettings;
  }

  private ConnectionSettings connectionSettings;

  private BasicDataSource basicDS = null;

  public synchronized void init() {
    if (basicDS == null) {
      basicDS = new BasicDataSource();
      basicDS.setDriverClassName(connectionSettings.getDriverClassName());
      basicDS.setUrl(connectionSettings.getJdbcUrl());
      basicDS.setUsername(connectionSettings.getUsername());
      basicDS.setPassword(connectionSettings.getPassword());

      // Parameters for connection pooling -- hardcoded
      basicDS.setDefaultAutoCommit(false);
      basicDS.setRemoveAbandonedOnMaintenance(true);
      basicDS.setConnectionProperties("serverTimezone=UTC");
      basicDS.setTestOnBorrow(true);
      // Parameters for connection pooling -- config
      basicDS.setMinIdle(connectionSettings.getMinIdle());
      basicDS.setMaxTotal(connectionSettings.getMaxPoolSize());
      basicDS.setJmxName("liv.tudor.dbcpTest:type=liv.tudor.databasePool");
      basicDS.setMaxWaitMillis(connectionSettings.getMaxWaitMillis());
      basicDS
          .setTimeBetweenEvictionRunsMillis(connectionSettings.getTimeBetweenEvictionRunsMillis());
      basicDS.setRemoveAbandonedTimeout(connectionSettings.getRemoveAbandonedTimeout());
    }
  }

  public Connection getConnection() throws SQLException {
    init();
    return basicDS.getConnection();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("connectionSettings", connectionSettings)
        .toString();
  }
}
