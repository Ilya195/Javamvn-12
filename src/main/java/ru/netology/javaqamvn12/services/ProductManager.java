package ru.netology.javaqamvn12.services;

public class ProductManager {
    private Repository repository;
    Product[] product = new Product[0];
    // добавьте необходимые поля, конструкторы и методы

    public ProductManager(Repository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[product.length + 1];
        // тут будем хранить подошедшие запросу продукты
            for (Product product : repository.findAll()) {
                if (matches(product, text)) {
                result[result.length - 1] = product;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        //return product.getName().contains(search);
    }
}