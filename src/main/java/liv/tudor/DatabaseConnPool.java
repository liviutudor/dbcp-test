package liv.tudor;

import com.google.common.base.MoreObjects;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConnPool {
  private String host;
  private String username;
  private String password;
  private String database;
  private String driverClassName;
  private int maxPoolSize;
  private int minIdle;
  private String jmxName;
  private int maxWaitMillis;
  private int timeBetweenEvictionRunsMillis;
  private int removeAbandonedTimeout;

  private BasicDataSource basicDS = null;

  public synchronized void init() {
    if (basicDS == null) {
      basicDS = new BasicDataSource();
      basicDS.setDriverClassName(driverClassName);
      basicDS.setUrl(getJdbcUrl());
      basicDS.setUsername(username);
      basicDS.setPassword(password);

      // Parameters for connection pooling -- hardcoded
      basicDS.setDefaultAutoCommit(false);
      basicDS.setRemoveAbandonedOnMaintenance(true);
      basicDS.setConnectionProperties("serverTimezone=UTC");
      // Parameters for connection pooling -- config
      basicDS.setMinIdle(minIdle);
      basicDS.setMaxTotal(maxPoolSize);
      basicDS.setJmxName(jmxName);
      basicDS.setMaxWaitMillis(maxWaitMillis);
      basicDS.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
      basicDS.setRemoveAbandonedTimeout(removeAbandonedTimeout);
    }
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getDatabase() {
    return database;
  }

  public void setDatabase(String database) {
    this.database = database;
  }

  public String getDriverClassName() {
    return driverClassName;
  }

  public void setDriverClassName(String driverClassName) {
    this.driverClassName = driverClassName;
  }

  public int getMaxPoolSize() {
    return maxPoolSize;
  }

  public void setMaxPoolSize(int maxPoolSize) {
    this.maxPoolSize = maxPoolSize;
  }

  public String getJdbcUrl() {
    return "jdbc:mysql://" + host + "/" + database;
  }

  public int getMinIdle() {
    return minIdle;
  }

  public void setMinIdle(int minIdle) {
    this.minIdle = minIdle;
  }

  public String getJmxName() {
    return jmxName;
  }

  public void setJmxName(String jmxName) {
    this.jmxName = jmxName;
  }

  public int getMaxWaitMillis() {
    return maxWaitMillis;
  }

  public void setMaxWaitMillis(int maxWaitMillis) {
    this.maxWaitMillis = maxWaitMillis;
  }

  public int getTimeBetweenEvictionRunsMillis() {
    return timeBetweenEvictionRunsMillis;
  }

  public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
    this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
  }

  public int getRemoveAbandonedTimeout() {
    return removeAbandonedTimeout;
  }

  public void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
    this.removeAbandonedTimeout = removeAbandonedTimeout;
  }

  public Connection getConnection() throws SQLException {
    init();
    return basicDS.getConnection();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("host", host)
        .add("username", username)
        .add("password", password)
        .add("database", database)
        .add("driverClassName", driverClassName)
        .add("maxPoolSize", maxPoolSize)
        .add("minIdle", minIdle)
        .add("jmxName", jmxName)
        .add("maxWaitMillis", maxWaitMillis)
        .add("timeBetweenEvictionRunsMillis", timeBetweenEvictionRunsMillis)
        .add("removeAbandonedTimeout", removeAbandonedTimeout)
        .add("basicDS", basicDS)
        .toString();
  }
}
