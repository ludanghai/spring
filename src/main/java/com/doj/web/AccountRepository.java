/**
 * 
 */
package com.doj.web;

import java.util.List;

/**
 * @author Dinesh.Rajput
 *
 */
public interface AccountRepository {
	
	List<Account> getAllAccounts();
	List<Account> test();
	
	Account getAccount(String number);
}