package com.ipiecoles.java.java230;

import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MyRunner implements CommandLineRunner
{
    @Autowired                                      //injection de dependance
    private EmployeRepository employeRepository;

    @Override
    public void run(String... strings) throws Exception
    {
        System.out.println("je lance le test");
//////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
//                      pour decommenter cette section il faut que employe ne soit pas abstract
//
//        Long nbEmployes = employeRepository.count();
//        System.out.println("il y a " + nbEmployes + " dans la base de données");
//
//
//        // test recherche par index
//        Optional<Employe> employe = employeRepository.findById(55L);
//        if(employe.isEmpty())
//        {
//            System.out.println("Employe inexistant");
//        }
//        else
//        {
//            Employe e = employe.get();
////            e.setSalaire(e.getSalaire()+200); // pour augmenter le salaire de l'employe 55
////            e = employeRepository.save(e);
//            System.out.println(employe.get().toString());
//        }
////        for (Employe emp : employeRepository.findAll())   // boucle pour afficher tous les employes
////        {
////            System.out.println(emp.toString());
////        }
//
//
//
//        // test recherche par matricule
        Employe emp1 = employeRepository.findByMatricule("C00004");
        if (emp1 !=null)
        {
            System.out.println(emp1);
        }
        else
        {
            System.out.println("pas d'employé avec ce matricule");
        }
//
//        // test recherche par nom et prenom
//        List<Employe> employeList =employeRepository.findByNomAndPrenom("Andre","Alexandre");
//        for(Employe employe1: employeList)
//        {
//            System.out.println(employe.toString());
//        }
//
//        // test recherche par salaire avec filtre
//        List<Employe> employeList2 =employeRepository.findBySalaireGreaterThanOrderBySalaireDesc(2400d);
//        for(Employe employe2: employeList2)
//        {
//            System.out.println(employe.toString());
//        }
//
//
//        // test recherche par prenom avec trie ascendant et mise en page
//        PageRequest pageRequest = PageRequest.of(0,5,Sort.Direction.ASC,"prenom");
//        Page<Employe>employePage = employeRepository.findByNomIgnoreCase("Andre",pageRequest);
//        System.out.println("nombre de page total : "+employePage.getTotalPages());
//        System.out.println("nombre d'elements : "+employePage.getTotalElements());
//        for(Employe employe3 : employePage)
//        {
//            System.out.println(employe3.toString());
//        }



//        // test recherche par nom ou prenom
        List<Employe> employeList3 =employeRepository.findByNomOrPrenomAllIgnoreCase("Julien");
        for(Employe employe3: employeList3)
        {
            System.out.println(employe3.toString());
        }

        // test recherche par nom ou prenom paginé
//        PageRequest pageRequest3 = PageRequest.of(0,5);
//        for(Employe emp : employeRepository.findByNomOrPrenomAllIgnoreCase("juLien",pageRequest3))
//        {
//            System.out.println(emp.toString());
//        }




        List<Employe>  emp4 = employeRepository.findEmployePlusRiches();
        for(Employe employe4: emp4)
        {
            System.out.println(employe4.toString());
        }








//
//        // mes test Recherche
//        PageRequest pageRequest2 = PageRequest.of(0,5);
//        for(Employe emp : employeRepository.findByPrenomIgnoreCase("gabRiel",pageRequest2))
//        {
//            System.out.println(emp.toString());
//        }
//        for(Employe emp : employeRepository.findByNomIgnoreCase("daviD",pageRequest2))
//        {
//            System.out.println(emp.toString());
//        }

//////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////

    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
