
public class Main {

    public static void main(String[] args) {

        Package a = new Package("A");
        Package b = new Package("B");
        Package c = new Package("C");
        Package d = new Package("D");
        Project p = new Project();

        a.addDependence(b);
        b.addDependence(c);
       // c.addDependence(a);

        d.addDependence(c);

        p.addPackage(a);
        p.addPackage(d);

        System.out.println(p.getOrderList());


    }
}
