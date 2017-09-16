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

@SuppressWarnings("serial")
public class JDBCWorkingSetDAO extends WorkingGui implements WorkingDAO {

	public JDBCWorkingSetDAO() {
		setAction();
		Show_Products_In_JTable();
}

	private void setAction() {
		tblWorking.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Partner név" }));
		tblWorking.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTable_ProductsMouseClicked(evt);
			}
		});
		btnNewWorkingGui.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnInsertActionPerformed(evt);
			}
		});
btnEditingWorkingGui.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnUpdateActionPerformed(evt);
			}
		});
btnDeleteWorkingGui.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int res = JOptionPane.showConfirmDialog(null, "Biztos törölni szeretnéd?", "Figyelmeztetés",
						JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION)
					jBtnDeleteActionPerformed(evt);
				else
					return;
			}
		});
btnDeleteShowWorkingGui.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeleteShowWorkingPerformed(evt);
			}
		});
	}

	public boolean checkInputs() {
		if (txtIDGui.getText().trim().isEmpty() || txtNameGui.getText().trim().isEmpty()
				|| txtGenderGui.getText().trim().isEmpty() || txtDateOfBirthGui.getText().trim().isEmpty()
				|| txtMothersNameGui.getText().trim().isEmpty() || txtPrivateMobilPhoneGui.getText().trim().isEmpty()
				|| txtCuntryAddresGui.getText().trim().isEmpty() || txtZipCodeGui.getText().trim().isEmpty()
				|| txtSettlementGui.getText().trim().isEmpty() || txtTitleGui.getText().trim().isEmpty()) {

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
		String query = "SELECT * FROM dolgozok " + "  JOIN lakcím   ON Lakcím_Dolgozok_Dolgozo_ID = Dolgozo_ID "
				+ " JOIN levcím  ON Levcím_Dolgozok_Dolgozo_ID = Dolgozo_ID ";
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			Working product;
			while (rs.next()) {
				product = new Working(rs.getInt("Dolgozo_ID"), rs.getString("Név"), rs.getString("Leánykori_név"),
						rs.getString("Neme"), rs.getString("Születési_dátum"), rs.getString("Anyja_neve"),
						rs.getString("Magántelefon"), rs.getString("Magán_mobil"), rs.getString("Magán_email"),
						rs.getInt("Irányítószám"), rs.getString("Ország"), rs.getString("Település"),
						rs.getString("Cím"), rs.getInt("Irányítószám_lev"), rs.getString("Ország_lev"),
						rs.getString("Település_lev"), rs.getString("Cím_lev")

				// rs.getString("Belépés_dátuma"),
				// rs.getString("Kilépés_dátuma"), rs.getString("Beosztás"),
				// rs.getString("Osztály"),
				// rs.getString("Tevékenység"), rs.getString("Üzlei_telefon"),
				// rs.getString("Üzleti_mobil"),
				// rs.getString("Üzleti_email"), rs.getString("Sz_ig_szám"),
				// rs.getInt("Taj_szám"),
				// rs.getInt("Adoazonosító"), rs.getString("Vezetői_engedély"),
				// rs.getString("Útlevél")
				);
				productList.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(JDBCWorkingSetDAO.class.getName()).log(Level.SEVERE, null, ex);
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
		txtIDGui.setText(Integer.toString(getProductList().get(index).getWorkingID()));
		txtNameGui.setText(getProductList().get(index).getWorkingName());
		txtMaidenNameGui.setText(getProductList().get(index).getMaidenName());
		txtGenderGui.setText(getProductList().get(index).getGender());
		txtDateOfBirthGui.setText(getProductList().get(index).getDateOfBirth());
		txtMothersNameGui.setText(getProductList().get(index).getMothersName());
		txtPrivateLandlinePhoneGui.setText(getProductList().get(index).getPrivatePhone());
		txtPrivateMobilPhoneGui.setText(getProductList().get(index).getPrivateMobil());
		txtPrivateEmailGui.setText(getProductList().get(index).getPrivateEmail());
		txtZipCodeGui.setText(Integer.toString(getProductList().get(index).getZipCode()));
		txtCuntryAddresGui.setText(getProductList().get(index).getCuntry());
		txtSettlementGui.setText(getProductList().get(index).getSettlement());
		txtTitleGui.setText(getProductList().get(index).getTitle());
		txtLetterZipCodeGui.setText(Integer.toString(getProductList().get(index).getLetterZipCode()));
		txtLetterCuntryGui.setText(getProductList().get(index).getLetterContry());
		txtLetterSettlementGui.setText(getProductList().get(index).getLetterSettlement());
		txtLetterTitleGui.setText(getProductList().get(index).getLetterTitle());
		// TODO folyt.
	}

	private void jBtnInsertActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkInputs()) {
			try {
				Connection con = WorkingDB.getConnection();
				PreparedStatement inserintoWorking = con.prepareStatement("INSERT INTO dolgozok(Dolgozo_ID,Név,"
						+ "Leánykori_név,Neme,Születési_dátum,Anyja_neve,Magántelefon,Magán_mobil,Magán_email)"
						+ "values(?,?,?,?,?,?,?,?,?) ");
				inserintoWorking.setString(1, txtIDGui.getText());
				inserintoWorking.setString(2, txtNameGui.getText());
				inserintoWorking.setString(3, txtMaidenNameGui.getText());
				inserintoWorking.setString(4, txtGenderGui.getText());
				inserintoWorking.setString(5, txtDateOfBirthGui.getText());
				inserintoWorking.setString(6, txtMothersNameGui.getText());
				inserintoWorking.setString(7, txtPrivateLandlinePhoneGui.getText());
				inserintoWorking.setString(8, txtPrivateMobilPhoneGui.getText());
				inserintoWorking.setString(9, txtPrivateEmailGui.getText());
				inserintoWorking.executeUpdate();
				PreparedStatement inserintoWorkingHomeAddress = con.prepareStatement(
						"INSERT INTO lakcím(Lakcím_Dolgozok_Dolgozo_ID,Irányítószám,Ország,Település,cím)"
								+ "values(?,?,?,?,?) ");
				inserintoWorkingHomeAddress.setString(1, txtIDGui.getText());
				inserintoWorkingHomeAddress.setString(2, txtZipCodeGui.getText());
				inserintoWorkingHomeAddress.setString(3, txtCuntryAddresGui.getText());
				inserintoWorkingHomeAddress.setString(4, txtSettlementGui.getText());
				inserintoWorkingHomeAddress.setString(5, txtTitleGui.getText());
				inserintoWorkingHomeAddress.executeUpdate();
				PreparedStatement inserintoMailingAddress = con.prepareStatement(
						"INSERT INTO levcím(Levcím_Dolgozok_Dolgozo_ID,Irányítószám_lev,Ország_lev,Település_lev,cím_lev)"
								+ "values(?,?,?,?,?) ");
				inserintoMailingAddress.setString(1, txtIDGui.getText());
				inserintoMailingAddress.setString(2, txtLetterZipCodeGui.getText());
				inserintoMailingAddress.setString(3, txtLetterCuntryGui.getText());
				inserintoMailingAddress.setString(4, txtLetterSettlementGui.getText());
				inserintoMailingAddress.setString(5, txtLetterTitleGui.getText());
				inserintoMailingAddress.executeUpdate();
				Show_Products_In_JTable();
				JOptionPane.showMessageDialog(null, "Adatok beillesztve");
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Sikertelen beillesztés: " + ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres");
		}
	}

	private void jBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkInputs()) {
			Connection con = WorkingDB.getConnection();
			try {
				String updateQueryWorking = null;
				PreparedStatement ps = null;
				updateQueryWorking = "UPDATE dolgozok SET Név = ?"
						+ ", Leánykori_név = ?, Neme = ?, Születési_dátum = ?, Anyja_neve = ?, Magántelefon = ?, Magán_mobil = ?"
						+ ", Magán_email = ? WHERE Dolgozo_ID = ?";
				ps = con.prepareStatement(updateQueryWorking);
				ps.setString(1, txtNameGui.getText());
				ps.setString(2, txtMaidenNameGui.getText());
				ps.setString(3, txtGenderGui.getText());
				ps.setString(4, txtDateOfBirthGui.getText());
				ps.setString(5, txtMothersNameGui.getText());
				ps.setString(6, txtPrivateLandlinePhoneGui.getText());
				ps.setString(7, txtPrivateMobilPhoneGui.getText());
				ps.setString(8, txtPrivateEmailGui.getText());
				ps.setInt(9, Integer.parseInt(txtIDGui.getText()));
				ps.executeUpdate();
				Show_Products_In_JTable();
			} catch (SQLException ex) {
				Logger.getLogger(JDBCWorkingSetDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
			String updateQueryWorkingHomeAddress = null;
			try {
				PreparedStatement ps = null;
				updateQueryWorkingHomeAddress = "UPDATE Lakcím SET Irányítószám = ?, Ország = ?, Település = ?"
						+ ", Cím = ? WHERE Lakcím_Dolgozok_Dolgozo_ID = ?";
				ps = con.prepareStatement(updateQueryWorkingHomeAddress);
				ps.setString(1, txtZipCodeGui.getText());
				ps.setString(2, txtCuntryAddresGui.getText());
				ps.setString(3, txtSettlementGui.getText());
				ps.setString(4, txtTitleGui.getText());
				ps.setString(5, txtIDGui.getText());
				ps.executeUpdate();
				Show_Products_In_JTable();
			} catch (SQLException ex) {
				Logger.getLogger(JDBCWorkingSetDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
			try {
				String updateQueryWorkingMailingAddress = null;
				PreparedStatement ps = null;
				updateQueryWorkingMailingAddress = "UPDATE Levcím SET Irányítószám_lev = ?, Ország_lev = ?, Település_lev = ?"
						+ ", Cím_lev = ? WHERE Levcím_Dolgozok_Dolgozo_ID = ?";
				ps = con.prepareStatement(updateQueryWorkingMailingAddress);
				ps.setString(1, txtLetterZipCodeGui.getText());
				ps.setString(2, txtLetterCuntryGui.getText());
				ps.setString(3, txtLetterSettlementGui.getText());
				ps.setString(4, txtLetterTitleGui.getText());
				ps.setString(5, txtIDGui.getText());
				ps.executeUpdate();
				Show_Products_In_JTable();
				JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
			} catch (SQLException ex) {
				Logger.getLogger(JDBCWorkingSetDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres vagy rossz");
		}
	}

	private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		if (!txtIDGui.getText().equals("")) {
			try {
				Connection con = WorkingDB.getConnection();
				PreparedStatement deleteWorkingMailingAddress = con
						.prepareStatement("DELETE FROM Levcím WHERE Levcím_Dolgozok_Dolgozo_ID = ? ");
				int idWorkingMailingAddress = Integer.parseInt(txtIDGui.getText());
				deleteWorkingMailingAddress.setInt(1, idWorkingMailingAddress);
				deleteWorkingMailingAddress.executeUpdate();
				PreparedStatement deleteWorkingHomeAddress = con
						.prepareStatement("DELETE FROM Lakcím WHERE Lakcím_Dolgozok_Dolgozo_ID = ? ");
				int idWorkingHomeAddress = Integer.parseInt(txtIDGui.getText());
				deleteWorkingHomeAddress.setInt(1, idWorkingHomeAddress);
				deleteWorkingHomeAddress.executeUpdate();
				PreparedStatement deleteWorking = con.prepareStatement("DELETE FROM dolgozok WHERE Dolgozo_ID = ?");
				int idWorking = Integer.parseInt(txtIDGui.getText());
				deleteWorking.setInt(1, idWorking);
				deleteWorking.executeUpdate();
				Show_Products_In_JTable();
				JOptionPane.showMessageDialog(null, "Sikeres törlés");
			} catch (SQLException ex) {
				Logger.getLogger(JDBCWorkingSetDAO.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(null, "Sikertelen törlés");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sikertelen törlés : Nincs ID a törléshez");
		}
	}

	private void JTable_ProductsMouseClicked(java.awt.event.MouseEvent evt) {
		int index = tblWorking.getSelectedRow();
		ShowItem(index);
	}

	private void btnDeleteShowWorkingPerformed(java.awt.event.ActionEvent evt) {
		txtActivityGui.setText(null);
		txtAddDate.setText(null);
		txtClassGui.setText(null);
		txtCuntryAddresGui.setText(null);
		txtDateOfBirthGui.setText(null);
		txtExitDate.setText(null);
		txtGenderGui.setText(null);
		txtIDGui.setText(null);
		txtLetterCuntryGui.setText(null);
		txtLetterSettlementGui.setText(null);
		txtLetterTitleGui.setText(null);
		txtLetterZipCodeGui.setText(null);
		txtMaidenNameGui.setText(null);
		txtMothersNameGui.setText(null);
		txtNameGui.setText(null);
		txtOganizationLandlinePhoneGui.setText(null);
		txtOrganizationEmailGui.setText(null);
		txtOrganizationMobilPhoneGui.setText(null);
		txtPostGui.setText(null);
		txtPrivateEmailGui.setText(null);
		txtPrivateLandlinePhoneGui.setText(null);
		txtPrivateMobilPhoneGui.setText(null);
		txtSettlementGui.setText(null);
		txtTitleGui.setText(null);
		txtZipCodeGui.setText(null);
	}
}
