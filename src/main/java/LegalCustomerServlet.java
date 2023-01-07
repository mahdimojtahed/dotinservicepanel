import com.google.gson.Gson;
import models.LegalCustomer;
import utils.DBWorker;
import utils.JsonReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "LegalCustomer", urlPatterns = {"/LegalCustomer"})
public class LegalCustomerServlet extends HttpServlet {
    public void configResponse(HttpServletResponse response) {
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
    }
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        configResponse(resp);
        Enumeration<String> params = req.getParameterNames();
        List<LegalCustomer> customersResponse = new ArrayList<>();

        String conditionQuery = "";
        if (params.hasMoreElements()) {
            String paramName = req.getParameterNames().nextElement();
            String paramVal = req.getParameter(paramName);
            conditionQuery = paramName + " = '" + paramVal + "'";
        }

        try {
            ResultSet res = DBWorker.selectLegal(conditionQuery);
            while (res.next()) {
                customersResponse.add(
                        new LegalCustomer(
                                res.getString("corpName"),
                                res.getString("registrationDate"),
                                res.getString("financialCode"),
                                res.getString("customerNumber")
                        )
                );
            }

            resp.setContentType("application/json");
            PrintWriter pw = resp.getWriter();
            String jsonResponse = gson.toJson(customersResponse);
            pw.print(jsonResponse);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        configResponse(resp);
        String str = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        LegalCustomer customer = JsonReader.handleLegalCustomer(str);


        try {
            DBWorker.createLegalTable();
            DBWorker.insertLegalData(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        configResponse(resp);
    }
}
