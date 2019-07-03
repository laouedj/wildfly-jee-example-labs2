package dz.digitalgrowing.training.jee.example.web.servlet;

import dz.digitalgrowing.training.jee.example.web.listener.ExampleAsyncListener;
import dz.digitalgrowing.training.jee.example.web.service.AsyncService;
import java.io.IOException;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "async", urlPatterns = { "/async" }, asyncSupported = true)
public class AsyncServlet extends HttpServlet {

  private static final long serialVersionUID = -1003975910993475413L;

  @Resource(name = "DefaultManagedExecutorService") ManagedExecutorService executor;


  public void init() throws ServletException {
    System.out.println("Init ..... dz.digitalgrowing.training.jee.example.web.servlet.AsyncServlet Servlet ....");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    long startTime = System.currentTimeMillis();
    System.out.println("dz.digitalgrowing.training.jee.example.web.servlet.AsyncServlet Start, Thread Name="+ Thread.currentThread() .getName());
    AsyncContext ac = request.startAsync();
    ac.addListener(new ExampleAsyncListener());
    ac.setTimeout(15000);
    System.out.println("Async Supported? " + ac.getRequest().isAsyncSupported());
    executor.execute(new AsyncService(ac));
    long endTime = System.currentTimeMillis();
    System.out.println("AsyncLongRunningServlet End, Thread Name=" + Thread .currentThread().getName() + ",Time Taken=" + (endTime - startTime) + " ms.");
  }
}
