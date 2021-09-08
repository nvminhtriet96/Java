package clone;

public class Employee {
	public static void main(String[] args) {
		var test = new englishruler();
		test.drawruler(3, 3);
	}
}

class englishruler {
	public void drawruler(int soinch, int sovach) {
		vevach(sovach, 0);
		for (int j = 1; j < soinch; j++) {
			khoangcach(soinch - 1);
			vevach(sovach, j);
		}
	}

	private void khoangcach(int sovach2) {
		if (sovach2 >= 1) {
			khoangcach(sovach2 - 1);
			vevach(sovach2);
			khoangcach(sovach2 - 1);
		}
	}

	private void vevach(int sovach1, int mavach) {
		for (int i = 0; i <= sovach1; i++) {
			System.out.print("-");
		}
		if (mavach >= 0)
			System.out.print(" " + mavach);
		System.out.print("\n");
	}

	private void vevach(int sovach3) {
		vevach(sovach3, -1);
	}

}