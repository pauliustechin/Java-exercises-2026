public class Dog extends Animal implements NoiseCapable{

    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super("Dog");
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void bark(){
        System.out.println(getName() + " barks");
    }

    @Override
    public void makeNoise() {
        System.out.println(getName() + " barks");
    }
}
