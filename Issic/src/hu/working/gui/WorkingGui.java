package hu.working.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import hu.gui.Gui;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class WorkingGui extends Gui {
	protected JTable tblWorking;
	protected JScrollPane scrlPaneWorkingGui;
	protected JLabel jLblWorkingGui;
	protected JLabel jLblWorkingImageGui;
	protected JTextField txtNameGui;
	protected JLabel jLblNameGui;
	protected JLabel jLblDateOfBirthGui;
	protected JTextField txtDateOfBirthGui;
	protected JLabel jLblGenderGui;
	protected JTextField txtIDGui;
	protected JTextField txtMaidenNameGui;
	protected JTextField txtMothersNameGui;
	protected Border a;
	protected JLabel jLblDGui;
	protected JLabel jLblMaidenNameGui;
	protected JLabel jLblMothersNameGui;
	protected JLabel jLblTitlesGui;
	protected JLabel jLblHomeAddresGui;
	protected JTextField txtCuntryAddresGui;
	protected JTextField txtZipCodeGui;
	protected JTextField txtSettlementGui;
	protected JTextField txtTitleGui;
	protected JLabel jLblMailingAddress;
	protected JTextField txtLetterCuntryGui;
	protected JTextField txtLetterZipCodeGui;
	protected JTextField txtLetterSettlementGui;
	protected JTextField txtLetterTitleGui;
	protected JLabel jLblCountryGui;
	protected JLabel jLblSettlementGui;
	protected JLabel jLblTitleGui;
	protected JLabel jLblLetterContryGui;
	protected JLabel jLblLetterSettlementGui;
	protected JLabel jLblLetterTitleGui;
	protected JLabel jLblCommunicationGui;
	protected JLabel jLblPrivateLandlinePhoneGui;
	protected JTextField txtPrivateMobilPhoneGui;
	protected JLabel jLblPrivateMobilPhoneGui;
	protected JTextField txtPrivateLandlinePhoneGui;
	protected JTextField txtPrivateEmailGui;
	protected JLabel jLblPrivateEmailGui;
	protected JLabel jLblInstitutionGui;
	protected JLabel jLblEntryGui;
	protected JLabel jLblEgressGui;
	protected JLabel jLblPostGui;
	protected JLabel jLblClassGui;
	protected JLabel jLblOganizationLandlinePhoneGui;
	protected JLabel jLblOrganizationMobilPhoneGui;
	protected JLabel jLblOrganizationEmailGui;
	protected JLabel jLblActivityGui;
	protected JTextField txtAddDate;
	protected JTextField txtExitDate;
	protected JTextField txtPostGui;
	protected JTextField txtOganizationLandlinePhoneGui;
	protected JTextField txtOrganizationMobilPhoneGui;
	protected JTextField txtOrganizationEmailGui;
	protected JTextField txtClassGui;
	protected JTextField txtActivityGui;
	protected JButton btnNewWorkingGui;
	protected JButton btnEditingWorkingGui;
	protected JButton btnDeleteWorkingGui;
	protected JButton btnDeleteShowWorkingGui;
	protected JButton btnWorkingImage;
	private JTextField textField;
	private JTabbedPane tabbedPane;
	private JPanel jPnlDocumentWorkingGui;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel jLblDocumentWorkingGui;
	private JLabel jLbIDCardWorkingGui;
	private JLabel jLblHealthCardWorkingGui;
	private JLabel jLblTaxIDWorkingGui;
	private JLabel jLblDrivingLicenseWorkingGui;
	private JLabel jLblPassportWorkingGui;
	protected JTextField txtIDCardWorkingGui;
	protected JTextField txtHealthCardWorkingGui;
	protected JTextField txtTaxIDWorkingGui;
	protected JTextField txtDrivingLicenseWorkingGui;
	protected JTextField txtPassportWorkingGui;
	protected JTextField txtGenderGui;

	public WorkingGui() {
		jTbdPaneGui.setFont(new Font("Tahoma", Font.PLAIN, 13));
		setComponents();
	}

	protected void setComponents() {
		scrlPaneWorkingGui = new JScrollPane();
		scrlPaneWorkingGui.setBounds(10, 12, 223, 402);
		jPnlWorkingGui.add(scrlPaneWorkingGui);

		tblWorking = new JTable();
		tblWorking.setBounds(10, 353, 223, -339);
		scrlPaneWorkingGui.setViewportView(tblWorking);

		jLblWorkingGui = new javax.swing.JLabel();
		jLblWorkingGui.setBounds(243, 5, 449, 205);
		jPnlWorkingGui.add(jLblWorkingGui);
		a = BorderFactory.createLineBorder(Color.DARK_GRAY);
		a = BorderFactory.createTitledBorder(a, " ", TitledBorder.LEFT, TitledBorder.TOP);
		jLblWorkingGui.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Dolgozói adatok",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));

		jLblWorkingImageGui = new JLabel();
		jLblWorkingImageGui.setIcon(new ImageIcon("data\\Image\\Alap.png"));
		jLblWorkingImageGui.setOpaque(true);
		jLblWorkingImageGui.setBackground(new Color(204, 255, 255));
		jLblWorkingImageGui.setBounds(550, 21, 125, 182);
		jPnlWorkingGui.add(jLblWorkingImageGui);

		jLblNameGui = new JLabel("Név: ");
		jLblNameGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblNameGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblNameGui.setBounds(254, 21, 114, 20);
		jPnlWorkingGui.add(jLblNameGui);

		jLblDateOfBirthGui = new JLabel("Születési dátum: ");
		jLblDateOfBirthGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblDateOfBirthGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblDateOfBirthGui.setBounds(243, 54, 125, 20);
		jPnlWorkingGui.add(jLblDateOfBirthGui);

		jLblDGui = new JLabel("Azonosító: ");
		jLblDGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblDGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblDGui.setBounds(254, 116, 114, 20);
		jPnlWorkingGui.add(jLblDGui);

		jLblGenderGui = new JLabel("Neme: ");
		jLblGenderGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblGenderGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblGenderGui.setBounds(254, 85, 114, 20);
		jPnlWorkingGui.add(jLblGenderGui);

		jLblMaidenNameGui = new JLabel("Leánykori neve: ");
		jLblMaidenNameGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblMaidenNameGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblMaidenNameGui.setBounds(243, 147, 125, 20);
		jPnlWorkingGui.add(jLblMaidenNameGui);

		jLblMothersNameGui = new JLabel("Anyja neve: ");
		jLblMothersNameGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblMothersNameGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblMothersNameGui.setBounds(254, 178, 114, 20);
		jPnlWorkingGui.add(jLblMothersNameGui);

		txtNameGui = new JTextField();
		txtNameGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNameGui.setBounds(367, 21, 179, 25);
		jPnlWorkingGui.add(txtNameGui);
		txtNameGui.setColumns(10);

		txtDateOfBirthGui = new JTextField();
		txtDateOfBirthGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDateOfBirthGui.setColumns(10);
		txtDateOfBirthGui.setBounds(367, 56, 179, 25);
		jPnlWorkingGui.add(txtDateOfBirthGui);

		txtGenderGui = new JTextField();
		txtGenderGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtGenderGui.setColumns(10);
		txtGenderGui.setBounds(367, 85, 179, 25);
		jPnlWorkingGui.add(txtGenderGui);

		txtIDGui = new JTextField();
		txtIDGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtIDGui.setColumns(10);
		txtIDGui.setBounds(367, 118, 179, 25);
		jPnlWorkingGui.add(txtIDGui);

		txtMaidenNameGui = new JTextField();
		txtMaidenNameGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtMaidenNameGui.setColumns(10);
		txtMaidenNameGui.setBounds(367, 149, 179, 25);
		jPnlWorkingGui.add(txtMaidenNameGui);

		txtMothersNameGui = new JTextField();
		txtMothersNameGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtMothersNameGui.setColumns(10);
		txtMothersNameGui.setBounds(367, 180, 179, 25);
		jPnlWorkingGui.add(txtMothersNameGui);

		jLblTitlesGui = new JLabel();
		jLblTitlesGui.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Címek",

				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		jLblTitlesGui.setBounds(237, 209, 449, 207);
		jPnlWorkingGui.add(jLblTitlesGui);

		jLblHomeAddresGui = new JLabel();
		jLblHomeAddresGui.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Lakcím",

				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		jLblHomeAddresGui.setBounds(247, 225, 428, 95);
		jPnlWorkingGui.add(jLblHomeAddresGui);

		jLblCountryGui = new JLabel("Ország: ");
		jLblCountryGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblCountryGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblCountryGui.setBounds(280, 237, 114, 20);
		jPnlWorkingGui.add(jLblCountryGui);

		jLblSettlementGui = new JLabel("Település: ");
		jLblSettlementGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblSettlementGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblSettlementGui.setBounds(280, 261, 114, 20);
		jPnlWorkingGui.add(jLblSettlementGui);

		jLblTitleGui = new JLabel("Cím: ");
		jLblTitleGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblTitleGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblTitleGui.setBounds(280, 284, 114, 20);
		jPnlWorkingGui.add(jLblTitleGui);

		txtCuntryAddresGui = new JTextField();
		txtCuntryAddresGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCuntryAddresGui.setColumns(10);
		txtCuntryAddresGui.setBounds(392, 237, 276, 25);
		jPnlWorkingGui.add(txtCuntryAddresGui);

		txtZipCodeGui = new JTextField();
		txtZipCodeGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtZipCodeGui.setColumns(10);
		txtZipCodeGui.setBounds(392, 263, 95, 25);
		jPnlWorkingGui.add(txtZipCodeGui);

		txtSettlementGui = new JTextField();
		txtSettlementGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtSettlementGui.setColumns(10);
		txtSettlementGui.setBounds(489, 263, 179, 25);
		jPnlWorkingGui.add(txtSettlementGui);

		txtTitleGui = new JTextField();
		txtTitleGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTitleGui.setColumns(10);
		txtTitleGui.setBounds(392, 289, 276, 25);
		jPnlWorkingGui.add(txtTitleGui);

		jLblMailingAddress = new JLabel();
		jLblMailingAddress.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Levelezési cím",

				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		jLblMailingAddress.setBounds(247, 318, 428, 95);
		jPnlWorkingGui.add(jLblMailingAddress);

		jLblLetterContryGui = new JLabel("Lev. ország: ");
		jLblLetterContryGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblLetterContryGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblLetterContryGui.setBounds(280, 331, 114, 20);
		jPnlWorkingGui.add(jLblLetterContryGui);

		jLblLetterSettlementGui = new JLabel("Lev. település: ");
		jLblLetterSettlementGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblLetterSettlementGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblLetterSettlementGui.setBounds(280, 355, 114, 20);
		jPnlWorkingGui.add(jLblLetterSettlementGui);

		txtLetterCuntryGui = new JTextField();
		txtLetterCuntryGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLetterCuntryGui.setColumns(10);
		txtLetterCuntryGui.setBounds(392, 330, 276, 25);
		jPnlWorkingGui.add(txtLetterCuntryGui);

		txtLetterZipCodeGui = new JTextField();
		txtLetterZipCodeGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLetterZipCodeGui.setColumns(10);
		txtLetterZipCodeGui.setBounds(392, 356, 95, 25);
		jPnlWorkingGui.add(txtLetterZipCodeGui);

		txtLetterSettlementGui = new JTextField();
		txtLetterSettlementGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLetterSettlementGui.setColumns(10);
		txtLetterSettlementGui.setBounds(489, 356, 179, 25);
		jPnlWorkingGui.add(txtLetterSettlementGui);

		txtLetterTitleGui = new JTextField();
		txtLetterTitleGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLetterTitleGui.setColumns(10);
		txtLetterTitleGui.setBounds(392, 382, 276, 25);
		jPnlWorkingGui.add(txtLetterTitleGui);

		jLblLetterTitleGui = new JLabel("Lev. cím: ");
		jLblLetterTitleGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblLetterTitleGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblLetterTitleGui.setBounds(280, 379, 114, 20);
		jPnlWorkingGui.add(jLblLetterTitleGui);

		jLblCommunicationGui = new JLabel();
		jLblCommunicationGui.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Elérhetőség",

				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		jLblCommunicationGui.setBounds(690, 5, 294, 117);
		jPnlWorkingGui.add(jLblCommunicationGui);

		jLblPrivateLandlinePhoneGui = new JLabel("Vez. telefon: ");
		jLblPrivateLandlinePhoneGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblPrivateLandlinePhoneGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblPrivateLandlinePhoneGui.setBounds(696, 21, 97, 20);
		jPnlWorkingGui.add(jLblPrivateLandlinePhoneGui);

		jLblPrivateMobilPhoneGui = new JLabel("Mobil: ");
		jLblPrivateMobilPhoneGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblPrivateMobilPhoneGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblPrivateMobilPhoneGui.setBounds(696, 54, 97, 20);
		jPnlWorkingGui.add(jLblPrivateMobilPhoneGui);

		jLblPrivateEmailGui = new JLabel("E-mail: ");
		jLblPrivateEmailGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblPrivateEmailGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblPrivateEmailGui.setBounds(696, 87, 97, 20);
		jPnlWorkingGui.add(jLblPrivateEmailGui);

		txtPrivateLandlinePhoneGui = new JTextField();
		txtPrivateLandlinePhoneGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPrivateLandlinePhoneGui.setColumns(10);
		txtPrivateLandlinePhoneGui.setBounds(791, 23, 179, 25);
		jPnlWorkingGui.add(txtPrivateLandlinePhoneGui);

		txtPrivateMobilPhoneGui = new JTextField();
		txtPrivateMobilPhoneGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPrivateMobilPhoneGui.setColumns(10);
		txtPrivateMobilPhoneGui.setBounds(791, 54, 179, 25);
		jPnlWorkingGui.add(txtPrivateMobilPhoneGui);

		txtPrivateEmailGui = new JTextField();
		txtPrivateEmailGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPrivateEmailGui.setColumns(10);
		txtPrivateEmailGui.setBounds(791, 87, 179, 25);
		jPnlWorkingGui.add(txtPrivateEmailGui);

		jLblInstitutionGui = new JLabel();
		jLblInstitutionGui.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Szervezet",

				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		jLblInstitutionGui.setBounds(690, 121, 294, 295);
		jPnlWorkingGui.add(jLblInstitutionGui);

		jLblEntryGui = new JLabel("Belépés: ");
		jLblEntryGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblEntryGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblEntryGui.setBounds(696, 137, 97, 20);
		jPnlWorkingGui.add(jLblEntryGui);

		jLblEgressGui = new JLabel("Kilépés: ");
		jLblEgressGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblEgressGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblEgressGui.setBounds(696, 166, 97, 20);
		jPnlWorkingGui.add(jLblEgressGui);

		jLblPostGui = new JLabel("Beosztás: ");
		jLblPostGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblPostGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblPostGui.setBounds(696, 195, 97, 20);
		jPnlWorkingGui.add(jLblPostGui);

		jLblClassGui = new JLabel("Osztály: ");
		jLblClassGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblClassGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblClassGui.setBounds(696, 224, 97, 20);
		jPnlWorkingGui.add(jLblClassGui);

		jLblOganizationLandlinePhoneGui = new JLabel("Vez. Telefon: ");
		jLblOganizationLandlinePhoneGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblOganizationLandlinePhoneGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblOganizationLandlinePhoneGui.setBounds(696, 253, 97, 20);
		jPnlWorkingGui.add(jLblOganizationLandlinePhoneGui);

		jLblOrganizationMobilPhoneGui = new JLabel("Mobil: ");
		jLblOrganizationMobilPhoneGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblOrganizationMobilPhoneGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblOrganizationMobilPhoneGui.setBounds(696, 282, 97, 20);
		jPnlWorkingGui.add(jLblOrganizationMobilPhoneGui);

		jLblOrganizationEmailGui = new JLabel("E-mail: ");
		jLblOrganizationEmailGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblOrganizationEmailGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblOrganizationEmailGui.setBounds(696, 311, 97, 20);
		jPnlWorkingGui.add(jLblOrganizationEmailGui);

		jLblActivityGui = new JLabel("Tevékenység: ");
		jLblActivityGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblActivityGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblActivityGui.setBounds(685, 340, 108, 20);
		jPnlWorkingGui.add(jLblActivityGui);

		txtAddDate = new JTextField();
		txtAddDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtAddDate.setColumns(10);
		txtAddDate.setBounds(791, 139, 179, 25);
		jPnlWorkingGui.add(txtAddDate);

		txtExitDate = new JTextField();
		txtExitDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtExitDate.setColumns(10);
		txtExitDate.setBounds(791, 168, 179, 25);
		jPnlWorkingGui.add(txtExitDate);

		txtPostGui = new JTextField();
		txtPostGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPostGui.setColumns(10);
		txtPostGui.setBounds(791, 197, 179, 25);
		jPnlWorkingGui.add(txtPostGui);

		txtClassGui = new JTextField();
		txtClassGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtClassGui.setColumns(10);
		txtClassGui.setBounds(791, 226, 179, 25);
		jPnlWorkingGui.add(txtClassGui);

		txtOganizationLandlinePhoneGui = new JTextField();
		txtOganizationLandlinePhoneGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtOganizationLandlinePhoneGui.setColumns(10);
		txtOganizationLandlinePhoneGui.setBounds(791, 255, 179, 25);
		jPnlWorkingGui.add(txtOganizationLandlinePhoneGui);

		txtOrganizationMobilPhoneGui = new JTextField();
		txtOrganizationMobilPhoneGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtOrganizationMobilPhoneGui.setColumns(10);
		txtOrganizationMobilPhoneGui.setBounds(791, 284, 179, 25);
		jPnlWorkingGui.add(txtOrganizationMobilPhoneGui);

		txtOrganizationEmailGui = new JTextField();
		txtOrganizationEmailGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtOrganizationEmailGui.setColumns(10);
		txtOrganizationEmailGui.setBounds(791, 313, 179, 25);
		jPnlWorkingGui.add(txtOrganizationEmailGui);

		txtActivityGui = new JTextField();
		txtActivityGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtActivityGui.setColumns(10);
		txtActivityGui.setBounds(791, 342, 179, 64);
		jPnlWorkingGui.add(txtActivityGui);

		btnNewWorkingGui = new JButton("Új Melos");
		btnNewWorkingGui.setBounds(1009, 12, 113, 33);
		jPnlWorkingGui.add(btnNewWorkingGui);

		btnEditingWorkingGui = new JButton("Szerkesztés");
		btnEditingWorkingGui.setBounds(1009, 54, 113, 33);
		jPnlWorkingGui.add(btnEditingWorkingGui);

		btnDeleteWorkingGui = new JButton("Törlés");
		btnDeleteWorkingGui.setBounds(1009, 143, 113, 33);
		jPnlWorkingGui.add(btnDeleteWorkingGui);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(10, 418, 974, 25);
		jPnlWorkingGui.add(textField);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 449, 984, 211);
		jPnlWorkingGui.add(tabbedPane);

		jPnlDocumentWorkingGui = new JPanel();
		tabbedPane.addTab("Okmányok", null, jPnlDocumentWorkingGui, null);
		jPnlDocumentWorkingGui.setLayout(null);

		jLblDocumentWorkingGui = new JLabel();
		jLblDocumentWorkingGui.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Okmányok",

				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		jLblDocumentWorkingGui.setBounds(10, 0, 313, 172);
		jPnlDocumentWorkingGui.add(jLblDocumentWorkingGui);

		jLbIDCardWorkingGui = new JLabel("Sz. ig. szám: ");
		jLbIDCardWorkingGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLbIDCardWorkingGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLbIDCardWorkingGui.setBounds(21, 19, 108, 20);
		jPnlDocumentWorkingGui.add(jLbIDCardWorkingGui);

		jLblHealthCardWorkingGui = new JLabel("TAJ: ");
		jLblHealthCardWorkingGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblHealthCardWorkingGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblHealthCardWorkingGui.setBounds(21, 49, 108, 20);
		jPnlDocumentWorkingGui.add(jLblHealthCardWorkingGui);

		jLblTaxIDWorkingGui = new JLabel("Adóazonosító: ");
		jLblTaxIDWorkingGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblTaxIDWorkingGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblTaxIDWorkingGui.setBounds(21, 79, 108, 20);
		jPnlDocumentWorkingGui.add(jLblTaxIDWorkingGui);

		jLblDrivingLicenseWorkingGui = new JLabel("Vezetői eng.: ");
		jLblDrivingLicenseWorkingGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblDrivingLicenseWorkingGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblDrivingLicenseWorkingGui.setBounds(21, 109, 108, 20);
		jPnlDocumentWorkingGui.add(jLblDrivingLicenseWorkingGui);

		jLblPassportWorkingGui = new JLabel("Útlevélszám: ");
		jLblPassportWorkingGui.setHorizontalAlignment(SwingConstants.RIGHT);
		jLblPassportWorkingGui.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLblPassportWorkingGui.setBounds(21, 139, 108, 20);
		jPnlDocumentWorkingGui.add(jLblPassportWorkingGui);

		txtIDCardWorkingGui = new JTextField();
		txtIDCardWorkingGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtIDCardWorkingGui.setColumns(10);
		txtIDCardWorkingGui.setBounds(126, 21, 179, 25);
		jPnlDocumentWorkingGui.add(txtIDCardWorkingGui);

		txtHealthCardWorkingGui = new JTextField();
		txtHealthCardWorkingGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtHealthCardWorkingGui.setColumns(10);
		txtHealthCardWorkingGui.setBounds(126, 50, 179, 25);
		jPnlDocumentWorkingGui.add(txtHealthCardWorkingGui);

		txtTaxIDWorkingGui = new JTextField();
		txtTaxIDWorkingGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTaxIDWorkingGui.setColumns(10);
		txtTaxIDWorkingGui.setBounds(126, 79, 179, 25);
		jPnlDocumentWorkingGui.add(txtTaxIDWorkingGui);

		txtDrivingLicenseWorkingGui = new JTextField();
		txtDrivingLicenseWorkingGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDrivingLicenseWorkingGui.setColumns(10);
		txtDrivingLicenseWorkingGui.setBounds(126, 110, 179, 25);
		jPnlDocumentWorkingGui.add(txtDrivingLicenseWorkingGui);

		txtPassportWorkingGui = new JTextField();
		txtPassportWorkingGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPassportWorkingGui.setColumns(10);
		txtPassportWorkingGui.setBounds(126, 140, 179, 25);
		jPnlDocumentWorkingGui.add(txtPassportWorkingGui);

		panel_2 = new JPanel();
		tabbedPane.addTab("Iskolák", null, panel_2, null);

		panel_3 = new JPanel();
		tabbedPane.addTab("Tanfolyamok", null, panel_3, null);

		tblWorking.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Partner név" }));

		btnDeleteShowWorkingGui = new JButton("Null");
		btnDeleteShowWorkingGui.setBounds(1009, 98, 113, 33);
		jPnlWorkingGui.add(btnDeleteShowWorkingGui);

		btnWorkingImage = new JButton("Feltöltés");
		btnWorkingImage.setBounds(1009, 196, 113, 33);
		jPnlWorkingGui.add(btnWorkingImage);
	}

	public static void iniComponent() {

	}
}
