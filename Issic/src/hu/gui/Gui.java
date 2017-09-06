package hu.gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JRadioButton;

public class Gui extends JFrame {
	private static final long serialVersionUID = 1L;
	private JMenuBar jMnBar;
	private JMenu jMnFile;
	private JMenuItem jMnExitItem;
	protected JPanel jPanelGui;
	private JPanel jPnlGui;
	private JPanel kezdoJpanel;
	private JTabbedPane jTbdPaneGui;
	private JPanel jPnlWorkingGui;
	protected JTable tblWorking;
	private JScrollPane scrlPaneWorkingGui;
	private JLabel jLblWorkingGui;
	private JLabel jLblWorkingImageGui;
	private JTextField txtNameGui;
	private JButton btnNewGui;
	private JLabel jLblNameGui;
	private JLabel jLblDateOfBirthGui;
	private JTextField txtDateOfBirthGui;
	private JLabel jLblGenderGui;
	private JTextField txtIDGui;
	private JTextField txtMaidenNameGui;
	private JTextField txtMothersNameGui;
	private JRadioButton jRdBtnManGui, jRdBtnWomanGui;
	private Border a;
	private JLabel jLblDGui;
	private JLabel jLblMaidenNameGui;
	private JLabel jLblMothersNameGui;
	private JLabel jLblTitlesGui;
	private JLabel jLblHomeAddresGui;
	private JTextField txtHomeAddresGui;
	private JTextField txtZipCodeGui;
	private JTextField txtSettlementGui;
	private JTextField txtTitleGui;
	private JLabel jLblMailingAddress;
	private JTextField txtLetterContryGui;
	private JTextField txtLetterZipCodeGui;
	private JTextField txtLetterSettlementGui;
	private JTextField txtLetterTitleGui;
	private JLabel jLblCountryGui;
	private JLabel jLblSettlementGui;
	private JLabel jLblTitleGui;
	private JLabel jLblLetterContryGui;
	private JLabel jLblLetterSettlementGui;
	private JLabel jLblLetterTitleGui;
	private JLabel jLblCommunicationGui;
	private JLabel jLblPrivateLandlinePhoneGui;
	private JTextField txtPrivateLandlinePhoneGui;
	private JLabel jLblPrivateMobilPhoneGui;
	private JTextField txtPrivateMobilPhoneGui;
	private JTextField txtPrivateEmailGui;
	private JLabel jLblPrivateEmailGui;
	private JLabel jLblInstitutionGui;

	public Gui() {
		setComponent();

	}

