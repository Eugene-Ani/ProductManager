package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    //private ProductRepository repository = new ProductRepository();
    private final ProductManager manager = new ProductManager(new ProductRepository());

    private final Book firstBook = new Book(1, "Мир на Земле", 800, "Станислав Лем");
    private final Book secondBook = new Book(2, "Проклятые экономики", 1500, "Андрей Мовчан");
    private final Book thirdBook = new Book(3, "Дэнс, дэнс, дэнс", 450, "Харуки Мураками");
    private final Book fourthBook = new Book(3, "Норвежский лес", 1050, "Харуки Мураками");
    private final Smartphone firstSmartphone = new Smartphone(4, "Xiaomi", 8000, "Xiaomi Corporation");
    private final Smartphone secondSmartphone = new Smartphone(5, "Nokia", 20000, "Foxconn");

    @BeforeEach
    void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(fourthBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
    }

    @Test
    public void shouldReturnByNamesBook() {
        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.searchBy("Проклятые экономики");
        assertArrayEquals(expected, actual);
        for (Product product : actual) {
            System.out.println(product);
        }
    }

    @Test
    public void shouldReturnByAuthorsBooks() {
        Product[] expected = new Product[]{thirdBook, fourthBook};
        Product[] actual = manager.searchBy("Харуки Мураками");
        assertArrayEquals(expected, actual);
        for (Product product : actual) {
            System.out.println(product);
        }
    }

    @Test
    public void shouldReturnByNamesSmartphone() {
        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
        for (Product product : actual) {
            System.out.println(product);
        }
    }

    @Test
    public void shouldReturnByManufacturesSmartphone() {
        Product[] expected = new Product[]{secondSmartphone};
        Product[] actual = manager.searchBy("Foxconn");
        assertArrayEquals(expected, actual);
        for (Product product : actual) {
            System.out.println(product);
        }
    }

    @Test
    public void shouldFindsNothing() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Iphone");
        assertArrayEquals(expected, actual);
        for (Product product : actual) {
            System.out.println(product);
        }
    }
}