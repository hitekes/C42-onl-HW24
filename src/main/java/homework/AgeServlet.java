package homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ageServlet", urlPatterns = "/age")
public class AgeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("Передайте возраст параметром, например:");
        out.println("  GET  /age?age=20");
        out.println("  POST /age  (параметр age)");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String ageParam = req.getParameter("age");

        if (ageParam == null || ageParam.trim().isEmpty()) {
            out.println("Ошибка: возраст не указан");
            return;
        }

        try {
            int age = Integer.parseInt(ageParam.trim());

            if (age < 0 || age > 150) {
                out.println("Ошибка: возраст должен быть в диапазоне 0–150");
            } else if (age >= 18) {
                out.println("Возраст: " + age + " — совершеннолетний");
            } else {
                out.println("Возраст: " + age + " — несовершеннолетний");
            }
        } catch (NumberFormatException e) {
            out.println("Ошибка: введите корректное число");
        }
    }
}
