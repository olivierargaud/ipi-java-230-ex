package com.ipiecoles.java.java230.repository;

import com.ipiecoles.java.java230.model.Employe;
import org.joda.time.LocalDate;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface EmployeRepository extends CrudRepository<Employe, Long>
{
    public ArrayList<Employe> findByMatricule(String matricule);

    public ArrayList<Employe> findByNomAndPrenom(String nom,String prenom);

    public ArrayList<Employe>  findByNomIgnoreCase(String nom);

    public ArrayList<Employe>  findByDateEmbaucheBefore(LocalDate date);

    public ArrayList<Employe>  findByDateEmbaucheAfter(LocalDate date);

    public ArrayList<Employe>  findBySalaireGreaterThanOrderBySalaireDesc(Double salaire);


//
//    public ArrayList<Employe> sortByAvantDate();
//
//    public ArrayList<Employe> sortByApresDate();
//
//    public ArrayList<Employe> sortBySalaire();



}
