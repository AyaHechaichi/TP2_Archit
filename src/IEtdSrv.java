import java.sql.SQLException;

public interface IEtdSrv {
	boolean inscription (int matricule, String nom, String prénom, String email,String pwd, int id_universite) throws SQLException;

}
