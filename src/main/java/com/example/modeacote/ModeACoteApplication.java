package com.example.modeacote;

import com.example.modeacote.model.Product;
import com.example.modeacote.repository.CategoryRepository;
import com.example.modeacote.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.example.modeacote")
public class ModeACoteApplication {

    @Autowired
    private ProductRepository prodRepo;
    private CategoryRepository catRepo;

    public static void main(String[] args) {
        SpringApplication.run(ModeACoteApplication.class, args);
    }

    @Bean
    CommandLineRunner myCommandLineRunnerBean(){
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {

                Product prod1 = new Product();
                prod1.setName("pull");
                prod1.setBrand("Zara");
                prod1.setColor("rose");
                prod1.setSize("M");
                prod1.setMaterial("coton");

                Product prod2 = new Product();
                prod2.setName("t-shirt");
                prod2.setBrand("Lacoste");
                prod2.setColor("bleu");
                prod2.setSize("XL");
                prod2.setMaterial("coton");

                Product prod3 = new Product();
                prod3.setName("robe");
                prod3.setBrand("H&M");
                prod3.setColor("mauve");
                prod3.setSize("XS");
                prod3.setMaterial("lin");

                Product prod4 = new Product();
                prod4.setName("short");
                prod4.setBrand("Décathlon");
                prod4.setColor("gris");
                prod4.setSize("L");
                prod4.setMaterial("coton");

                prodRepo.save(prod1);
                prodRepo.save(prod2);
                prodRepo.save(prod3);
                prodRepo.save(prod4);
            }
        };
    }

}
