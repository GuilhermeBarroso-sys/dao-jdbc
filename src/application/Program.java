package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("Seller findById");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println("-------------------");
		System.out.println("Seller findByDepartment");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj: list) {
			System.out.println(obj);
		}
		System.out.println("-------------------");
		System.out.println("Seller findAll");
		list = sellerDao.findAll();
		for(Seller obj: list) {
			System.out.println(obj);
		}
		Seller newSeller = new Seller(null, "Bob", "Bob@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("-------------------");
		System.out.println("Seller insert:");
		System.out.println("Inserted! New id = " + newSeller.getId());
		System.out.println("-------------------");
		System.out.println("Seller updated:");
		seller = sellerDao.findById(1);
		seller.setName("Bruce Brown");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		
		
		
	}
}
