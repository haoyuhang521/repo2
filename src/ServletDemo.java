import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class ServletDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        Map<String,Object> map =new HashMap<>();
        if ("tom".equals(username)){
                //返回{"userExsit":true,"msg":"该用户太受欢迎，已被注册"}
            map.put("userExsit",true);
            map.put("msg","该用户太受欢迎，已被注册");

            }else {
            map.put("userExsit",false);
            map.put("msg","用户名可用");
            }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
