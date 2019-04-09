package mainpack.dao.role;


import mainpack.entity.Role;

public interface RoleDao {

	Role findRoleByName(String theRoleName);
	
}
