/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.intface;

/**
 *
 * @author user
 */
public interface Roles
{
	/*
	* Roles of callers to the system
	*/
	/**
	* Role denoting the user is a school administrator
	*/
	String ADMIN = "ADMINISTRATOR";
	/**
	* Role denoting the user is a student
	*/
	String SUPERVISORY = "SUPERVISOR";
	/**
	* Role denoting the user is a janitor
	*/
	String PUBLIC = "REPORT";
}
