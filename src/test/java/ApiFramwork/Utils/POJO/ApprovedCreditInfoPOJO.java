package ApiFramwork.Utils.POJO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ApprovedCreditInfoPOJO {

    public String customerName;
    public String creditProduct;
    public String pan;
    public String creditProgramName;
    public String creditPartnerName;
    public String vendorMmId;
    public double creditSanctioned;
    public double creditUtilised;
    public double creditBlocked;
    public double creditAvailable;
    public double creditUsable;
    public int creditDueDay;
    public boolean isCreditBlocked;
    public String creditBlockedReason;
    public String creditLimitId;
    public Object blockedDetails;
    public boolean visibleToCustomer;
    public String currentTime;
    public List<String> customerGstins;
    public Object utilisedDetails;
    public String displayName;
    public double interestRate;
    public String creditExpiry;
    public double penalRate;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCreditProduct() {
        return creditProduct;
    }

    public void setCreditProduct(String creditProduct) {
        this.creditProduct = creditProduct;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getCreditProgramName() {
        return creditProgramName;
    }

    public void setCreditProgramName(String creditProgramName) {
        this.creditProgramName = creditProgramName;
    }

    public String getCreditPartnerName() {
        return creditPartnerName;
    }

    public void setCreditPartnerName(String creditPartnerName) {
        this.creditPartnerName = creditPartnerName;
    }

    public String getVendorMmId() {
        return vendorMmId;
    }

    public void setVendorMmId(String vendorMmId) {
        this.vendorMmId = vendorMmId;
    }

    public double getCreditSanctioned() {
        return creditSanctioned;
    }

    public void setCreditSanctioned(double creditSanctioned) {
        this.creditSanctioned = creditSanctioned;
    }

    public double getCreditUtilised() {
        return creditUtilised;
    }

    public void setCreditUtilised(double creditUtilised) {
        this.creditUtilised = creditUtilised;
    }

    public double getCreditBlocked() {
        return creditBlocked;
    }

    public void setCreditBlocked(double creditBlocked) {
        this.creditBlocked = creditBlocked;
    }

    public double getCreditAvailable() {
        return creditAvailable;
    }

    public void setCreditAvailable(double creditAvailable) {
        this.creditAvailable = creditAvailable;
    }

    public double getCreditUsable() {
        return creditUsable;
    }

    public void setCreditUsable(double creditUsable) {
        this.creditUsable = creditUsable;
    }

    public int getCreditDueDay() {
        return creditDueDay;
    }

    public void setCreditDueDay(int creditDueDay) {
        this.creditDueDay = creditDueDay;
    }

    public boolean isCreditBlocked() {
        return isCreditBlocked;
    }

    public void setCreditBlocked(boolean creditBlocked) {
        isCreditBlocked = creditBlocked;
    }

    public String getCreditBlockedReason() {
        return creditBlockedReason;
    }

    public void setCreditBlockedReason(String creditBlockedReason) {
        this.creditBlockedReason = creditBlockedReason;
    }

    public String getCreditLimitId() {
        return creditLimitId;
    }

    public void setCreditLimitId(String creditLimitId) {
        this.creditLimitId = creditLimitId;
    }

    public Object getBlockedDetails() {
        return blockedDetails;
    }

    public void setBlockedDetails(Object blockedDetails) {
        this.blockedDetails = blockedDetails;
    }

    public boolean isVisibleToCustomer() {
        return visibleToCustomer;
    }

    public void setVisibleToCustomer(boolean visibleToCustomer) {
        this.visibleToCustomer = visibleToCustomer;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public List<String> getCustomerGstins() {
        return customerGstins;
    }

    public void setCustomerGstins(List<String> customerGstins) {
        this.customerGstins = customerGstins;
    }

    public Object getUtilisedDetails() {
        return utilisedDetails;
    }

    public void setUtilisedDetails(Object utilisedDetails) {
        this.utilisedDetails = utilisedDetails;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getCreditExpiry() {
        return creditExpiry;
    }

    public void setCreditExpiry(String creditExpiry) {
        this.creditExpiry = creditExpiry;
    }

    public double getPenalRate() {
        return penalRate;
    }

    public void setPenalRate(double penalRate) {
        this.penalRate = penalRate;
    }
}
