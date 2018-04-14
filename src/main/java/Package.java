import java.util.LinkedList;
import java.util.List;

public class Package {
    private String name;
    private List<Package> dependencies = new LinkedList<Package>();

    public String getName() {
        return name;
    }

    public Package(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Package> getDependencies() {
        return dependencies;
    }

    public void addDependence(Package aPackage) {
        dependencies.add(aPackage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Package aPackage = (Package) o;

        return name != null ? name.equals(aPackage.name) : aPackage.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Package{" +
                "name='" + name + '\'' +
                '}';
    }
}
