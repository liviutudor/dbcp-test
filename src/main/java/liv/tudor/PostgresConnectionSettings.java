package liv.tudor;

public final class PostgresConnectionSettings extends ConnectionSettings {

  @Override
  public String getJdbcUrl() {
    return "jdbc:postgresql://" + getHost() + "/" + getDatabase();
  }

  @Override
  public String getDriverClassName() {
    return "org.postgresql.Driver";
  }
}
