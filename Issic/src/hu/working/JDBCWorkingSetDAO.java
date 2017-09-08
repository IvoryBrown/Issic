package hu.working;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import hu.working.gui.WorkingGui;

public class JDBCWorkingSetDAO extends WorkingGui implements WorkingDAO {

	private String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

	public JDBCWorkingSetDAO() {
		btnNewWorkingGui.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnInsertActionPerformed(evt);
			}
		});
	}

	public boolean checkInputs() {
		if (txtNameGui.getText().trim().isEmpty()) {
			return false;
		} else {
			try {
				return true;
			} catch (Exception ex) {
				return false;
			}
		}
	}

	@Override
	public ArrayList<Working> getProductList() {
		ArrayList<Working> productList = new ArrayList<Working>();
		Connection con = WorkingDB.getConnection();
		String QUERY = "SELECT * FROM dolgozok";
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			rs = st.executeQuery(QUERY);
			Working product;
			while (rs.next()) {
				product = new Working(rs.getInt("Dolgozo_ID"), rs.getString("Név"), rs.getInt("Irányítószám"),
						rs.getString("Leánykori_Név"), rs.getString("Neme"), rs.getString("Születési_dátum"),
						rs.getString("Anyja_neve"), rs.getString("Magántelefon"), rs.getString("Magán_mobil"),
						rs.getString("Magán_e-mail"), rs.getString("Ország"), rs.getString("Település"),
						rs.getString("Cím"), rs.getInt("Irányítószám"), rs.getString("Ország"),
						rs.getString("Település"), rs.getString("Cím"), rs.getString("Belépés_dátuma"),
						rs.getString("Kilépés_dátuma"), rs.getString("Beosztás"), rs.getString("Osztály"),
						rs.getString("Tevékenység"), rs.getString("Üzlei_telefon"), rs.getString("Üzleti_mobil"),
						rs.getString("Üzleti_email"), rs.getString("Sz_ig_szám"), rs.getInt("Taj_szám"),
						rs.getInt("Adoazonosító"), rs.getString("Vezetői_engedély"), rs.getString("Útlevél"));
				productList.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(Working.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productList;
	}

	public void Show_Products_In_JTable() {
		ArrayList<Working> list = getProductList();
		DefaultTableModel model = (DefaultTableModel) tblWorking.getModel();
		model.setRowCount(0);
		Object[] row = new Object[1];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getWorkingName();
			model.addRow(row);
		}
	}

	public void ShowItem(int index) {
		txtNameGui.setText(getProductList().get(index).getWorkingName());
		txtDateOfBirthGui.setText(getProductList().get(index).getDateOfBirth());
		// TODO nem???
		txtIDGui.setText(Integer.toString(getProductList().get(index).getWorkingID()));
		// TODO folyt...

	}

	private void jBtnInsertActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkInputs()) {
			try {
				Connection con = WorkingDB.getConnection();
				PreparedStatement INSERTINTO = con.prepareStatement("INSERT INTO dolgozok(Dolgozo_ID,Név,Irányítószám_ID)" + "values(?,?,?) ");
				INSERTINTO.setString(1, txtIDGui.getText());
				INSERTINTO.setString(2, txtNameGui.getText());
				INSERTINTO.setString(3, txtZipCodeGui.getText());
				// Boolean b =
				// txtOrganizationEmailGui.getText().matches(EMAIL_REGEX);
				// if (b) {
				// INSERTINTO.setString(9, txtOrganizationEmailGui.getText());
				// } else {
				// JOptionPane.showMessageDialog(null, "Nem megfelelő email
				// cím");
				// }
				INSERTINTO.executeUpdate();
				Show_Products_In_JTable();
				JOptionPane.showMessageDialog(null, "Adatok beillesztve");
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Sikertelen beillesztés: " + ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres");
		}
	}
}
