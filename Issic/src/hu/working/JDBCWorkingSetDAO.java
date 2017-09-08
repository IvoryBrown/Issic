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
				product = new Working(rs.getInt("Dolgozo_ID"), rs.getString("Név"), rs.getInt("Irányítószám_ID"),
						rs.getString("Leánykori_név"), rs.getString("Neme"), rs.getString("Születési_dátum"),
						rs.getString("Anyja_neve"), rs.getString("Magántelefon"), rs.getString("Magán_mobil"),
						rs.getString("Magán_email"), rs.getString("Ország"), rs.getString("Település"),
						rs.getString("Cím"), rs.getInt("Irányítószám"), rs.getString("Ország"),
						rs.getString("Település"), rs.getString("Cím"), rs.getString("Belépés_dátuma"),
						rs.getString("Kilépés_dátuma"), rs.getString("Beosztás"), rs.getString("Osztály"),
						rs.getString("Tevékenység"), rs.getString("Üzlei_telefon"), rs.getString("Üzleti_mobil"),
						rs.getString("Üzleti_email"), rs.getString("Sz_ig_szám"), rs.getInt("Taj_szám"),
						rs.getInt("Adoazonosító"), rs.getString("Vezetői_engedély"), rs.getString("Útlevél"));
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
		txtZipCodeGui.setText(Integer.toString(getProductList().get(index).getZipCode()));
		txtMaidenNameGui.setText(getProductList().get(index).getMaidenName());
		txtGenderGui.setText(getProductList().get(index).getGender());
		txtDateOfBirthGui.setText(getProductList().get(index).getDateOfBirth());
		txtMothersNameGui.setText(getProductList().get(index).getMothersName());
		txtPrivateLandlinePhoneGui.setText(getProductList().get(index).getPrivatePhone());
		txtPrivateMobilPhoneGui.setText(getProductList().get(index).getPrivateMobil());
		txtPrivateEmailGui.setText(getProductList().get(index).getPrivateEmail());
		// TODO folyt.
	}

	private void jBtnInsertActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkInputs()) {
			try {
				Connection con = WorkingDB.getConnection();
				PreparedStatement INSERTINTO = con
						.prepareStatement("INSERT INTO dolgozok(Dolgozo_ID,Név,Irányítószám_ID,"
								+ "Leánykori_név,Neme,Születési_dátum,Anyja_neve,Magántelefon,Magán_mobil,Magán_email)"
								+ "values(?,?,?,?,?,?,?,?,?,?) ");
				INSERTINTO.setString(1, txtIDGui.getText());
				INSERTINTO.setString(2, txtNameGui.getText());
				INSERTINTO.setString(3, txtZipCodeGui.getText());
				INSERTINTO.setString(4, txtMaidenNameGui.getText());
				INSERTINTO.setString(5, txtGenderGui.getText());
				INSERTINTO.setString(6, txtDateOfBirthGui.getText());
				INSERTINTO.setString(7, txtMothersNameGui.getText());
				INSERTINTO.setString(8, txtPrivateLandlinePhoneGui.getText());
				INSERTINTO.setString(9, txtPrivateMobilPhoneGui.getText());
				Boolean b = txtPrivateEmailGui.getText().matches(EMAIL_REGEX);
				if (b) {
					INSERTINTO.setString(10, txtPrivateEmailGui.getText());
				} else {
					JOptionPane.showMessageDialog(null, "Nem megfelelő email cím");
				}
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

	private void jBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkInputs()) {
			String UPDATEQUERY = null;
			PreparedStatement ps = null;
			Connection con = WorkingDB.getConnection();
			if (txtActivityGui == null) {
				try {
					UPDATEQUERY = "UPDATE dolgozok SET Név = ?, Irányítószám_ID = ?"
							+ ", Leánykori_név = ?, Neme = ?, Születési_dátum = ?, Anyja_neve = ?, Magántelefon = ?, Magán_mobil = ?"
							+ ", Magán_email = ? WHERE Dolgozo_ID = ?";
					ps = con.prepareStatement(UPDATEQUERY);
					ps.setString(1, txtIDGui.getText());
					ps.setString(2, txtNameGui.getText());
					ps.setString(3, txtZipCodeGui.getText());
					ps.setString(4, txtMaidenNameGui.getText());
					ps.setString(5, txtGenderGui.getText());
					ps.setString(6, txtDateOfBirthGui.getText());
					ps.setString(7, txtMothersNameGui.getText());
					ps.setString(8, txtPrivateLandlinePhoneGui.getText());
					ps.setString(9, txtPrivateMobilPhoneGui.getText());
					Boolean b = txtPrivateEmailGui.getText().matches(EMAIL_REGEX);
					if (b) {
						ps.setString(10, txtPrivateEmailGui.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Nem megfelelő email cím");
					}
					ps.executeUpdate();
					Show_Products_In_JTable();
					JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
				} catch (SQLException ex) {
					Logger.getLogger(JDBCWorkingSetDAO.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else {
				try {
					UPDATEQUERY = "UPDATE dolgozok SET Név = ?, Irányítószám_ID = ?"
							+ ", Leánykori_név = ?, Neme = ?, Születési_dátum = ?, Anyja_neve = ?, Magántelefon = ?, Magán_mobil = ?"
							+ ", Magán_email = ? WHERE Dolgozo_ID = ?";
					ps = con.prepareStatement(UPDATEQUERY);
					ps = con.prepareStatement(UPDATEQUERY);
					ps.setString(1, txtIDGui.getText());
					ps.setString(2, txtNameGui.getText());
					ps.setString(3, txtZipCodeGui.getText());
					ps.setString(4, txtMaidenNameGui.getText());
					ps.setString(5, txtGenderGui.getText());
					ps.setString(6, txtDateOfBirthGui.getText());
					ps.setString(7, txtMothersNameGui.getText());
					ps.setString(8, txtPrivateLandlinePhoneGui.getText());
					ps.setString(9, txtPrivateMobilPhoneGui.getText());
					Boolean b = txtPrivateEmailGui.getText().matches(EMAIL_REGEX);
					if (b) {
						ps.setString(10, txtPrivateEmailGui.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Nem megfelelő email cím");
					}
					ps.executeUpdate();
					Show_Products_In_JTable();
					JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres vagy rossz");
		}
	}

	private void JTable_ProductsMouseClicked(java.awt.event.MouseEvent evt) {
		int index = tblWorking.getSelectedRow();
		ShowItem(index);
	}
}
