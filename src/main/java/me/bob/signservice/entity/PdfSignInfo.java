package me.bob.signservice.entity;

import java.util.Date;

/**
 * @author Bob
 * @create 2020-03-12
 * @since 1.0.0
 */
public class PdfSignInfo {

    private Date signDate;
    private String digestAlgorithm;
    private String reason;
    private String location;
    private String signatureName;
    private String encryptionAlgorithm;
    private String signerName;
    private String contactInfo;
    private int revisionNumber;

    public int getRevisionNumber() {
        return revisionNumber;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getSignerName() {
        return signerName;
    }

    public void setSignerName(String signerName) {
        this.signerName = signerName;
    }

    public String getEncryptionAlgorithm() {
        return encryptionAlgorithm;
    }

    public void setEncryptionAlgorithm(String encryptionAlgorithm) {
        this.encryptionAlgorithm = encryptionAlgorithm;
    }

    public String getSignatureName() {
        return signatureName;
    }

    public void setSignatureName(String signatureName) {
        this.signatureName = signatureName;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getSignDate() {
        return signDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDigestAlgorithm() {
        return digestAlgorithm;
    }

    public void setDigestAlgorithm(String digestAlgorithm) {
        this.digestAlgorithm = digestAlgorithm;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setRevisionNumber(int revisionNumber) {
        this.revisionNumber = revisionNumber;
    }
}
