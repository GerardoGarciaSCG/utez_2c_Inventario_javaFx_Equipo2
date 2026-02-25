public class perro extends animal {
    public perro(String name) {
        super(name);
    }

    @Override
    public void hacerSonido() {
        System.out.println(name + " Hace Gua");
    }

    public void marcarTerritorio() {
        System.out.println(name + " Esta alzando la patita");
    }
}
