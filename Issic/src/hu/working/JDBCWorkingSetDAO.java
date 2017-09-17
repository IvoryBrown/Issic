package hu.working;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import hu.working.gui.WorkingGui;

@SuppressWarnings("serial")
public class JDBCWorkingSetDAO extends WorkingGui implements WorkingDAO {
	String ImgPath = null;

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
		btnWorkingImage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_Choose_ImageActionPerformed(evt);
			}
		});
	}

	public boolean checkInputs() {
		if (txtIDGui.getText().trim().isEmpty() || txtNameGui.getText().trim().isEmpty()
				|| txtGenderGui.getText().trim().isEmpty() || txtDateOfBirthGui.getText().trim().isEmpty()
				|| txtMothersNameGui.getText().trim().isEmpty() || txtPrivateMobilPhoneGui.getText().trim().isEmpty()
				|| txtCuntryAddresGui.getText().trim().isEmpty() || txtZipCodeGui.getText().trim().isEmpty()
				|| txtSettlementGui.getText().trim().isEmpty() || txtTitleGui.getText().trim().isEmpty()
				|| txtLetterCuntryGui.getText().trim().isEmpty() || txtLetterSettlementGui.getText().trim().isEmpty()
				|| txtLetterTitleGui.getText().trim().isEmpty() || txtLetterZipCodeGui.getText().trim().isEmpty()
				|| txtAddDate.getText().trim().isEmpty() || txtPostGui.getText().trim().isEmpty()
				|| txtClassGui.getText().trim().isEmpty() || txtTaxIDWorkingGui.getText().trim().isEmpty()
				|| txtIDCardWorkingGui.getText().trim().isEmpty()
				|| txtHealthCardWorkingGui.getText().trim().isEmpty()) {
			return false;
		} else {
			try {
				return true;
			} catch (Exception ex) {
				return false;
			}
		}
	}

	public ImageIcon ResizeImage(String imagePath, byte[] pic) {
		ImageIcon myImage = null;
		if (imagePath != null) {
			myImage = new ImageIcon(imagePath);
		} else {
			myImage = new ImageIcon(pic);
		}
		Image img = myImage.getImage();
		Image img2 = img.getScaledInstance(jLblWorkingImageGui.getWidth(), jLblWorkingImageGui.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(img2);
		return image;
	}

	@Override
	public ArrayList<Working> getProductList() {
		ArrayList<Working> productList = new ArrayList<Working>();
		Connection con = WorkingDB.getConnection();
		String query = "SELECT * FROM dolgozok " + "  JOIN lakcím ON Lakcím_Dolgozok_Dolgozo_ID = Dolgozo_ID "
				+ " JOIN levcím ON Levcím_Dolgozok_Dolgozo_ID = Dolgozo_ID "
				+ " JOIN szervezet ON Szervezet_Dolgozok_Dolgozo_ID = Dolgozo_ID"
				+ " JOIN okmányok ON Okmány_Dolgozok_Dolgozo_ID = Dolgozo_ID"
				+ " JOIN image ON Image_Dolgozok_Dolgozo_ID = Dolgozo_ID";
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
						rs.getString("Település_lev"), rs.getString("Cím_lev"), rs.getString("Belépés_dátuma"),
						rs.getString("Kilépés_dátuma"), rs.getString("Beosztás"), rs.getString("Osztály"),
						rs.getString("Tevékenység"), rs.getString("Üzlei_telefon"), rs.getString("Üzleti_mobil"),
						rs.getString("Üzleti_email"), rs.getInt("Taj_szám"), rs.getString("Sz_ig_szám"),
						rs.getInt("Adoazonosító"), rs.getString("Vezetői_engedély"), rs.getString("Útlevél"),
						rs.getBytes("image"));
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
		txtAddDate.setText(getProductList().get(index).getAddDate());
		txtExitDate.setText(getProductList().get(index).getExitDate());
		txtPostGui.setText(getProductList().get(index).getPost());
		txtClassGui.setText(getProductList().get(index).getClassWorking());
		txtOganizationLandlinePhoneGui.setText(getProductList().get(index).getOganizationLandlinePhone());
		txtOrganizationMobilPhoneGui.setText(getProductList().get(index).getOganizationMobilPhone());
		txtOrganizationEmailGui.setText(getProductList().get(index).getOganizationEmail());
		txtActivityGui.setText(getProductList().get(index).getActivity());
		txtHealthCardWorkingGui.setText(Integer.toString(getProductList().get(index).getHealthCard()));
		txtIDCardWorkingGui.setText(getProductList().get(index).getiDCard());
		txtTaxIDWorkingGui.setText(Integer.toString(getProductList().get(index).getTaxID()));
		txtDrivingLicenseWorkingGui.setText(getProductList().get(index).getDrivingLicense());
		txtPassportWorkingGui.setText(getProductList().get(index).getPassport());
		jLblWorkingImageGui.setIcon(ResizeImage(null, getProductList().get(index).getPicture()));
	}

	private void Btn_Choose_ImageActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser file = new JFileChooser();
		file.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
		file.addChoosableFileFilter(filter);
		int result = file.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = file.getSelectedFile();
			String path = selectedFile.getAbsolutePath();
			jLblWorkingImageGui.setIcon(ResizeImage(path, null));
			ImgPath = path;
		} else {
			System.out.println("Nincs fájl kiválasztva");
		}
	}

	private void jBtnInsertActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkInputs()) {
			try {
				Connection con = WorkingDB.getConnection();
				PreparedStatement insertWorking = con.prepareStatement("INSERT INTO dolgozok(Dolgozo_ID,Név,"
						+ "Leánykori_név,Neme,Születési_dátum,Anyja_neve,Magántelefon,Magán_mobil,Magán_email)"
						+ "values(?,?,?,?,?,?,?,?,?) ");
				insertWorking.setString(1, txtIDGui.getText());
				insertWorking.setString(2, txtNameGui.getText());
				insertWorking.setString(3, txtMaidenNameGui.getText());
				insertWorking.setString(4, txtGenderGui.getText());
				insertWorking.setString(5, txtDateOfBirthGui.getText());
				insertWorking.setString(6, txtMothersNameGui.getText());
				insertWorking.setString(7, txtPrivateLandlinePhoneGui.getText());
				insertWorking.setString(8, txtPrivateMobilPhoneGui.getText());
				insertWorking.setString(9, txtPrivateEmailGui.getText());

				PreparedStatement insertWorkingHomeAddress = con.prepareStatement(
						"INSERT INTO lakcím(Lakcím_Dolgozok_Dolgozo_ID,Irányítószám,Ország,Település,cím)"
								+ "values(?,?,?,?,?) ");
				insertWorkingHomeAddress.setString(1, txtIDGui.getText());
				insertWorkingHomeAddress.setString(2, txtZipCodeGui.getText());
				insertWorkingHomeAddress.setString(3, txtCuntryAddresGui.getText());
				insertWorkingHomeAddress.setString(4, txtSettlementGui.getText());
				insertWorkingHomeAddress.setString(5, txtTitleGui.getText());

				PreparedStatement insertMailingAddress = con.prepareStatement(
						"INSERT INTO levcím(Levcím_Dolgozok_Dolgozo_ID,Irányítószám_lev,Ország_lev,Település_lev,cím_lev)"
								+ "values(?,?,?,?,?) ");
				insertMailingAddress.setString(1, txtIDGui.getText());
				insertMailingAddress.setString(2, txtLetterZipCodeGui.getText());
				insertMailingAddress.setString(3, txtLetterCuntryGui.getText());
				insertMailingAddress.setString(4, txtLetterSettlementGui.getText());
				insertMailingAddress.setString(5, txtLetterTitleGui.getText());

				PreparedStatement insertOrganization = con.prepareStatement(
						"INSERT INTO szervezet(Szervezet_Dolgozok_Dolgozo_ID,Belépés_dátuma,Kilépés_dátuma,Beosztás,Osztály,Tevékenység,Üzlei_telefon,Üzleti_mobil,Üzleti_email)"
								+ "values(?,?,?,?,?,?,?,?,?) ");
				insertOrganization.setString(1, txtIDGui.getText());
				insertOrganization.setString(2, txtAddDate.getText());
				insertOrganization.setString(3, txtExitDate.getText());
				insertOrganization.setString(4, txtPostGui.getText());
				insertOrganization.setString(5, txtClassGui.getText());
				insertOrganization.setString(6, txtActivityGui.getText());
				insertOrganization.setString(7, txtOganizationLandlinePhoneGui.getText());
				insertOrganization.setString(8, txtOrganizationMobilPhoneGui.getText());
				insertOrganization.setString(9, txtOrganizationEmailGui.getText());

				PreparedStatement insertDocuments = con.prepareStatement(
						"INSERT INTO okmányok(Okmány_Dolgozok_Dolgozo_ID,Taj_szám,Sz_ig_szám,Adoazonosító,Vezetői_engedély,Útlevél)"
								+ "values(?,?,?,?,?,?) ");
				insertDocuments.setString(1, txtIDGui.getText());
				insertDocuments.setString(2, txtHealthCardWorkingGui.getText());
				insertDocuments.setString(3, txtIDCardWorkingGui.getText());
				insertDocuments.setString(4, txtTaxIDWorkingGui.getText());
				insertDocuments.setString(5, txtDrivingLicenseWorkingGui.getText());
				insertDocuments.setString(6, txtPassportWorkingGui.getText());

				PreparedStatement insertImage = con
						.prepareStatement("INSERT INTO Image(Image_Dolgozok_Dolgozo_ID,Image)" + "values(?,?) ");
				insertImage.setString(1, txtIDGui.getText());
				InputStream img = new FileInputStream(new File(ImgPath));
				insertImage.setBlob(2, img);

				insertWorking.executeUpdate();
				insertWorkingHomeAddress.executeUpdate();
				insertMailingAddress.executeUpdate();
				insertOrganization.executeUpdate();
				insertDocuments.executeUpdate();
				insertImage.executeUpdate();
				Show_Products_In_JTable();
				JOptionPane.showMessageDialog(null, "Adatok beillesztve");
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Sikertelen beillesztés: " + ex.getMessage());
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Sikertelen kép beillesztés: " + ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres");
		}
	}

	private void jBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkInputs()) {
			Connection con = WorkingDB.getConnection();
			try {
				String updateWorking = null;
				PreparedStatement ps = null;
				updateWorking = "UPDATE dolgozok SET Név = ?"
						+ ", Leánykori_név = ?, Neme = ?, Születési_dátum = ?, Anyja_neve = ?, Magántelefon = ?, Magán_mobil = ?"
						+ ", Magán_email = ? WHERE Dolgozo_ID = ?";
				ps = con.prepareStatement(updateWorking);
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
			String updateWorkingHomeAddress = null;
			try {
				PreparedStatement ps = null;
				updateWorkingHomeAddress = "UPDATE Lakcím SET Irányítószám = ?, Ország = ?, Település = ?"
						+ ", Cím = ? WHERE Lakcím_Dolgozok_Dolgozo_ID = ?";
				ps = con.prepareStatement(updateWorkingHomeAddress);
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
				String updateWorkingMailingAddress = null;
				PreparedStatement ps = null;
				updateWorkingMailingAddress = "UPDATE Levcím SET Irányítószám_lev = ?, Ország_lev = ?, Település_lev = ?"
						+ ", Cím_lev = ? WHERE Levcím_Dolgozok_Dolgozo_ID = ?";
				ps = con.prepareStatement(updateWorkingMailingAddress);
				ps.setString(1, txtLetterZipCodeGui.getText());
				ps.setString(2, txtLetterCuntryGui.getText());
				ps.setString(3, txtLetterSettlementGui.getText());
				ps.setString(4, txtLetterTitleGui.getText());
				ps.setString(5, txtIDGui.getText());
				ps.executeUpdate();
				Show_Products_In_JTable();
			} catch (SQLException ex) {
				Logger.getLogger(JDBCWorkingSetDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
			try {
				String updateWorkingOrganization = null;
				PreparedStatement ps = null;
				updateWorkingOrganization = "UPDATE Szervezet SET Belépés_dátuma = ?, Kilépés_dátuma = ?, Beosztás = ?"
						+ ", Osztály = ?, Tevékenység = ?, Üzlei_telefon = ?, Üzleti_mobil = ?"
						+ ", Üzleti_email = ? WHERE Szervezet_Dolgozok_Dolgozo_ID = ?";
				ps = con.prepareStatement(updateWorkingOrganization);
				ps.setString(1, txtAddDate.getText());
				ps.setString(2, txtExitDate.getText());
				ps.setString(3, txtPostGui.getText());
				ps.setString(4, txtClassGui.getText());
				ps.setString(5, txtActivityGui.getText());
				ps.setString(6, txtOganizationLandlinePhoneGui.getText());
				ps.setString(7, txtOrganizationMobilPhoneGui.getText());
				ps.setString(8, txtOrganizationEmailGui.getText());
				ps.setString(9, txtIDGui.getText());
				ps.executeUpdate();
				Show_Products_In_JTable();
			} catch (SQLException ex) {
				Logger.getLogger(JDBCWorkingSetDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
			try {
				String updateWorkingDocuments = null;
				PreparedStatement ps = null;
				updateWorkingDocuments = "UPDATE okmányok SET Taj_szám = ?, Sz_ig_szám = ?, Adoazonosító = ?"
						+ ", Vezetői_engedély = ?, Útlevél = ? WHERE Okmány_Dolgozok_Dolgozo_ID = ?";
				ps = con.prepareStatement(updateWorkingDocuments);
				ps.setString(1, txtHealthCardWorkingGui.getText());
				ps.setString(2, txtIDCardWorkingGui.getText());
				ps.setString(3, txtTaxIDWorkingGui.getText());
				ps.setString(4, txtDrivingLicenseWorkingGui.getText());
				ps.setString(5, txtPassportWorkingGui.getText());
				ps.setString(6, txtIDGui.getText());
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
				PreparedStatement deleteWorkingDocuments = con
						.prepareStatement("DELETE FROM okmányok WHERE Okmány_Dolgozok_Dolgozo_ID = ? ");
				int idWorkingDocuments = Integer.parseInt(txtIDGui.getText());
				deleteWorkingDocuments.setInt(1, idWorkingDocuments);
				deleteWorkingDocuments.executeUpdate();
				PreparedStatement deleteWorkingOrganization = con
						.prepareStatement("DELETE FROM szervezet WHERE Szervezet_Dolgozok_Dolgozo_ID = ? ");
				int idWorkingOrganization = Integer.parseInt(txtIDGui.getText());
				deleteWorkingOrganization.setInt(1, idWorkingOrganization);
				deleteWorkingOrganization.executeUpdate();
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
				PreparedStatement deleteWorking = con.prepareStatement("DELETE FROM dolgozok WHERE Dolgozo_ID = ? ");
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
		txtIDCardWorkingGui.setText(null);
		txtHealthCardWorkingGui.setText(null);
		txtTaxIDWorkingGui.setText(null);
		txtDrivingLicenseWorkingGui.setText(null);
		txtPassportWorkingGui.setText(null);
		jLblWorkingImageGui.setIcon(null);
	}
}
