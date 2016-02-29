package wt;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Converter converter=new Converter();
		IOTool ioTool=new IOTool();
		List<Double> valueList=(List<Double>) ioTool.readFromFile("valueList");
		List<Double> resultList=converter.convert(valueList);
		for(Double d:resultList){
			System.out.println(d);
		}
	}

}
