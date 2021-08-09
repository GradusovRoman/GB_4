package com.geekbrains.app;

import com.geekbrains.app.Domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;


public class StoreListServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(StoreListServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        List<Product> storeListItems = getProductList();
        for (Product storeListItem : storeListItems) {
            int id = storeListItem.getId();
            String title = storeListItem.getTitle();
            double cost = storeListItem.getCost();
            out.println("<html><body><h4>" + String.format("ID %d |  Title: %s  | price: %f rub", id, title, cost) + "</h4></body></html>");
        }
        out.close();

    }
    public List<Product> getProductList() {
        return Arrays.asList(

                new Product(1, "milk",60 ),
                new Product(2, "bread", 40),
                new Product(3, "orange", 90),
                new Product(4, "banana", 95),
                new Product(6, "meat", 350),
                new Product(7, "apple", 100),
                new Product(8, "onion", 30),
                new Product(9, "juice", 120),
                new Product(10, "butter", 150)

        );
    }
}



