package com.servlet;
import com.session.zakatfitrah;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class zakatServlet extends HttpServlet {
    @EJB
    private zakatfitrah zakatfitrah;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {            
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\" />");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\" />");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-grid.css\" />");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-grid.min.css\" />");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-reboot.css\" />");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-reboot.min.css\" />");
            out.println("<script href=\"js/bootstrap.bundle.js\" > </script>");
            out.println("<script href=\"js/bootstrap.bundle.min.js\" > </script>");
            out.println("<script href=\"js/bootstrap.js\" > </script>");
            out.println("<script href=\"js/bootstrap.min.js\" > </script>");
            out.println("</head>");
            out.println("<body class=\"container\">");
            out.println("<nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\n<a class=\"navbar-brand\" href="
                    + "\"http://localhost:8080/zakatfitrah-war/zakatServlet\">Tugas RSBK Modul 2</a>\n</nav>");
            out.println("<br/>");
            out.println("<h1><center>Kelompok 24</center></h1>");
            out.println("<br/>");
            out.println("<h2><center>Aplikasi Perhitungan Zakat Fitrah</center></h2>");
            out.println("<br/>");
            String wajib = request.getParameter("wajib");
            String harga = request.getParameter("harga");
            if ((wajib != null) && (wajib.length() > 0) && (harga != null) && (harga.length() > 0)) {
                double d = Double.parseDouble(wajib);
                if (request.getParameter("Zakat Beras") != null){
                    String tagihan = zakatfitrah.perhitungan(d);
                    out.println("<div class=\"alert alert-primary\" role=\"alert\">\n  Perhitungan Berhasil\n</div>");
                    out.println("<p> Total yang harus dibayarkan sebesar "+tagihan+" Kg</p>");
                    out.println("<button type=\"button\" class=\"btn btn-secondary btn-outline-dark btn-block\"><a href=\""
                            + "http://localhost:8080/zakatfitrah-war/zakatServlet\">Kembali</a></button>");}
            }if ((wajib != null) && (wajib.length() > 0)&& (harga != null) && (harga.length() > 0)) {
                double d = Double.parseDouble(wajib);
                double w = Double.parseDouble(harga);
                if (request.getParameter("Zakat Uang") != null){
                    String tagihan = zakatfitrah.perhitunganuang(d, w);
                    out.println("<div class=\"alert alert-primary\" role=\"alert\">\n  Perhitungan Berhasil\n</div>");
                    out.println("<p> Total yang harus dibayarkan: RP. "+tagihan+"</p>");
                    out.println("<button type=\"button\" class=\"btn btn-secondary btn-outline-info btn-block\"><a href=\""
                            + "http://localhost:8080/zakatfitrah-war/zakatServlet\">Kembali</a></button>");}  
            }else {
                out.println("<center>");
                out.println("<p>Masukan Jumlah Wajib Zakat:</p>");
                out.println("<form method=\"get\">");
                out.println("<p><input type=\"text\" value=\"0\" name=\"wajib\" size=\"20\"></p>");
                out.println("<br/>");
                out.println("<p>Masukan Harga Beras per Kilogram:</p>");
                out.println("<form method=\"get\">");
                out.println("<p><input type=\"text\" value=\"0\" name=\"harga\" size=\"20\"></p>");
                out.println("<br/>");
                out.println("<input type=\"submit\" class=\"btn btn-dark\" name=\"Zakat Uang\" value=\"Zakat Uang\">");
                out.println("<br/>");                
                out.println("<br/>");
                out.println("<input type=\"submit\" class=\"btn btn-dark\" name=\"Zakat Beras\" value=\"Zakat Beras\">");}
        }finally {
            out.println("<br/>");
            out.println("</center>");
            out.println("</body>");
            out.println("</head>");
            out.println("</html>");
            out.close();}               
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);}
    @Override
    public String getServletInfo() {
        return "Short description";}
}
