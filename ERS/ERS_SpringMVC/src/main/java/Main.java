

import com.ers.dao.ReimbursementDAO;
import com.ers.dao.ReimbursementDAOImpl;
import com.ers.dao.UserDAOImpl;
import com.ers.models.User;

public class Main {
	
	public static void main(String[] args) {
//		UserDAOImpl dao = new UserDAOImpl();
//		User ur = dao.getUserById(3);
//		System.out.println(ur);
//		
//		dao.getAllUsers();
//		
//		dao.userLogin("dcraig@m6.com", "dc123");
		
		ReimbursementDAO dao = new ReimbursementDAOImpl();
//		dao.getAll();
		
		dao.getByUser(2);
	}

}
