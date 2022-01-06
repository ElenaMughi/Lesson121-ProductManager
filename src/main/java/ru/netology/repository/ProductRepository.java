package ru.netology.repository;

import ru.netology.domain.Product;
import java.util.Objects;

public class ProductRepository {
    private Product[] setOfItems;

    public ProductRepository(Product[] setOfItems) {
        this.setOfItems = setOfItems;
    }

    public Product[] getAll() {
        return setOfItems;
    }

    public void saveItem(Product item) {
        int length = setOfItems.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(setOfItems, 0, tmp, 0, setOfItems.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        setOfItems = tmp;
//        }
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
