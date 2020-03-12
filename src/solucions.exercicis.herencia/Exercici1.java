package solucions.exercicis.herencia;

public class Exercici1 {

    public static void main(String[] args) {
        ClassB b = new ClassB();
        ClassA a = b;

        // Override:
        a.methodTwo(0);
        // No Override. No es té en compte l'objecte, només la classe
        a.methodFour(0);

        // Cridades a "methodFour" directament amb la classe, no els objectes
        ClassA.methodFour(0);
        ClassB.methodFour(0);
    }


}

class ClassA {
    public void methodOne(int i) {
    }

    public void methodTwo(int i) {
        System.out.println("MethodTwo classA");
    }

    public static void methodThree(int i) {
    }

    public static void methodFour(int i) {
        System.out.println("MethodFour classA");
    }
}

class ClassB extends ClassA {
    // Aquest no és correcte. No pot existir un mètode "static" amb el mateix nom
    // que un mètode heretetat de la superclasse
    //public static void methodOne(int i) {
    //}

    // Aquest és correcte: és un OVERRIDE
    @Override
    public void methodTwo(int i) {
        System.out.println("MethodTwo classB");
    }

    // Aquest tampoc és correcte, perquè existeix un mètode "static" amb el mateix nom a la superclasse
    //public void methodThree(int i) {
    //}

    // Aquest és un mètode que no és un Override, simplement és un mètode static amb el mateix nom
    // que un mètode "static" de la superclasse
    public static void methodFour(int i) {
        System.out.println("MethodFour classB");
    }
}