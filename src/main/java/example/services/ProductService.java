package example.services;
import org.dizitart.no2.Nitrite;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import example.exceptions.*;
import example.model.Product;
import org.dizitart.no2.objects.ObjectRepository;
import static example.services.FileSystemService.getPathToFile;

public class ProductService {

    private static ObjectRepository<Product> productRepository;

    public static void initDatabase() {
        Nitrite db = Nitrite.builder()
                .filePath(getPathToFile("products.db").toFile())
                .openOrCreate("test", "test");

        productRepository = db.getRepository(Product.class);
    }

    public static void addProduct(String description, String size, String color, String material, String brand) throws DescriptionFieldEmptyException, SizeFieldEmptyException, MaterialFieldEmptyException, ColorFieldEmptyException, BrandFieldEmptyException, MaterialFieldEmptyException {
        checkDescriptionFieldIsNotEmpty(description);
        checkSizeFieldIsNotEmpty(size);
        checkColorFieldIsNotEmpty(color);
        checkMaterialFieldIsNotEmpty(material);
        checkBrandFieldIsNotEmpty(brand);

        productRepository.insert(new Product(description, size, color, material, brand));
    }



    public static List<Product> getProducts(){
        List<Product> productList = new ArrayList<>();
        for (Product product : productRepository.find()) {
            productList.add(product);
        }
        return productList;
    }

    public static Product getProduct(String id)throws ProductDoesNotExistException{
        for (Product product : productRepository.find()) {
            if (Objects.equals(id, product.getId()))
               return product;
        }
        throw new ProductDoesNotExistException();
    }




    private static void checkDescriptionFieldIsNotEmpty(String description) throws DescriptionFieldEmptyException{
        if(description.equals(""))
            throw new DescriptionFieldEmptyException();
    }
    private static void checkSizeFieldIsNotEmpty(String size) throws SizeFieldEmptyException{
        if(size.equals(""))
            throw new SizeFieldEmptyException();
    }
	  private static void checkMaterialFieldIsNotEmpty(String material) throws MaterialFieldEmptyException {
        if(material.equals(""))
            throw new MaterialFieldEmptyException();
    }
	
	  private static void checkBrandFieldIsNotEmpty(String brand) throws BrandFieldEmptyException{
        if(brand.equals(""))
            throw new BrandFieldEmptyException();
    }
	
	  private static void checkColorFieldIsNotEmpty(String color) throws ColorFieldEmptyException{
        if(color.equals(""))
            throw new ColorFieldEmptyException();
    }


//    public static void removeProduct(String id){
//        for (Product product : productRepository.find()) {
//            if (Objects.equals(id, product.getId()))
//                productRepository.remove(product);
//        }
//    }


}
