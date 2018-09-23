/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.se;

/**
 *
 * @author durfm
 */

import edu.depaul.cdm.IinstructorRepository;
import edu.depaul.cdm.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("edu.depaul.cdm.se.sampleproject.book.spring.jpa")
public class Main implements CommandLineRunner {
    @Autowired
    IinstructorRepository repository;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main.class);
        app.run(args);
    }//end main

    @Override
    public void run(String... args) throws Exception {
        createExample();
        updateExample();
        deleteExample();
    }//end run method

    private void createExample() {
        System.out.println(repository.count());
        Instructor instr1 = new Instructor();
        instr1.setInstrName();

        repository.save(instr1);

        System.out.println(repository.count());
    }//end createExample

    private void updateExample() {
        Instructor instr = repository.getOne(new Long(1));
        instr.setInstrName();
        repository.save(instr);
        instr = new Instructor();
        System.out.println(instr.getInstrName());
        
    }//end updateExample


    private void deleteExample() {
        System.out.println("Before delete: " + repository.count());
        repository.deleteById(new Long(1));
        System.out.println("After delete: " + repository.count());
    }//end deleteExample
    
}//end class
