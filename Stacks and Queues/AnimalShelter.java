import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {
    public static void main(String[] args){
        Shelter shelter = new Shelter();
        Animal vicky = new Dog("vicky",123);
        Animal tommy = new Cat("tommy",124);
        Animal lucy = new Dog("lucy",125);
        Animal nancy = new Cat("nancy",126);
        shelter.enqueue(vicky);
        shelter.enqueue(tommy);
        shelter.enqueue(lucy);
        shelter.enqueue(nancy);
        Animal pick = shelter.dequeueCat();
        System.out.println(pick.toString());
        pick = shelter.dequeueAny();
        System.out.println(pick.toString());
        pick = shelter.dequeueDog();
        System.out.println(pick.toString());
        pick = shelter.dequeueAny();
        System.out.println(pick.toString());
        pick = shelter.dequeueAny();
    }
}

class Animal{
    int timestamp;
    String name;
    Animal(String name, int timestamp){
         this.name = name;
         this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "timestamp=" + timestamp +
                ", name='" + name + '\'' +
                '}';
    }
}

class Dog extends Animal{

    Dog(String name, int timestamp) {
        super(name, timestamp);
    }
}

class Cat extends Animal{

    Cat(String name, int timestamp) {
        super(name, timestamp);
    }
}

class Shelter {
    private Queue<Animal> dogList = new LinkedList<>();
    private Queue<Animal> catList = new LinkedList<>();

    Animal dequeueDog(){
        return dogList.poll();
    }

    Animal dequeueCat(){
        return catList.poll();
    }

    Animal dequeueAny(){
        if(dogList.peek()==null&&catList.peek()==null){
            System.out.println("Shelter is empty");
        }

        if(dogList.peek()==null){
           return catList.poll();
        }

        if(catList.peek()==null){
            return dogList.poll();
        }

        if(dogList.peek().timestamp>catList.peek().timestamp){
            return catList.poll();
        }

        return dogList.poll();
    }

    void enqueue(Animal animal){
        if(animal instanceof Dog){
            dogList.add(animal);
        }
        if(animal instanceof Cat){
            catList.add(animal);
        }
    }


}