package hu.working;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import hu.working.gui.WorkingGui;

public class JDBCWorkingSetDAO extends WorkingGui implements WorkingDAO {

	@Override
	public ArrayList<Working> getProductList() {
		ArrayList<Working> productList = new ArrayList<Working>();
		Connection con = WorkingDB.getConnection();
		String QUERY = "SELECT * FROM workers";
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			rs = st.executeQuery(QUERY);
			Working product;
			while (rs.next()) {
				product = new Working(rs.getInt("Dolgozo_ID"),rs.getString("Név"),rs.getInt("Irányítószám"));
				productList.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(Working.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productList;
		return null;
	}

}
