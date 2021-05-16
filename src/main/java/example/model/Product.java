package example.model;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.util.Objects;

public class Product {
    private int id;
    private String description;
    private String material;
    private String size;
    private String color;
    private String brand;

public Product()
{

}

    public Product( String description,String size, String color,String material,String brand,int id){
        this.description=description;
        this.size=size;
        this.material=material;
        this.color=color;
		this.brand=brand;
		this.id=id;
    }

    public void setId(int id) {
       this.id = id;
   }

    public void setDescription(String description) {
        this.description = description;
    }
	public void setColor(String color) {
        this.color = color;
    }
	public void setMaterial(String material) {
        this.material = material;
    }
	public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSize(String size) {
        this.size = size;
    }


   public int getId() {
       return id;
   }

    public String getColor() {
        return color;
    }

 public String getMaterial() {
        return material;
    }
 public String getDescription() {
        return description;
    }
	 public String getBrand() {
        return brand;
    }
    public String getSize() {
        return size;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return size == product.size &&
                description.equals(product.description) &&
                material.equals(product.material)&&
				color.equals(product.color)&&
				brand.equals(product.brand);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, description, material, color, size, brand);
//    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "Id='" + id + '\'' +
//                ", Description='" + description + '\'' +
//                ", Size=" + size +
//                ", Color=" + color +
//				", Material=" + material +
//				", Brand=" + brand +
//                '}';
//    }



}
