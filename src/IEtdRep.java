import java.sql.SQLException;
//justification :
// d'aprés le principe d'inversion de controle les modules de haut niveau ne doivent pas dependre des modules de bas niveau.
public interface IEtdRep{

	boolean Exists(int matricule) throws SQLException;

	boolean Exists(String email) throws SQLException;

	void add(EtudiantFactory stud) throws SQLException;
	

}
