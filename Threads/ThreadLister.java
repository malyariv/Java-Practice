public class ThreadLister{

   private static void printThreadInfo(Thread t, String indent){
      if (t==null) return;
      System.out.println(indent+"Поток: "+t.getName()+" Приоритет: "+t.getPriority()+(t.isDaemon()?" Демон":"")+(t.isAlive()?"":" Не активен"));
   }

   private static void printGroupInfo(ThreadGroup g, String indent) {
      if (g == null) return;
      int num_threads = g.activeCount();
      int num_groups = g.activeGroupCount();
      Thread[] threads = new Thread[num_threads];
      ThreadGroup[] groups = new ThreadGroup[num_groups];
      g.enumerate(threads, false);
      g.enumerate(groups, false);
      System.out.println(indent + " Группа потоков исполнения: " + g.getName() +" Наивысший приоритет: " + g.getMaxPriority() +(g.isDaemon()?"Демон":""));
      for(int i = 0; i < num_threads; i++) printThreadInfo(threads[i], indent + "");
      for(int i = 0; i < num_groups; i++) printGroupInfo(groups[i], indent + "");
   }

   public static void listAllThreads() {
      ThreadGroup current_thread_group;
      ThreadGroup root_thread_group;
      ThreadGroup parent;
      current_thread_group = Thread.currentThread().getThreadGroup();
      root_thread_group = current_thread_group;
      parent = root_thread_group.getParent();
      while(parent != null) {
	root_thread_group = parent;
	parent = parent.getParent();
      }
      printGroupInfo(root_thread_group, "");
   }

   public static void main(String[] args) {
      ThreadLister.listAllThreads();
   }

}
