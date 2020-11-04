package com.ipiecoles.java.java230.repository;

import com.ipiecoles.java.java230.model.Employe;
import org.joda.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmployeRepository extends PagingAndSortingRepository<Employe, Long>
{

    Employe findByMatricule(String matricule);

    List<Employe> findByNomAndPrenom(String nom, String prenom);    // on utilise List pour rester generique

    Page<Employe> findByPrenomIgnoreCase( String prenom, Pageable pageable);

    List<Employe> findByNomIgnoreCase(String nom);

    Page<Employe> findByNomIgnoreCase(String nom, Pageable pageable);

    List<Employe> findByDateEmbaucheBefore(LocalDate date);

    List<Employe> findByDateEmbaucheAfter(LocalDate date);

    List<Employe> findBySalaireGreaterThanOrderBySalaireDesc(Double salaire);


//    version qui valide les tests mais fonctione pas
//    @Query("select e from Employe e where lower(e.prenom) = lower(:nomOuPrenom) or lower(e.nom) = lower(:nomOuPrenom)")
//    List<Employe> findByNomOrPrenomAllIgnoreCase(@Param("toto") String nomOuPrenom);


//    corection

    @Query("select e from Employe e where lower(e.prenom) = lower(:nomOuPrenom) or lower(e.nom) = lower(:nomOuPrenom)")
    List<Employe> findByNomOrPrenomAllIgnoreCase(@Param("nomOuPrenom") String nomOuPrenom);









////    ma version en list fonctionne
//    @Query("from Employe where nom = lower(:toto) or prenom= lower(:toto)")
//    List<Employe> findByNomOrPrenomAllIgnoreCase(@Param("toto") String nomOuPrenom);
//
////    ma version en page fonctionne pas
//    @Query("from Employe where nom = lower(:toto) or prenom= lower(:toto)")
//    Page<Employe> findByNomOrPrenomAllIgnoreCase(@Param("toto") String nomOuPrenom, Pageable pageable);



//    @Query(value = "SELECT * FROM Employe WHERE salaire>2480", nativeQuery = true)
//    List<Employe> findEmployePlusRiches();


//  correction
    @Query(value = "SELECT * FROM Employe WHERE salaire > (SELECT avg(e2.salaire)FROM Employe e2)", nativeQuery = true)
    List<Employe> findEmployePlusRiches();


}




















//public interface VehiculeRepository extends CrudRepository<Vehicule,Integer> {
//    //SELECT * FROM vehicule WHERE immatriculation = ?;
//    Vehicule findByImmatriculation(String immatriculation);
//    //SELECT * FROM vehicule WHERE marque = ? AND modele = ?;
//    List<Vehicule> findByMarqueAndModele(String marque, String modele);
//    //SELECT * FROM vehicule WHERE lower(marque) = ?;
//    List<Vehicule> findByMarqueIgnoreCase(String nom);
//    //Idem mais avec pagination
//    Page<Vehicule> findByMarqueIgnoreCase(String nom, Pageable pageable);
//    //SELECT * FROM vehicule WHERE date_mise_circulation < ?;
//    List<Vehicule> findByDateMiseCirculationBefore(LocalDate date);
//    //SELECT * FROM vehicule WHERE puissance > ? ORDER BY immatriculation DESC;
//    List<Vehicule> findByPuissanceGreaterThanOrderByImmatriculationDesc(Integer puissance);
//}


// JPQL -> pseudo SQL pour les requetes un peut plus complexe
//public interface VehiculeRepository extends CrudRepository<Vehicule,Integer> {
//
//    @Query("select v from Vehicule v where length(v.marque) = ? ")
//    @Query("from Vehicule v where length(v.marque) = ? ")   select v n'est pas necessaire
//    List<Vehicule> findByLongueurMarque(Integer longueur);
//}

// SQL natif quand on a plus le choix du tout
//public interface ProprietaireRepository extends CrudRepository<Proprietaire,Integer> {
//
//    @Query(value = "SELECT p.* FROM proprietaire p " +
//            "INNER JOIN vehicule v ON v.proprietaire_id = p.id " +
//            "WHERE v.marque = :marque1 " +                        // on nomme le param plutot que de mettre "?"
//            "AND EXISTS ( " +
//            "SELECT p2.* FROM proprietaire p2 " +
//            "INNER JOIN vehicule v2 ON v2.proprietaire_id = p2.id " +
//            "WHERE p2.id = p.id" +
//            "AND v2.marque = :marque2 " +
//            ")", nativeQuery = true)
//    List<Proprietaire> findByDeuxMarques(@Param("marque1") String marque1, @Param("marque2") String marque2);
//}