package Lab1;

import java.util.NoSuchElementException;

public class Uppg1 {

	private String[] strings;
	private int logicSize;
	private int p;

	public Uppg1() {
		strings = new String [10];
	}
	public Uppg1(int size) {
		strings = new String [size];
	}

	public void addFirst(String element){
		if (isFull()){	
			doubleCapacity();
		}
		for(int i=logicSize-1;i>=0;i--){
			strings[i+1]=strings[i];
		}
		strings[0]=element;
		logicSize++;
	}

	public boolean empty(){

		return logicSize==0;
	}	

	public String getFirst() throws NoSuchElementException {
		if (this.empty()){
			throw new NoSuchElementException();
		}
		return strings [0];



	}
	public void removeFirst(){
		if (this.empty()){
			return;
		}
		int i=1;
		do {			
			strings[i-1] = strings[i];
			i++;
		}
		while (i<logicSize);

		strings [i] = null;
		logicSize--;
	}

	public boolean existP(String elem) {
		for(int i = 0; i<logicSize;i++){
			if(elem.equals(strings[i])){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString(){
		if (empty()){
			return "";
		}
		else {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("[ " + strings[0]);
			for(int i = 1; i<logicSize; i++){
				stringBuilder.append(", " + strings [i]);
			}
			stringBuilder.append(" ]");
			return "" + stringBuilder;
		}
	}
	
	public void setP(int p) throws IndexOutOfBoundsException{
		if (p<0){
			throw new IndexOutOfBoundsException("Index must be a positive integer");
		}
		this.p = p;
	}
	
	public boolean hasNext(int p){
		return (p<logicSize);
	}

	private boolean isFull(){
		return (strings.length == logicSize);
	}
	private void doubleCapacity(){
		String[] stringsTmp = new String [strings.length*2];
		System.arraycopy(strings, 0, stringsTmp, 0, logicSize);
		strings = stringsTmp;
	}

	

}
