package liv.tudor;

public final class MySqlConectionSettings extends ConnectionSettings {

  @Override
  public String getJdbcUrl() {
    return "jdbc:mysql://" + getHost() + "/" + getDatabase();
  }

  @Override
  public String getDriverClassName() {
    return "com.mysql.cj.jdbc.Driver";
  }
}
