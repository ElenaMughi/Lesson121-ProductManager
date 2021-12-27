package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book(1, "CoreJava", 300, "CoolProgrammer");
    private Book python = new Book(2, "Welcome to Python", 100, "MeAndI");
    private Smartphone sumsung = new Smartphone(1, "Sumsung S8", 200, "Sumsung Inc.");
    private Smartphone apple = new Smartphone(0, "IPhone 13", 1000, "Apple");

    @Test
    public void shouldAddBook() {
        ProductManager catalog = new ProductManager();
        catalog.addItem(coreJava);
        catalog.addItem(python);
        Product[] expected = new Product[]{coreJava, python};
        assertArrayEquals(expected, catalog.getRepo().getSetOfItems());
    }

    @Test
    public void shouldAddSmartphone() {
        ProductManager catalog = new ProductManager();
        catalog.addItem(sumsung);
        catalog.addItem(apple);
        Product[] expected = new Product[]{sumsung, apple};
        assertArrayEquals(expected, catalog.getRepo().getSetOfItems());
    }

    @Test
    public void shouldSearchPhone() {
        ProductManager catalog = new ProductManager();
        catalog.addItem(sumsung);
        catalog.addItem(apple);
        Product[] actual = catalog.searchBy("S8");
        Product[] expected = new Product[]{sumsung};
        assertArrayEquals(expected, actual);

        actual = catalog.searchBy("Apple");
        expected = new Product[]{apple};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBook() {
        ProductManager catalog = new ProductManager();
        catalog.addItem(coreJava);
        catalog.addItem(python);
        Product[] actual = catalog.searchBy("Java");
        Product[] expected = new Product[]{coreJava};
        assertArrayEquals(expected, actual);

        actual = catalog.searchBy("MeAndI");
        expected = new Product[]{python};
        assertArrayEquals(expected, actual);
    }
}