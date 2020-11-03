package com.ipiecoles.java.java230;

import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyRunner implements CommandLineRunner
{
    @Autowired                                      //injection de dependance
    private EmployeRepository employeRepository;

    @Override
    public void run(String... strings) throws Exception
    {
        // taper du code test ici
        System.out.println("je lance le test");
        Long nbEmployes = employeRepository.count();
        System.out.println("il y a " + nbEmployes + " dans la base de données");
        Optional<Employe> employe = employeRepository.findById(55L);
        if(employe.isEmpty())
        {
            System.out.println("Employe inexistant");
        }
        else
        {
            Employe e = employe.get();
//            e.setSalaire(e.getSalaire()+200); // pour augmenter le salaire de l'employe 55
//            e = employeRepository.save(e);
            System.out.println(employe.get().toString());
        }
//        for (Employe emp : employeRepository.findAll())   // boucle pour afficher tous les employes
//        {
//            System.out.println(emp.toString());
//        }
    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
