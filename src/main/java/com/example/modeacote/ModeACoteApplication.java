package com.example.modeacote;

import com.example.modeacote.model.Category;
import com.example.modeacote.model.Product;
import com.example.modeacote.repository.CategoryRepository;
import com.example.modeacote.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@SpringBootApplication(scanBasePackages = "com.example.modeacote")
public class ModeACoteApplication {

    @Autowired
    private ProductRepository prodRepo;
    @Autowired
    private CategoryRepository catRepo;

    public static void main(String[] args) {
        SpringApplication.run(ModeACoteApplication.class, args);
    }

    @Bean
    CommandLineRunner myCommandLineRunnerBean(){
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {

                Category cat1 = new Category();
                cat1.setName("pull");
                Category cat2 = new Category();
                cat2.setName("short");
                Category cat3 = new Category();
                cat3.setName("t-shirt");
                Category cat4 = new Category();
                cat4.setName("robe");

                catRepo.save(cat1);
                catRepo.save(cat2);
                catRepo.save(cat3);
                catRepo.save(cat4);

                Product prod1 = new Product();
                prod1.setName("pull");
                prod1.setBrand("Zara");
                prod1.setColor("rose");
                prod1.setSize("M");
                prod1.setMaterial("laine");

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

                Product prod5 = new Product();
                prod5.setName("pull");
                prod5.setBrand("Lacoste");
                prod5.setColor("bleu");
                prod5.setSize("L");
                prod5.setMaterial("laine");

                Product prod6 = new Product();
                prod6.setName("short");
                prod6.setBrand("Décathlon");
                prod6.setColor("noir");
                prod6.setSize("XXL");
                prod6.setMaterial("coton");

                prodRepo.save(prod1);
                prodRepo.save(prod2);
                prodRepo.save(prod3);
                prodRepo.save(prod4);
                prodRepo.save(prod5);
                prodRepo.save(prod6);

            }
        };
    }

}
