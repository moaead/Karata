import java.util.ArrayList;

class NegativeException extends Exception {

	  public NegativeException(String msg) {
		super(msg);
	}
}

public class Calculator {
	
	public int Calc(String data) throws NumberFormatException, NegativeException{
		if(data.startsWith("//")){
			if(!data.contains("[")){
				int newLinePos =  data.indexOf("\n");
				String deleminator = data.substring(2, newLinePos);
				String numbers = data.substring(newLinePos+1);
				return this.AddWithSingleDelems(numbers, deleminator);
			}else{
				ArrayList<String> delems = new ArrayList<String>();
				int pos1 = data.indexOf("[");
				while(pos1 >= 2){
					int pos2 = data.indexOf("]", pos1);
					String delem = data.substring(pos1 + 1, pos2);
					delems.add(delem);
					pos1 = data.indexOf("[", pos1+1);
				}
				
				String numbers = data.substring(data.indexOf("\n"));
				return this.AddWithMultipleDelems(numbers, delems);
			}
			
		}else{
			try {
				return this.Add(data);
			} catch (NegativeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;
	}
	
	public int Add(String numbers) throws NegativeException{
		ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();
		if(numbers.contains("\n")){
			numbers = numbers.replace("\n", ",");
		}
			String[] arr = numbers.split(",");
			int sum = 0;
			for(int i = 0;i<arr.length;i++){
				try{
					int n = Integer.valueOf(arr[i].replace("\n", ""));
					//System.out.println(n);
					if(n < 0)
						negativeNumbers.add(n);
					if(n > 1000)
						sum+= n % 1000;
					else
						sum+= n;
					
				}catch(Exception e){
					sum+= 0;
				}
			}
			
			if(negativeNumbers.size() >= 1)
				throw new NegativeException(negativeNumbers.toString());
			
			return sum;
		
	}
	public int AddWithMultipleDelems(String numbers, ArrayList<String> delems) throws NegativeException
	{
		for(int i = 0;i<delems.size();i++){
			numbers = numbers.replace(delems.get(i), ",");
		}
		
		return Add(numbers);
	}
	
	public int AddWithSingleDelems(String numbers, String delem) throws NegativeException
	{
		
			numbers = numbers.replace("\n", ",").replace(delem, ",");		
			//System.out.println(numbers);
			return Add(numbers);
	}
}
