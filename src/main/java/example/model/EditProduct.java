package example.model;



import java.util.Date;

public class EditProduct {
   
    private Date date;
    private Product product;
    public EditProduct(){}
    public EditProduct(Product p){
        date=new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    @Override
    public String toString() {
        return "Informatii produs{" +
                "date=" + date +
                ", produs=" + product +
                '}';
    }
}
