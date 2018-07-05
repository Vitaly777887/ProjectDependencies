import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Project {
    private String name;
    private List<Package> packages = new LinkedList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void addPackage(Package aPackage) {
        packages.add(aPackage);
    }

    public boolean hasCycle() {
        List<Package> packagesList = new LinkedList<>();

        for (Package aPackage : packages) {
            if (hasCycle(aPackage, packagesList)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(Package pack, List<Package> packagesList) {

        if (packagesList.contains(pack)) {
            return true;
        }
        packagesList.add(pack);

        for (Package aPackage : pack.getDependencies()) {
            if (hasCycle(aPackage, packagesList)) {
                return true;
            }
        }
        packagesList.remove(pack);
        return false;
    }

    private List<Package> getOrderList(Package aPackage) {

        if (hasCycle()) {
            throw new RuntimeException("Dependencies has cycle");
        }
        List<Package> result = new LinkedList<>();

        for (Package aPackage1 : aPackage.getDependencies()) {
            result.addAll(getOrderList(aPackage1));
        }
        result.add(aPackage);
        return result;
    }

    public List<Package> getOrderList() {
        List<Package> result = new LinkedList<>();

        for (Package aPackage1 : packages) {
            result.addAll(getOrderList(aPackage1));

        }
        return result.stream().distinct().collect(Collectors.toList());
    }
}
