package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class find {
    public Connection executerTests() {
        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/test.db";

        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            System.out.print( "Connexion à la base de données..." );
            connexion = DriverManager.getConnection(url );
            System.out.print( "Connexion réussie !" );

            /* Création de l'objet gérant les requêtes */
            statement = connexion.createStatement();
            System.out.print( "Objet requête créé !" );

            /* Exécution d'une requête de lecture */
            resultat = statement.executeQuery( "SELECT recherche FROM bouton recherche or all;" );
            //messages.add( "Requête \"SELECT id, email, mot_de_passe, nom FROM Utilisateur;\" effectuée !" );

            /* Récupération des données du résultat de la requête de lecture */
            while ( resultat.next() ) {
                String recherche = resultat.getString( "recherche" );

                /* Formatage des données pour affichage dans la JSP finale. */
                System.out.print( "Données retournées par la requête de recherche: recherche = " + recherche );
            }
        } catch ( SQLException e ) {
            System.out.print( "Erreur lors de la connexion : <br/>"
                    + e.getMessage() );
        } finally {
            System.out.print( "Fermeture de l'objet ResultSet." );
            if ( resultat != null ) {
                try {
                    resultat.close();
                } catch ( SQLException ignore ) {
                }
            }
            System.out.print( "Fermeture de l'objet Statement." );
            if ( statement != null ) {
                try {
                    statement.close();
                } catch ( SQLException ignore ) {
                }
            }
            System.out.print( "Fermeture de l'objet Connection." );
            if ( connexion != null ) {
                try {
                    connexion.close();
                } catch ( SQLException ignore ) {
                }
            }
        }

        return connexion;
    }


    public static void main(String[] args) {
        new find();
}


}




