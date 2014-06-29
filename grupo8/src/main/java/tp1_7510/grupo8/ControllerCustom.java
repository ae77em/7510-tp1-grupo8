package tp1_7510.grupo8;

import java.util.ArrayList;

public class ControllerCustom {
	ArrayList<FilterCustom> filters = new ArrayList<FilterCustom>();

	public void addFilterCustom(FilterCustom aFilterCustom){
		filters.add(aFilterCustom);
	}

	public boolean validate(){
		for (FilterCustom aFilter : filters){
			if(!aFilter.validate())
				return false;
		}
		return true;
	}
}
