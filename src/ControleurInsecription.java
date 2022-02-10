import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
public class ControleurInsecription {

	private static final String CHAMP_MAT = null;
	private static final String CHAMP_NOM = null;
	private static final String CHAMP_PRENOM = null;
	private static final String CHAMP_MAIL = null;
	private static final String CHAMP_PWD = null;
	private static final String CHAMP_CONF = null;
	private static final int id_universite = 0;
	private String resultat;
		private Map<String, String> erreurs = new HashMap<String, String>();
		
		public String getResultat() {
		    return resultat;
		}
		
	public final class ControleurInscription<HttpServletRequest>{
	
		private static final String CHAMP_MAT ="matricule" ; 
	    private static final String CHAMP_NOM    = "nom";
	    private static final String CHAMP_PRENOM  = "prenom";
	    private static final String CHAMP_MAIL  = "Email";
	    private static final String CHAMP_PWD   = "password";
	    private static final String champ_CONF = "confirmation";
	    private int nbLivreEmprunte;
	    private int id_universite;
	

		
		
		public Map<String, String> getErreurs() {
		    return erreurs;
		}
	}
		public  Etudiant inscrireEtudaint( HttpServletRequest request ) {
			int matricule = getValeurChamp( request, CHAMP_MAT );
			String nom = getValeurChamp( request, CHAMP_NOM );
			String prenom = getValeurChamp( request, CHAMP_PRENOM );
		    String email = getValeurChamp( request, CHAMP_MAIL );
		    String pwd = getValeurChamp( request, CHAMP_PWD );
		    String confirmation = getValeurChamp( request, CHAMP_CONF );

		    Etudiant E = new Etudiant(matricule , nom, prenom, email, pwd, id_universite);

		    try {
		        validationEmail( email );
		    } catch ( Exception e ) {
		        setErreur( CHAMP_MAIL, e.getMessage() );
		    }
		    E.setEmail( email );

		    try {
		        validationMotsDePasse( pwd, confirmation );
		    } catch ( Exception e ) {
		        setErreur( CHAMP_PWD, e.getMessage() );
		        setErreur( CHAMP_CONF, null );
		    }
		    E.setPwd( pwd );

		    try {
		        validationNom( nom );
		    } catch ( Exception e ) {
		        setErreur( CHAMP_NOM, e.getMessage() );
		    }
		    E.setNom( nom );

		    if ( erreurs.isEmpty() ) {
		        resultat = "Succès de l'inscription.";
		    } else {
		        resultat = "Échec de l'inscription.";
		    }

		    return E;
		}


		private void validationEmail( String email ) throws Exception {
		    if ( email != null ) {
		        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
		            throw new Exception( "Merci de saisir une adresse mail valide." );
		        }
		    } else {
		        throw new Exception( "Merci de saisir une adresse mail." );
		    }
		}

		private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception {
		    if ( motDePasse != null && confirmation != null ) {
		        if ( !motDePasse.equals( confirmation ) ) {
		            throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
		        } else if ( motDePasse.length() < 3 ) {
		            throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
		        }
		    } else {
		        throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
		    }
		}

		private void validationNom( String nom ) throws Exception {
		    if ( nom != null && nom.length() < 3 ) {
		        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
		    }
		}

		/*
		 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
		 */
		private void setErreur( String champ, String message ) {
		    erreurs.put( champ, message );
		}

		/*
		 * Méthode utilitaire qui retourne null si un champ est vide, sinon son contenu
		 * 
		 */
		private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
		    String valeur = request.getParameter( nomChamp );
		    if ( valeur == null || valeur.trim().length() == 0 ) {
		        return null;
		    } else {
		        return valeur.trim();
		    }
		}
		
		
		



		
	    
	
}
