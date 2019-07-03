package dz.digitalgrowing.training.jee.example.web.service;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;

public class AsyncService implements Runnable {

  private AsyncContext ac;

  public AsyncService(AsyncContext ac) {
    this.ac = ac;
  }

  @Override
  public void run() {

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
      PrintWriter out = ac.getResponse().getWriter();
      out.write("AsyncService completed processing!");
      System.out.println("AsyncService completed processing! Thread Name=" + Thread .currentThread().getName());
    } catch (IOException e) {
      e.printStackTrace();
    }

    ac.complete();
  }


}