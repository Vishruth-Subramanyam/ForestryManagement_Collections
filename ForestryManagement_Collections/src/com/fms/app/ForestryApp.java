package com.fms.app;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.fms.beans.Address;
import com.fms.beans.Contract;
import com.fms.beans.Customer;
import com.fms.beans.Haulier;
import com.fms.beans.Order;
import com.fms.beans.Product;
import com.fms.datavalidation.Validate;
import com.fms.exception.InvalidDateException;
import com.fms.exception.InvalidIdException;
import com.fms.forestryservices.ForestryServices;
import com.fms.forestryservices.ForestryServicesImpl;
import com.fms.repository.AddressRepository;
import com.fms.repository.AdminRepository;
import com.fms.repository.ContractRepository;
import com.fms.repository.CustomerRepository;
import com.fms.repository.HaulierRepository;
import com.fms.repository.OrderRepository;
import com.fms.repository.ProductRepository;


public class ForestryApp {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ForestryServices services=new ForestryServicesImpl();

		AddressRepository addressRepository=new AddressRepository();
		CustomerRepository customerRepository=new CustomerRepository();
		ProductRepository productRepository=new ProductRepository();
		HaulierRepository haulierRepository = new HaulierRepository();
		ContractRepository contractRepository = new ContractRepository();
		OrderRepository orderRepository= new OrderRepository();
		AdminRepository adminRepository= new AdminRepository();
		Scanner input= new Scanner(System.in);
		Validate validate= new Validate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		while(true) {
			System.out.println("************************************ FOREST MANAGEMENT SYSTEM *************************************************");
			System.out.println("1.Customer");
			System.out.println("2.Admin");
			System.out.println("3.Exit aplication");
			System.out.println("Enter your Choice:");



			String homeChoice=input.next();
			while(!validate.IdValidation(homeChoice)) {
				try {
					throw new InvalidIdException();

				}catch(InvalidIdException e) {
					System.out.println("Enter your Choice:");
					homeChoice=input.next();

				}

			}

			switch(Integer.parseInt(homeChoice)) {
			case 1: 
				while(true) {
					System.out.println("************************************ LOGIN / REGISTER *************************************************");
					System.out.println("1.login");
					System.out.println("2.Register");
					System.out.println("3.Go Back to Home");
					System.out.println("Enter your Choice:");
					String customerChoice= input.next();
					while(!validate.IdValidation(customerChoice)) {
						try {
							throw new InvalidIdException();

						}catch(InvalidIdException e) {
							System.out.println("Enter your Choice:");
							customerChoice=input.next();

						}

					}
					System.out.println("******************************************************************");
					switch(Integer.parseInt(customerChoice) ){

					case 1: while(true) {
						//						LOGIN Customer
						System.out.println("Customer ID:");

						String customerID=input.next();
						while(!validate.IdValidation(customerID)) {
							try {
								throw new InvalidIdException();

							}catch(InvalidIdException e) {
								System.out.println("Enter correct ID:");
								customerID=input.next();

							}

						}

						System.out.println("Password:");
						String password=input.next();


						String customerWant = null;
						//						Check Login Credentials
						if(services.loginCustomer(Integer.parseInt(customerID), password)) {
							System.out.println("Login Successful");
							System.out.println("************************************************ LOGIN *********************************************************");
							while(true) {
								System.out.println("1.Edit profile");
								System.out.println("2.View my order");
								System.out.println("3.cancel my order");
								System.out.println("4.Make new Order");
								System.out.println("5.View my Contract");
								System.out.println("6.cancel my Contract");
								System.out.println("7.Make new Contract");

								System.out.println("8.Delete my Account");
								System.out.println("9.LogOut ");
								System.out.println("Enter your Choice:");

								customerWant=input.next();
								while(!validate.IdValidation(customerWant)) {
									try {
										throw new InvalidIdException();

									}catch(InvalidIdException e) {
										System.out.println("Enter your Choice:");
										customerWant=input.next();

									}

								}


								switch(Integer.parseInt(customerWant)) {
								case 1:
									//									MODIFY
									Customer modifyCustomer=new Customer();
									modifyCustomer.setCustomerId(Integer.parseInt(customerID));
									System.out.println("Enter Customer Name");

									modifyCustomer.setCustomerName(input.next());
									System.out.println("Enter Customer Email");
									modifyCustomer.setEmail(input.next());
									System.out.println("Enter Customer Password");
									modifyCustomer.setPassword(input.next());
									System.out.println("Enter Customer Address Details");
									Address address=new Address();
									System.out.println("Enter Flat no");
									address.setFlatNumber(input.next());
									System.out.println("Enter Street Address");
									address.setStreetAddress(input.next());
									System.out.println("Enter City");
									address.setTownCity(input.next());
									System.out.println("Enter State");
									address.setState(input.next());
									System.out.println("Enter Country");
									address.setCountry(input.next());
									System.out.println("Enter PostCode");
									address.setPostCode(input.nextInt());
									modifyCustomer.setAddress(address);
									System.out.println("Enter Telephone");
									modifyCustomer.setTelephoneNo(input.nextLong());
									if(services.modifyCustomer(modifyCustomer)) {
										System.out.println("Modified Successful");
										break;
									}
									System.out.println("Modified Failed");
									break;
								case 2:
									System.out.println("Enter Order ID to View:");
									Integer orderID= input.nextInt();
									Order order=services.searchOrder(orderID);
									if(order!=null) {
										System.out.println(order);
										break;

									}
									System.out.println("No such Order");

									break;
								case 3:
									System.out.println("Enter Order ID to Cancel:");
									Integer cancelOrder= input.nextInt();
									if(services.deleteOrder(cancelOrder)) {
										System.out.println("Order is Cancelled");
										break;
									}
									System.out.println("Failed to Cancel order");
									break;
								case 4:

									List<Product> productsList=services.displayAllProduct();

									Boolean state=false;

									for(Product productList:productsList) {
										System.out.println(productList);
										state=true;
									}

									if(!state) {
										System.out.println("No Products are available,Sorry make a Order is suspended ");
										break;
									}






									Order newOrder=new Order();


									Customer customer = services.searchCustomer(Integer.parseInt(customerID));
									System.out.println("Enter the Order ID");
									newOrder.setOrderNo(input.nextInt());
									System.out.println("Enter Product ID");
									Integer productId=input.nextInt();
									Product product=services.searchProduct(productId);
									System.out.println("Enter Haulier ID");
									Integer haulierId=input.nextInt();
									Haulier haulier=services.searchHaulier(haulierId);
									newOrder.setCustomer(customer);
									newOrder.setHaulier(haulier);
									newOrder.setProduct(product);
									System.out.println("Quantity");
									newOrder.setQuantity(input.nextInt());
									System.out.println("Enter Delivery Date");

									try {
										Date date = dateFormat.parse(input.next());
										Calendar deliveryDate = Calendar.getInstance();
										deliveryDate.setTime(date);
										newOrder.setDeliveryDate(deliveryDate);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										new InvalidDateException();
									}


									if(services.addOrder(newOrder)) {
										System.out.println("Product is Ordered successfully");
										break;
									}

									System.out.println("Failed to make order");
									break;
								case 5:
									System.out.println("Enter Contract ID to View:");
									Integer contractId= input.nextInt();
									Contract contract=services.searchContract(contractId);
									if(contract!=null) {
										System.out.println(contract);
										break;

									}
									System.out.println("No such Contract");

									break;
								case 6:
									System.out.println("Enter Contract ID to Cancel:");
									Integer cancelContract= input.nextInt();
									if(services.deleteContract(cancelContract)) {
										System.out.println("Contract is Cancelled");
										break;
									}
									System.out.println("Failed to Cancel Contract");

									break;
								case 7:
									Contract newContract=new Contract();


									Customer currentCustomer = services.searchCustomer(Integer.parseInt(customerID));
									System.out.println("Enter the Order ID");
									newContract.setContractNo(input.nextInt());
									System.out.println("Enter Product ID");
									Integer contractProductId=input.nextInt();
									Product contractProduct=services.searchProduct(contractProductId);
									System.out.println("Enter Haulier ID");
									Integer contractHaulierId=input.nextInt();
									Haulier ContractHaulier=services.searchHaulier(contractHaulierId);
									newContract.setCustomer(currentCustomer);
									newContract.setHaulier(ContractHaulier);
									newContract.setProduct(contractProduct);
									System.out.println("Quantity");
									newContract.setQuantity(input.nextInt());
									System.out.println("Enter Delivery Date");

									try {
										String contractDate=input.next();
										validate.dateValidation(contractDate);
										Date date = dateFormat.parse(contractDate);
										Calendar deliveryDate = Calendar.getInstance();
										deliveryDate.setTime(date);
										newContract.setDeliveryDate(deliveryDate);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										new InvalidDateException();
									}


									if(services.addContract(newContract)) {
										System.out.println("Contract is done successfully");
										break;
									}

									System.out.println("Failed to make Contract");

									break;
								case 8:
									System.out.println("Enter your Customer ID to Confirm:");
									Integer deleteCustomerId= input.nextInt();
									System.out.println("Enter the Password to Confirm:");
									String deleteCustomerPassword=input.next();
									if(services.deleteCustomer(deleteCustomerId, deleteCustomerPassword)) {
										System.out.println("Account is deleted");
										customerWant="9";
										break;
									}
									System.out.println("Failed to Delete the Account");
									break;
								case 9:

									break;

								default:System.out.println("Invalid option");

								}if(Integer.parseInt(customerWant)==9) {
									System.out.println("************************************************************************");
									break;
								}
								System.out.println("************************************************************************");
							}

						}
						else {
							System.out.println("Login Failed");
							System.out.println("***********************************");
							System.out.println("Enter the proper Password");
							continue;

						}
						if(Integer.parseInt(customerWant)==9) {
							break;
						}


					}

					break;
					case 2:
						System.out.println("************************************ REGISTER *************************************************");
						//						Register Customer:
						Customer customer=new Customer();

						System.out.println("Enter the Customer Id");
						String customerId=input.next();
						while(!validate.IdValidation(customerId)) {
							try {
								throw new InvalidIdException();

							}catch(InvalidIdException e) {
								System.out.println("Enter your Choice:");
								customerId=input.next();

							}

						}

						customer.setCustomerId(Integer.parseInt(customerId));
						System.out.println("Enter Customer Name");
						customer.setCustomerName(input.next());
						System.out.println("Enter Customer Email");
						customer.setEmail(input.next());
						System.out.println("Enter Customer Password");
						customer.setPassword(input.next());
						System.out.println("Enter Customer Address Details");
						Address address=new Address();
						System.out.println("Enter Flat no");
						address.setFlatNumber(input.next());
						System.out.println("Enter Street Address");

						address.setStreetAddress(input.next());
						System.out.println("Enter City");
						address.setTownCity(input.next());
						System.out.println("Enter State");
						address.setState(input.next());
						System.out.println("Enter Country");
						address.setCountry(input.next());
						System.out.println("Enter PostCode");
						address.setPostCode(input.nextInt());
						customer.setAddress(address);
						System.out.println("Enter Telephone");
						customer.setTelephoneNo(input.nextLong());

						if(services.addCustomer(customer)) {
							System.out.println("Registered Successfully");
							System.out.println("****************************************************************");
							break;
						}
						System.out.println("Failed to Register Account");
						System.out.println("****************************************************************");



						break;
					case 3:
						//					make Return to Home Page
						break;
					default:
						System.out.println("INVALID OPTION");
						break;

					}if(Integer.parseInt(customerChoice)==3) {
						break;
					}
				}
				break;
			case 2:
				//				ADmin Controls

				while(true) {
					System.out.println("************************************ ADMIN LOGIN *************************************************");
					System.out.println("1.login");
					System.out.println("2.Go Back to Home");
					System.out.println("Enter your Choice:");
					String adminchoice=input.next();

					while(!validate.IdValidation(adminchoice)) {
						try {
							throw new InvalidIdException();

						}catch(InvalidIdException e) {
							System.out.println("Enter your Choice:");
							adminchoice=input.next();

						}

					}


					System.out.println("******************************************************************");
					switch(Integer.parseInt(adminchoice)) {
					case 1:
						while(true) {
							//	LOGIN Admin
							System.out.println("Admin Login ID:");

							String adminId=input.next();
							while(!validate.IdValidation(adminId)) {
								try {
									throw new InvalidIdException();

								}catch(InvalidIdException e) {
									System.out.println("Enter correct ID:");
									adminId=input.next();

								}

							}
							System.out.println("Admin Password:");
							String password=input.next();
							String adminWant = null;

							if(services.adminLogin(Integer.parseInt(adminId), password)) {
								System.out.println("Login Successful");

								while(true) {
									boolean state=false;
									System.out.println("************************************ ADMIN CONTROLS *************************************************");
									System.out.println("1.Add Product");
									System.out.println("2.Display All Product");
									System.out.println("3.Search Product");
									System.out.println("4.Remove Product");
									System.out.println("5.Modify Product");

									System.out.println("6.Display all Order");
									System.out.println("7.Remove Order");
									System.out.println("8.search Order");

									System.out.println("9.Add New Haulier");
									System.out.println("10.Remove Haulier");
									System.out.println("11.search Haulier");
									System.out.println("12.Display All Hauliers");

									System.out.println("13.search Customer");
									System.out.println("14.remove Customer");
									System.out.println("15.Display All Customer");

									System.out.println("16.Display all Contracts");
									System.out.println("17.Remove Contract");
									System.out.println("18.search Contract");

									System.out.println("19.Logout");
									System.out.println("Enter your Choice:");

									adminWant=input.next();
									while(!validate.IdValidation(adminWant)) {
										try {
											throw new InvalidIdException();

										}catch(InvalidIdException e) {
											System.out.println("Enter your Choice:");
											adminWant=input.next();

										}

									}

									System.out.println("***************************************************************");
									switch(Integer.parseInt(adminWant)) {
									case 1:


										System.out.println("Product Details");
										Product product=new Product();
										System.out.println("Product Id");
										Integer productId=input.nextInt();
										product.setProductId(productId);
										System.out.println("Product name");
										String productName=input.next();
										product.setProductName(productName);
										System.out.println("Product description");
										String productDescription = input.next();
										product.setProductDescription(productDescription);

										if(services.addProduct(product)) {
											System.out.println("Product added");
											break;
										}

										System.out.println("Failed to added Product");


										break;
									case 2:
										List<Product> productsList=services.displayAllProduct();


										for(Product productList:productsList) {
											System.out.println(productList);
											state=true;
										}

										if(state) {
											break;
										}

										System.out.println("No Products are available");

										break;
									case 3:

										System.out.println("Enter the Product Id to search:");
										Integer searchProduct= input.nextInt();
										Product searchedProduct=services.searchProduct(searchProduct);
										if(searchedProduct!=null) {
											System.out.println(searchedProduct);
											break;
										}
										System.out.println("No such Product found");

										break;
									case 4:



										System.out.println("Enter the Product Id to Remove:");
										Integer removeProduct= input.nextInt();
										if(services.deleteProduct(removeProduct)) {
											System.out.println("Product Deleted Successfully");
											break;
										}

										System.out.println("failed to Delete because no such Product found");

										break;
									case 5:
										Product modifyProduct=new Product();
										System.out.println("Enter the Product Id to modify:");
										Integer modifyProductId= input.nextInt();
										modifyProduct.setProductId(modifyProductId);
										System.out.println("Enter Product name");
										modifyProduct.setProductName(input.next());
										System.out.println("Enter Product");
										modifyProduct.setProductDescription(input.next());

										if(services.modifyProduct(modifyProduct)) {
											System.out.println("Product Modified Successfully");
											break;
										}
										System.out.println("Failed to Modified ");

										break;
									case 6:
										List<Order> ordersList=services.displayAllOrder();

										for(Order order:ordersList) {
											System.out.println(order);

											state=true;
										}

										if(state) {
											break;
										}

										System.out.println("No Orders are available");

										break;
									case 7:


										System.out.println("Enter the Order Id to Remove:");
										Integer removeOrder= input.nextInt();
										if(services.deleteOrder(removeOrder)) {
											System.out.println("Order is removed Successfully");
											break;
										}

										System.out.println("Failed to Remove Order");

										break;
									case 8:


										System.out.println("Enter the Order ID to Search:");
										Integer searchOrder= input.nextInt();
										Order searchedOrder=services.searchOrder(searchOrder);

										if(searchedOrder!=null) {
											System.out.println(searchedOrder);
											break;
										}
										System.out.println("No Such Order Found");

										break;
									case 9:
										///// add haulier


										System.out.println("Enter  Haulier Details");
										Haulier haulier=new Haulier();
										System.out.println("Enter the Haulier ID:");
										Integer haulierId= input.nextInt();
										haulier.setHaulierId(haulierId);
										System.out.println("Enter the Haulier name");
										String haulierName = input.next();
										haulier.setHaulierName(haulierName);
										System.out.println("Enter the Haulier Address details");
										Address address=new Address();
										System.out.println("Enter Flat no");
										address.setFlatNumber(input.next());
										System.out.println("Enter Street Address");
										address.setStreetAddress(input.next());
										System.out.println("Enter City");
										address.setTownCity(input.next());
										System.out.println("Enter State");
										address.setState(input.next());
										System.out.println("Enter Country");
										address.setCountry(input.next());
										System.out.println("Enter PostCode");
										address.setPostCode(input.nextInt());
										haulier.setAddress(address);
										System.out.println("Enter the Haulier Email");
										String email=input.next();
										haulier.setEmail(email);
										System.out.println("Enter the Haulier Telephone Number");
										long telephoneNo= input.nextLong();
										haulier.setTelephoneNo(telephoneNo);

										if(services.addHaulier(haulier)) {
											System.out.println("Haulier Added Successfully");
											break;
										}
										System.out.println("Failed to Add Haulier");
										break;
									case 10:



										System.out.println("Enter the Haulier ID to Remove:");
										Integer removeHaulier= input.nextInt();
										if(services.deleteHaulier(removeHaulier)){
											System.out.println("Haulier Removed Successfully");
											break;
										}
										System.out.println("Failed to Remove Haulier");

										break;
									case 11:

										System.out.println("Enter the Haulier ID to Search");
										Integer searchHaulier= input.nextInt();
										Haulier searchedHaulier=services.searchHaulier(searchHaulier);
										if(searchedHaulier!=null) {
											System.out.println(searchedHaulier);
											break;
										}
										System.out.println("Failed to Search,Because no such Haulier Found");
										break;
									case 12:
										List<Haulier> hauliersList=services.displayAllHaulier();

										for(Haulier hauliers:hauliersList) {
											System.out.println(hauliers);

											state=true;
										}
										if(state) {
											break;
										}
										System.out.println("No Hauliers are available");

										break;
									case 13:

										System.out.println("Enter the Customer ID to Search");
										Integer searchCustomer= input.nextInt();
										Customer searchedCustomer=services.searchCustomer(searchCustomer);
										if(searchedCustomer!=null) {
											System.out.println(searchedCustomer);
											break;
										}
										System.out.println("Failed to Search Customer ,Because no such customer Found");

										break;
									case 14:

										System.out.println("Enter the Customer ID to remove");
										Integer removeCustomer= input.nextInt();
										if(services.deleteCustomer(removeCustomer)) {
											System.out.println("Customer is Deleted Successfully");
											break;
										}

										System.out.println("Failed to Delete Customer");
										break;
									case 15:
										List<Customer> customersList=services.displayAllCustomer();

										for(Customer customerList:customersList) {
											System.out.println(customerList);

											state=true;
										}
										if(state) {
											break;
										}
										System.out.println("No Customer are available");


										break;
									case 16:
										List<Contract> contractsList=services.displayAllContract();

										for(Contract contractList:contractsList) {
											System.out.println(contractList);

											state=true;
										}
										if(state) {
											break;
										}
										System.out.println("No Contracts are available");
										break;
									case 17:


										System.out.println("Enter the Contract ID to remove");
										Integer removeContract= input.nextInt();
										if(services.deleteContract(removeContract)) {
											System.out.println("Contract is Removed Successfully");
											break;
										}
										System.out.println("Failed to Remove Contract, Because no such Contract Found");



										break;
									case 18:

										System.out.println("Enter the Contract ID to Search");
										Integer searchContract= input.nextInt();
										Contract searchedContract=services.searchContract(searchContract);

										if(searchedContract!=null) {
											System.out.println(searchedContract);
											break;
										}
										System.out.println("Failed to search Contract, no such Contract Found");
										break;
									case 19:
													

										break;

									default:System.out.println("Invalid option");

									}if(Integer.parseInt(adminWant)==19) {

										break;
									}


								}



							}else {
								System.out.println("Login Failed");
							System.out.println("***********************************");
							System.out.println("Enter the password correctly");
								continue;
							}

							if(Integer.parseInt(adminWant)==19) {
								
								break;
							}
						}

						break;
					case 2:

						break;

					default:System.out.println("Invalid Input");

					}if(Integer.parseInt(adminchoice)==2) {
						break;
					}
				}

				break;
			case 3: 
				//				Exit Application
				break;
			default: System.out.println("INVALID OPTION");
			}if(Integer.parseInt(homeChoice)==3) {
				break;
			}


		}
		input.close();
	}

}
