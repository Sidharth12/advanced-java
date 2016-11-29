
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("EmpId"));
        String name = request.getParameter("EmpName");
        int phone = Integer.parseInt(request.getParameter("EmpPhone"));
        int age = Integer.parseInt(request.getParameter("EmpAge"));
        float sal = Float.parseFloat(request.getParameter("EmpSal"));
        String mail = request.getParameter("EmpMail");
        String cship = request.getParameter("EmpCZ");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("Employee id is :" + id);
            out.println("<br>");
            out.println("Employee name is :" + name);
            out.println("<br>");
            out.println("Employee phone is :" + phone);
            out.println("<br>");
            out.println("Employee age is :" + age);
            out.println("<br>");
            out.println("Employee sal is :" + sal);
            out.println("<br>");
            out.println("Employee mail is :" + mail);
            out.println("<br>");
            out.println("Employee citizenship is :" + cship);
            out.println("<br>");

            if (age > 30) {
                sal = sal + 3500;
            }
            out.println("Employee sal after checking age is :" + sal);
            out.println("<br>");
            if (cship != "indian") {
                sal = sal - (sal * 0.1f);
            }
            out.println("Employee salary if citizen is not indian :" + sal);
            if (!mail.contains("niit.com")) {
                out.println("Invalid email id");
                out.println("<br>");
            }
            File fin = new File("C:\\Users\\oltuser01\\Documents\\mydata.txt");
            FileOutputStream fos = new FileOutputStream(fin);
            fos.write(id);
            fos.write(name.getBytes());
            fos.write(phone);
            fos.write(age);
            fos.write((int) sal);
            fos.write(mail.getBytes());
            fos.write(cship.getBytes());

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
