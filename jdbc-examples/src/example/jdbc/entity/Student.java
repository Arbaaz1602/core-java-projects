package example.jdbc.entity;

public class Student {
	
	private int roll;
	private String name;
	private float Percent;

	public Student() {
		
	}

	public Student(int roll, String name, float percent) {
		super();
		this.roll = roll;
		this.name = name;
		this.Percent = percent;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPercent() {
		return Percent;
	}

	public void setPercent(float percent) {
		Percent = percent;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", Percent=" + Percent + "]";
	}
	

}
