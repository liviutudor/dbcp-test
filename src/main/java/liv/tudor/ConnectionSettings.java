package liv.tudor;

import com.google.common.base.MoreObjects;

public abstract class ConnectionSettings {

  private String host;
  private String username;
  private String password;
  private String database;
  private int maxPoolSize;
  private int minIdle;
  private int maxWaitMillis;
  private int timeBetweenEvictionRunsMillis;
  private int removeAbandonedTimeout;

  public final String getHost() {
    return host;
  }

  public final void setHost(String host) {
    this.host = host;
  }

  public final String getUsername() {
    return username;
  }

  public final void setUsername(String username) {
    this.username = username;
  }

  public final String getPassword() {
    return password;
  }

  public final void setPassword(String password) {
    this.password = password;
  }

  public final String getDatabase() {
    return database;
  }

  public final void setDatabase(String database) {
    this.database = database;
  }

  public abstract String getDriverClassName();

  public final int getMaxPoolSize() {
    return maxPoolSize;
  }

  public final void setMaxPoolSize(int maxPoolSize) {
    this.maxPoolSize = maxPoolSize;
  }

  public abstract String getJdbcUrl();

  public final int getMinIdle() {
    return minIdle;
  }

  public final void setMinIdle(int minIdle) {
    this.minIdle = minIdle;
  }

  public final int getMaxWaitMillis() {
    return maxWaitMillis;
  }

  public final void setMaxWaitMillis(int maxWaitMillis) {
    this.maxWaitMillis = maxWaitMillis;
  }

  public final int getTimeBetweenEvictionRunsMillis() {
    return timeBetweenEvictionRunsMillis;
  }

  public final void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
    this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
  }

  public final int getRemoveAbandonedTimeout() {
    return removeAbandonedTimeout;
  }

  public final void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
    this.removeAbandonedTimeout = removeAbandonedTimeout;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("host", host)
        .add("username", username)
        .add("password", password)
        .add("database", database)
        .add("driverClassName", getDriverClassName())
        .add("maxPoolSize", maxPoolSize)
        .add("minIdle", minIdle)
        .add("maxWaitMillis", maxWaitMillis)
        .add("timeBetweenEvictionRunsMillis", timeBetweenEvictionRunsMillis)
        .add("removeAbandonedTimeout", removeAbandonedTimeout)
        .toString();
  }
}
