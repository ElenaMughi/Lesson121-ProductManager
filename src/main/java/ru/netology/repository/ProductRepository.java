package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import java.util.Objects;

public class ProductRepository {
    private Product[] setOfItems = new Product[0];

    public Product[] getSetOfItems() {
        return setOfItems;
    }

    public void saveItem(Product item) {
        int length = setOfItems.length + 1;

        if (item instanceof Book) {
            Book[] tmp = new Book[length];
            System.arraycopy(setOfItems, 0, tmp, 0, setOfItems.length);
            int lastIndex = tmp.length - 1;
            tmp[lastIndex] = (Book) item;
            setOfItems = tmp;
        } else if (item instanceof Smartphone) {
            Smartphone[] tmp = new Smartphone[length];
            System.arraycopy(setOfItems, 0, tmp, 0, setOfItems.length);
            int lastIndex = tmp.length - 1;
            tmp[lastIndex] = (Smartphone) item;
            setOfItems = tmp;
        } else {
            Product[] tmp = new Product[length];
            System.arraycopy(setOfItems, 0, tmp, 0, setOfItems.length);
            int lastIndex = tmp.length - 1;
            tmp[lastIndex] = item;
            setOfItems = tmp;
        }
    }

    public void removeById(int id) {
        int length = setOfItems.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : setOfItems) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        setOfItems = tmp;
    }

}
