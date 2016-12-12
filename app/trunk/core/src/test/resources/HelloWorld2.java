import java.util.Date;

public class HelloWorld2 implements Runnable
{
  @Override
  public void run()
  {
    Date date = new Date();
    System.out.println("[" + date + "] Hello World 2 !");
  }
}