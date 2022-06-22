package bg.tu_varna.sit;

public class Products {
    private String name;
    private double expire;
    private double date;
    private String manufactName;
    private int weight;
    private int quantity;
    private String location;

    public Products(String name, double expire, double date, String manufactName, int weight, int quantity, String location) {
        this.name = name;
        this.expire = expire;
        this.date = date;
        this.manufactName = manufactName;
        this.weight = weight;
        this.quantity = quantity;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }

    public String getManufactName() {
        return manufactName;
    }

    public void setManufactName(String manufactName) {
        this.manufactName = manufactName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", expire=" + expire +
                ", date=" + date +
                ", manufactName='" + manufactName + '\'' +
                ", weight=" + weight +
                ", quantity=" + quantity +
                ", location=" + location +
                '}' + "\n";
    }
}
