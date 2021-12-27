package ru.netology.manager;

import ru.netology.repository.ProductRepository;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;

public class ProductManager {

    private ProductRepository repo = new ProductRepository();

    public ProductRepository getRepo() {
        return repo;
    }

    public void addItem(Product item) {
        repo.saveItem(item);
    }

    public Product[] searchBy(String text) {
//        Product[] result = new Product[0];
        ProductRepository tmp = new ProductRepository();
        for (Product product : repo.getSetOfItems()) {
            if (matches(product, text)) {
                tmp.saveItem(product);
            }
        }
//                        System.out.println(tmp.getSetOfItems().length);
        return tmp.getSetOfItems();
    }

    public boolean matches(Product product, String textForSearch) {
        boolean result = false;
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положим его в переменную типа Book, чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(textForSearch) || book.getName().contains(textForSearch)){
            //contains(textForSearch)) { // проверим есть ли поисковое слово в данных об авторе
                result = true;
            }
        } else
            if (product instanceof Smartphone) { //тоже самое для смартфона
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getManufacturer().contains(textForSearch) || smartphone.getName().contains(textForSearch)) {
                result = true;
            }

        }
//        System.out.println("ProductManager.matches " + product.getName());
        return result;
    }
}
