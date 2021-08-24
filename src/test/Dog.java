package test;

public class Dog {
	public int food;

	public Dog(int food) {
		super();
		this.food = food;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}
	@Override
	public String toString() {
		return this.food+"";
	}
}
