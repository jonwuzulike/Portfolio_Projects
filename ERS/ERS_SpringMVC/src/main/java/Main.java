import java.math.BigDecimal;

import com.ers.dao.UserDAOImpl;
import com.ers.models.User;

public class Main {
	
	public static void main(String[] args) {
		UserDAOImpl dao = new UserDAOImpl();
//		User ur = dao.getUserById(3);
//		System.out.println(ur);
		
		dao.getAllUsers();
	}

}
