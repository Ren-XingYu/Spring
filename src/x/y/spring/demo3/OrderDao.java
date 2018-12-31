package x.y.spring.demo3;

public class OrderDao {
    public void find() {
        System.out.println("find order");
        //int i=1 / 0;
    }

    public void update() {
        System.out.println("update order");
    }

    public void save() {
        System.out.println("save order");
    }

    public String delete() {
        System.out.println("delete order");
        return "delete";
    }
}
