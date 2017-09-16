package hu.working;

public class Working {
	private Integer workingID, zipCode, letterZipCode, healthCard, taxID;
	private String workingName, maidenName, gender, dateOfBirth, mothersName, privatePhone, privateMobil, privateEmail,
			cuntry, settlement, title, letterCuntry, letterSettlement, letterTitle, addDate, exitDate, post,
			classWorking, oganizationLandlinePhone, oganizationMobilPhone, oganizationEmail, activity, iDCard,
			drivingLicense, passport;

	public Working(Integer wWorkingId, String wWorkingName, String wMaidenName, String wGender, String wDateOfBirth,
			String wMothersName, String wPrivatePhone, String wPrivateMobil, String wPrivateEmail, Integer wZipCode,
			String wCuntry, String wSettlement, String wTitle, Integer wLetterZipCode, String wLetterCuntry,
			String wLetterSettlement, String wLetterTitle, String wAddDate, String wExitDate, String wPost,
			String wClassWorking, String wActivity, String wOganizationLandlinePhone, String wOganizationMobilPhone,
			String wOanizationEmail
	// String wIDCard, Integer wHealthCard,
	// Integer
	// wTaxID, String wDivingLicense,
	// String wPassport
	) {
		this.workingID = wWorkingId;
		this.workingName = wWorkingName;
		this.maidenName = wMaidenName;
		this.gender = wGender;
		this.dateOfBirth = wDateOfBirth;
		this.mothersName = wMothersName;
		this.privatePhone = wPrivatePhone;
		this.privateMobil = wPrivateMobil;
		this.privateEmail = wPrivateEmail;
		this.zipCode = wZipCode;
		this.cuntry = wCuntry;
		this.settlement = wSettlement;
		this.title = wTitle;
		this.letterZipCode = wLetterZipCode;
		this.letterCuntry = wLetterCuntry;
		this.letterSettlement = wLetterSettlement;
		this.letterTitle = wLetterTitle;
		this.addDate = wAddDate;
		this.exitDate = wExitDate;
		this.post = wPost;
		this.classWorking = wClassWorking;
		this.activity = wActivity;
		this.oganizationLandlinePhone = wOganizationLandlinePhone;
		this.oganizationMobilPhone = wOganizationMobilPhone;
		this.oganizationEmail = wOanizationEmail;
		// this.healthCard = wHealthCard;
		// this.taxID = wTaxID;
		// this.iDCard = wIDCard;
		// this.drivingLicense = wDivingLicense;
		// this.passport = wPassport;
	}

	public Integer getWorkingID() {
		return workingID;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public Integer getLetterZipCode() {
		return letterZipCode;
	}

	public Integer getHealthCard() {
		return healthCard;
	}

	public Integer getTaxID() {
		return taxID;
	}

	public String getWorkingName() {
		return workingName;
	}

	public String getMaidenName() {
		return maidenName;
	}

	public String getGender() {
		return gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getMothersName() {
		return mothersName;
	}

	public String getPrivatePhone() {
		return privatePhone;
	}

	public String getPrivateMobil() {
		return privateMobil;
	}

	public String getPrivateEmail() {
		return privateEmail;
	}

	public String getCuntry() {
		return cuntry;
	}

	public String getSettlement() {
		return settlement;
	}

	public String getTitle() {
		return title;
	}

	public String getLetterContry() {
		return letterCuntry;
	}

	public String getLetterSettlement() {
		return letterSettlement;
	}

	public String getLetterTitle() {
		return letterTitle;
	}

	public String getAddDate() {
		return addDate;
	}

	public String getExitDate() {
		return exitDate;
	}

	public String getPost() {
		return post;
	}

	public String getClassWorking() {
		return classWorking;
	}

	public String getOganizationLandlinePhone() {
		return oganizationLandlinePhone;
	}

	public String getOganizationMobilPhone() {
		return oganizationMobilPhone;
	}

	public String getOganizationEmail() {
		return oganizationEmail;
	}

	public String getActivity() {
		return activity;
	}

	public String getiDCard() {
		return iDCard;
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public String getPassport() {
		return passport;
	}

}
