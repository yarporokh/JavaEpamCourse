package com.advanced.practice1.task1.house;


import com.advanced.practice1.task1.residents.cats.Cat;
import com.advanced.practice1.task1.residents.cats.Kitten;
import com.advanced.practice1.task1.residents.dogs.Dog;
import com.advanced.practice1.task1.residents.dogs.Puppy;

public class Main {

    public static void main(String[] args) {
        Dog rex = new Dog("Rax");
        Puppy randy = new Puppy("Randy");
        Cat barbos = new Cat("Barbos");
        Kitten murzik = new Kitten("Murzik");

        House<Dog> dogHouse = new House();
        dogHouse.enter(rex);
        dogHouse.enter(randy);
        System.out.println(dogHouse);

        House<Cat> catHouse = new House();
        catHouse.enter(barbos);
        catHouse.enter(murzik);
        System.out.println(catHouse);
    }
}
