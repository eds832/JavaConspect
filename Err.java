import java.util.ArrayList;
import java.util.List;

public class Err {
	public static void main(String... args) {
		Thread th = new Thread() {
			public void run() {
				loop(1);
			}

			public void loop(long i) {
				if (i % 1100 == 1000) {
					System.out.println(i);
				}
				loop(i + 1);
			}
		};
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			list.add(new String(new Double(Math.random()).toString()));
			if (list.size() % 13000000 == 10000000) {
				System.out.println(list.size() + " "
			+ list.get(list.size() - 1) + " " + th.getState() + " "
						+ Runtime.getRuntime().freeMemory() / 1024 / 1024 + " "
						+ Runtime.getRuntime().totalMemory() / 1024 / 1024 + " "
						+ Runtime.getRuntime().maxMemory() / 1024 / 1024);
				if (th.getState() == Thread.State.NEW) {
					th.start();
				}
			}
		}
	}
}
