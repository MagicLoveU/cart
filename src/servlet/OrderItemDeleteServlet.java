package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderItem;

public class OrderItemDeleteServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int pid = Integer.parseInt(request.getParameter("pid"));

		List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");

		for (OrderItem orderItem : ois) {
			if (orderItem.getProduct().getId() == pid) {
				ois.remove(orderItem);
				break;
			}
		}

		response.sendRedirect("/cart/listOrderItem");
	}
}
