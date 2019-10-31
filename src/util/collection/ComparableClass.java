package util.collection;

public class ComparableClass implements Comparable<String>{

	private String field;
	private int intFiled;

	public ComparableClass(String field,int intFiled) {
		this.field = field;
		this.intFiled = intFiled;
	}


	public String getField() {
		return field;
	}


	public void setField(String field) {
		this.field = field;
	}

	public int getIntFiled() {
		return intFiled;
	}

	public void setIntFiled(int intFiled) {
		this.intFiled = intFiled;
	}


	@Override
	public int compareTo(String arg0) {
		return  this.getField().length() < arg0.length() ? -1 : this.getField().equals(arg0) ? 0 : 1;
	}

	public int compareTo(int arg){
		return  this.getIntFiled() < arg ? -1 : this.getIntFiled() == arg ? 0 : 1;
	}

}