	private void setComponent() {
		this.setSize(1300, 750);
		this.setVisible(true);
		Gui.iniComponent();
		this.setJMenuBar(jMnBar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		btnNewGui = new JButton("Új");
		btnNewGui.setBounds(1161, 26, 113, 33);

		jMnBar = new JMenuBar();
		jMnFile = new JMenu("Fájl");
		jMnExitItem = new JMenuItem("Kilépés");
		jMnBar.add(jMnFile);
		jMnFile.add(jMnExitItem);

		jPanelGui = new JPanel();
		jPnlGui = new JPanel();
		jPnlGui.setBounds(0, 0, 1284, 690);
		jPnlGui.setLayout(null);
		jPnlGui.add(btnNewGui);
		getContentPane().add(jPnlGui);

		jTbdPaneGui = new JTabbedPane(JTabbedPane.TOP);
		jTbdPaneGui.setBounds(0, 0, 1151, 690);

		kezdoJpanel = new JPanel();
		kezdoJpanel.setLayout(null);

		jTbdPaneGui.addTab("New tab", null, kezdoJpanel, null);
		jPnlWorkingGui = new JPanel();

		jTbdPaneGui.addTab("Dolgozok", null, jPnlWorkingGui, null);
		jPnlGui.add(jTbdPaneGui);
		jPnlWorkingGui.setLayout(null);

		scrlPaneWorkingGui = new JScrollPane();
		scrlPaneWorkingGui.setBounds(10, 12, 223, 402);
		jPnlWorkingGui.add(scrlPaneWorkingGui);

		tblWorking = new JTable();
		tblWorking.setBounds(10, 353, 223, -339);
		scrlPaneWorkingGui.setViewportView(tblWorking);

		jLblWorkingGui = new javax.swing.JLabel();
		jLblWorkingGui.setBounds(237, 5, 449, 204);
		jPnlWorkingGui.add(jLblWorkingGui);
		a = BorderFactory.createLineBorder(Color.DARK_GRAY);
		a = BorderFactory.createTitledBorder(a, "Partner adatok", TitledBorder.LEFT, TitledBorder.TOP);
		jLblWorkingGui.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Partner adatok",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));

		jLblWorkingImageGui = new JLabel();
		jLblWorkingImageGui.setOpaque(true);
		jLblWorkingImageGui.setBackground(new Color(204, 255, 255));
		jLblWorkingImageGui.setBounds(550, 21, 125, 177);
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
		txtNameGui.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNameGui.setBounds(367, 21, 179, 20);
		jPnlWorkingGui.add(txtNameGui);
		txtNameGui.setColumns(10);

		txtDateOfBirthGui = new JTextField();
		txtDateOfBirthGui.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtDateOfBirthGui.setColumns(10);
		txtDateOfBirthGui.setBounds(367, 56, 179, 20);
		jPnlWorkingGui.add(txtDateOfBirthGui);

		jRdBtnWomanGui = new JRadioButton("Nő");
		jRdBtnWomanGui.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jRdBtnWomanGui.setBounds(388, 84, 44, 23);
		jPnlWorkingGui.add(jRdBtnWomanGui);

		jRdBtnManGui = new JRadioButton("Férfi");
		jRdBtnManGui.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jRdBtnManGui.setBounds(458, 84, 60, 23);
		jPnlWorkingGui.add(jRdBtnManGui);

		txtIDGui = new JTextField();
		txtIDGui.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtIDGui.setColumns(10);
		txtIDGui.setBounds(367, 118, 179, 20);
		jPnlWorkingGui.add(txtIDGui);

		txtMaidenNameGui = new JTextField();
		txtMaidenNameGui.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMaidenNameGui.setColumns(10);
		txtMaidenNameGui.setBounds(367, 149, 179, 20);
		jPnlWorkingGui.add(txtMaidenNameGui);

		txtMothersNameGui = new JTextField();
		txtMothersNameGui.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMothersNameGui.setColumns(10);
		txtMothersNameGui.setBounds(367, 180, 179, 20);
		jPnlWorkingGui.add(txtMothersNameGui);

		jLblTitlesGui = new JLabel();
		jLblTitlesGui.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Címek",

				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		jLblTitlesGui.setBounds(237, 209, 449, 207);
		jPnlWorkingGui.add(jLblTitlesGui);

		jLblHomeAddresGui = new JLabel();
		jLblHomeAddresGui.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Lakcím",

				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		jLblHomeAddresGui.setBounds(247, 225, 428, 88);
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

		txtHomeAddresGui = new JTextField();
		txtHomeAddresGui.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtHomeAddresGui.setColumns(10);
		txtHomeAddresGui.setBounds(392, 237, 276, 20);
		jPnlWorkingGui.add(txtHomeAddresGui);

		txtZipCodeGui = new JTextField();
		txtZipCodeGui.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtZipCodeGui.setColumns(10);
		txtZipCodeGui.setBounds(392, 261, 95, 20);
		jPnlWorkingGui.add(txtZipCodeGui);

		txtSettlementGui = new JTextField();
		txtSettlementGui.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSettlementGui.setColumns(10);
		txtSettlementGui.setBounds(489, 261, 179, 20);
		jPnlWorkingGui.add(txtSettlementGui);

		txtTitleGui = new JTextField();
		txtTitleGui.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTitleGui.setColumns(10);
		txtTitleGui.setBounds(392, 284, 276, 20);
		jPnlWorkingGui.add(txtTitleGui);

		jLblMailingAddress = new JLabel();
		jLblMailingAddress.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Levelezési cím",

				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		jLblMailingAddress.setBounds(247, 318, 428, 88);
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

		txtLetterContryGui = new JTextField();
		txtLetterContryGui.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtLetterContryGui.setColumns(10);
		txtLetterContryGui.setBounds(392, 331, 276, 20);
		jPnlWorkingGui.add(txtLetterContryGui);

		txtLetterZipCodeGui = new JTextField();
		txtLetterZipCodeGui.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtLetterZipCodeGui.setColumns(10);
		txtLetterZipCodeGui.setBounds(392, 355, 95, 20);
		jPnlWorkingGui.add(txtLetterZipCodeGui);

		txtLetterSettlementGui = new JTextField();
		txtLetterSettlementGui.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtLetterSettlementGui.setColumns(10);
		txtLetterSettlementGui.setBounds(489, 355, 179, 20);
		jPnlWorkingGui.add(txtLetterSettlementGui);

		txtLetterTitleGui = new JTextField();
		txtLetterTitleGui.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtLetterTitleGui.setColumns(10);
		txtLetterTitleGui.setBounds(392, 379, 276, 20);
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
		txtPrivateLandlinePhoneGui.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPrivateLandlinePhoneGui.setColumns(10);
		txtPrivateLandlinePhoneGui.setBounds(791, 54, 179, 20);
		jPnlWorkingGui.add(txtPrivateLandlinePhoneGui);
		
		txtPrivateMobilPhoneGui = new JTextField();
		txtPrivateMobilPhoneGui.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPrivateMobilPhoneGui.setColumns(10);
		txtPrivateMobilPhoneGui.setBounds(791, 23, 179, 20);
		jPnlWorkingGui.add(txtPrivateMobilPhoneGui);
		
		txtPrivateEmailGui = new JTextField();
		txtPrivateEmailGui.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPrivateEmailGui.setColumns(10);
		txtPrivateEmailGui.setBounds(791, 87, 179, 20);
		jPnlWorkingGui.add(txtPrivateEmailGui);
		
		jLblInstitutionGui = new JLabel();
		jLblInstitutionGui.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Partner adatok",
						TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		jLblInstitutionGui.setBounds(690, 121, 294, 295);
		jPnlWorkingGui.add(jLblInstitutionGui);

	}

	public static void iniComponent() {

	}
}
