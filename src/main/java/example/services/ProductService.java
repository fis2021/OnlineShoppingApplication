package example.services;
import org.dizitart.no2.Nitrite;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import example.exceptions.*;
import example.model.Product;
import org.dizitart.no2.WriteResult;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;
import static example.services.FileSystemService.getPathToFile;



public class ProductService {

    private static ObjectRepository<Product> productRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("products.db").toFile())
                .openOrCreate("test", "test");

        productRepository = database.getRepository(Product.class);
    }

    public static void addProduct(String description, String size, String color, String material, String brand,int id) throws DescriptionFieldEmptyException, SizeFieldEmptyException, MaterialFieldEmptyException, ColorFieldEmptyException, BrandFieldEmptyException, MaterialFieldEmptyException {
        checkDescriptionFieldIsNotEmpty(description);
        checkSizeFieldIsNotEmpty(size);
        checkColorFieldIsNotEmpty(color);
        checkMaterialFieldIsNotEmpty(material);
        checkBrandFieldIsNotEmpty(brand);

        productRepository.insert(new Product(description, size, color, material, brand, id));

    }

    public static List<Product> getProducts()
    {
        return productRepository.find().toList();
    }



    private static void checkDescriptionFieldIsNotEmpty(String description) throws DescriptionFieldEmptyException {
        if (description.equals(""))
            throw new DescriptionFieldEmptyException();
    }

    private static void checkSizeFieldIsNotEmpty(String size) throws SizeFieldEmptyException {
        if (size.equals(""))
            throw new SizeFieldEmptyException();
    }

    private static void checkMaterialFieldIsNotEmpty(String material) throws MaterialFieldEmptyException {
        if (material.equals(""))
            throw new MaterialFieldEmptyException();
    }

    private static void checkBrandFieldIsNotEmpty(String brand) throws BrandFieldEmptyException {
        if (brand.equals(""))
            throw new BrandFieldEmptyException();
    }

    private static void checkColorFieldIsNotEmpty(String color) throws ColorFieldEmptyException {
        if (color.equals(""))
            throw new ColorFieldEmptyException();
    }
    public static boolean checkIsUnic(int id) {
        Cursor<Product> cursor = productRepository.find();
        for (Product product : cursor) {
            if (id==(product.getId())) {
                return false;
            }
        }
        return true;

    }

    public static void deleteProduct(int id) {

      for (Product product : productRepository.find()) {
          System.out.println(product.getId());

            if (id== product.getId()) {
                  productRepository.remove(product);
            }
      }





        }



    public static void editProduct(int id,String description, String size, String color, String material, String brand) {
        for (Product product : productRepository.find()) {
            if (id== product.getId())
            { product.setDescription(description);
            product.setSize(size);
            product.setMaterial(material);
            product.setColor(color);
            product.setBrand(brand);
        }
    }


}}
