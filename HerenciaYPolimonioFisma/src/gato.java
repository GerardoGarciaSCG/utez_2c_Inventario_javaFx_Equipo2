public class gato extends animal {

    public gato(String name) {
        super(name);//inicializa la clase padre,es Animal
    }

    @Override
    public void hacerSonido() {
        System.out.println(name + " Hace miau");

    }
}
