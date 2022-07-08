package ru.netology.javaqamvn12.services;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product product1 = new Product(11,"Овощи",250,"P1");
    Product product2 = new Product(12,"Фрукты",300,"P2");
    Product product3 = new Product(13,"Батон",120,"3");
    Product product4 = new Product(14,"Молоко",290,"P4");
    Product product5 = new Product(15,"Мясо",540,"P5");
    Book book = new Book(16,"Книга",330,"Алхимик","Коэльо");
    Smartphone smart = new Smartphone(17,"Galaxy",5000,"Edge","Samsung");



    @Test
    public void saveProducts() {
        Repository repository = new Repository();
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);

        Product[] expected  = {product1,product2,product3,product4,product5};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void showRemoveBuId() {
        Repository repository = new Repository();
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);
        repository.removeById(product1.getId());
        repository.removeById(product5.getId());

        Product[] expected  = {product2,product3,product4};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void showMeSetGetAuthor() {
        book.setAuthor("Коэльо");

        String expected = ("Коэльо");
        String actual = book.getAuthor();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void showMeSetGetSmart() {
        smart.setManufacturer("Samsung");

        String expected = ("Samsung");
        String actual = smart.getManufacturer();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void showMeSetGetId() {
        product3.setId(13);

        int expected = 13;
        int actual = product3.getId();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void showMeSetGetPrice() {
        product5.setPrice(540);

        int expected = 540;
        int actual = product5.getPrice();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void showMeSetGetName() {
        smart.setName("Galaxy");

        String expected = ("Galaxy");
        String actual = smart.getName();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void showAllAdd() {
        Repository repository = new Repository();
        ProductManager product = new ProductManager(repository);
        product.add(product1);
        product.add(product2);
        product.add(product3);
        product.add(product4);
        product.add(product5);
        product.add(book);
        product.add(smart);

        Product[] expected = {product1, product2, product3, product4, product5,book,smart};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showSearchByProduct() {
        Repository repository = new Repository();
        ProductManager product = new ProductManager(repository);
        product.add(product1);
        product.add(product2);
        product.add(product3);
        product.add(product4);
        product.add(product5);
        product.add(book);

        Product[] expected = {product1};
        Product[] actual = product.searchBy("Овощи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showMeMatches() {
        Repository repository = new Repository();
        ProductManager product = new ProductManager(repository);
        product.matches(product2, product2.name);

        Product[] expected = {};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }
}
