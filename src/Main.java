import java.util.ArrayList;

class TriArray<T> {
	private int cnt;
	private ArrayList<T> arr;

	public TriArray(int n) {
		arr = new ArrayList<T>((n * (n + 1)) >> 1);
		cnt = n;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public void fill(int a , T b){
		arr.add(a, b);
	}
	public int elements() {
		return ((cnt*(cnt+1))>>1);
	}
	public void showArrInTriangle(int n) {

		for (int x = 0; x <= n; x++) {
			for (int y = (x * (x + 1) >> 1); y < ((x + 1) * (x + 2) >> 1); y++) {
				System.out.print(y + " ");

				if (x == n)
					break;
			}
			System.out.println();
		}
	}

	public T get(int x, int y) throws IndexOutOfBoundsException {
		if (x > y)
			throw new IndexOutOfBoundsException();
		if (((y * (y + 1)) >> 1) > ((cnt * (cnt + 1)) >> 1))
			throw new IndexOutOfBoundsException();

		int position = ((y * (y + 1)) >> 1) + x;
		T a = arr.get(position);
		return a;
	}
	 public void set(int x, int y, T a) throws IndexOutOfBoundsException{
		 if (x > y)
				throw new IndexOutOfBoundsException();
		 if (((y * (y + 1)) >> 1) > ((cnt * (cnt + 1)) >> 1))
				throw new IndexOutOfBoundsException();
			
		 int position = ((y * (y + 1)) >> 1) + x;
		arr.add(position, a);	
	
	 }

	@Override
	public String toString() {
		String s="";
		for( int i = 0 ; i<= elements(); i++) {
			s+= arr.get(i)+ " ";
		}
		return s;
	}
	 
	 
}

public class Main {

	public static void main(String[] args) {
		TriArray<Integer> t = new TriArray<Integer>(new Integer(5));
		t.showArrInTriangle(5);
		for (int y = 0 ; y<= (t.getCnt() * (t.getCnt() + 1) >> 1);  y++) {
			t.fill(y, y);
		}
		System.out.println();
		System.out.println(t.get(2, 4));
		System.out.println(t.toString());
		t.set(2,3 , 99);
		System.out.println(t.toString());
		
		
	}

}
