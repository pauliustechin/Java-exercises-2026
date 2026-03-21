public class Cat extends Animal implements NoiseCapable{

    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super("Cat");
    }

    // cia irgi nesupratau kame problema: The getName method of class Cat should be inherited. This was not the case.
    @Override
    public String getName() {
        return super.getName();
    }

    public void purr(){
        System.out.println(getName() + " purrs");
    }

    @Override
    public void makeNoise() {
        System.out.println(getName() + " purrs");
    }
}
