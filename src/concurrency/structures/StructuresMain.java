package concurrency.structures;

public class StructuresMain
{
    public static void main(String[] args)
    {
        Queue<Integer> l = new Queue<>();

        Thread producer = new Thread()
        {
            public void run()
            {
                try
                {
                    l.add(1);
                    Thread.sleep(1000L);
                    l.add(2);
                    l.add(3);
                    Thread.sleep(3000L);
                    l.add(4);
                    l.add(5);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };
        Thread consumer = new Thread()
        {
            public void run()
            {
                System.out.println(l.remove());
                System.out.println(l.remove());
                System.out.println(l.remove());
                System.out.println(l.remove());
                System.out.println(l.remove());
            }
        };
        producer.setName("Producer");
        consumer.setName("Consumer");
        producer.start();
        consumer.start();
    }
}
