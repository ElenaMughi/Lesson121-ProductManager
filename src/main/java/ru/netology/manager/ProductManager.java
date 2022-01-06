package ru.netology.manager;

import ru.netology.repository.ProductRepository;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;

public class ProductManager {

    private ProductRepository repository;

    public ProductManager(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    public ProductRepository getRepository() {
        return repository;
    }

    public void addItem(Product item) {
        repository.saveItem(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];

        for (Product product : repository.getAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }

        return result;
    }

    public boolean matches(Product product, String textForSearch) {
//        boolean result = false;
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положим его в переменную типа Book, чтобы пользоваться методами класса Book
            return book.getAuthor().contains(textForSearch) || book.getName().contains(textForSearch);

        } else if (product instanceof Smartphone) { //тоже самое для смартфона
            Smartphone smartphone = (Smartphone) product;
            return smartphone.getManufacturer().contains(textForSearch) || smartphone.getName().contains(textForSearch);
        } else {
            return product.getName().contains(textForSearch);
        }
    }
}
