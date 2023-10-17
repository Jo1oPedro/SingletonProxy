package database;

public class Database implements IDatabase {

    private static Database connection = new Database();
    // parametros para conexão, host, user, pw, database.

    private Database() {};

    public static Database getConnection() {
        return Database.connection;
    }

    public void query(String query) {
        //realiza a query
    }
}
