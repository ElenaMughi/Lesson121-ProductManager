package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private Product[] setOfItems = new Product[0];
    private ProductRepository repository = new ProductRepository(setOfItems);
    private ProductManager catalog = new ProductManager(repository);
    private Book coreJava = new Book(1, "CoreJava", 300, "CoolProgrammer");
    private Book python = new Book(2, "Welcome to Python", 100, "MeAndI");
    private Smartphone sumsung = new Smartphone(1, "Sumsung S8", 200, "Sumsung Inc.");
    private Smartphone apple = new Smartphone(0, "IPhone 13", 1000, "Apple");
    private Product glass = new Product(1, "Glass", 50);
    private Product plate = new Product(2, "Blue plate", 100);

    @Test
    public void shouldSearchPhoneName() {
        catalog.addItem(sumsung);
        catalog.addItem(apple);
        Product[] actual = catalog.searchBy("S8");
        Product[] expected = new Product[]{sumsung};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchPhoneFabric() {
        catalog.addItem(sumsung);
        catalog.addItem(apple);
        Product[] actual = catalog.searchBy("Apple");
        Product[] expected = new Product[]{apple};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchPhoneTwoFabric() {
        catalog.addItem(sumsung);
        catalog.addItem(apple);
        Smartphone apple2 = new Smartphone(2, "IPhone 2", 1000, "Apple");
        catalog.addItem(apple2);
        Product[] actual = catalog.searchBy("Apple");
        Product[] expected = new Product[]{apple, apple2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookName() {
        catalog.addItem(coreJava);
        catalog.addItem(python);
        Product[] actual = catalog.searchBy("Java");
        Product[] expected = new Product[]{coreJava};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookAuthor() {
        catalog.addItem(coreJava);
        catalog.addItem(python);
        Product[] actual = catalog.searchBy("MeAndI");
        Product[] expected = new Product[]{python};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookNothing() {
        catalog.addItem(coreJava);
        catalog.addItem(python);
        Product[] actual = catalog.searchBy("Delphi");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProduct() {
        catalog.addItem(plate);
        catalog.addItem(glass);
        Product[] actual = catalog.searchBy("Blue");
        Product[] expected = new Product[]{plate};
//        System.out.println(actual[0].getName());
        assertArrayEquals(expected, actual);
    }
}