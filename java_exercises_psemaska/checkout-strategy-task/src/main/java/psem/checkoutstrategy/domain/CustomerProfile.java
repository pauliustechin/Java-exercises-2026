package psem.checkoutstrategy.domain;

import java.util.Objects;

public final class CustomerProfile {

    private String customerId;
    private boolean loyaltyMember;
    private String region;

    public CustomerProfile(String customerId, boolean loyaltyMember, String region) {

        if(customerId == null || region == null) {
            throw new IllegalArgumentException();
        }

        this.customerId = customerId;
        this.loyaltyMember = loyaltyMember;
        this.region = region;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getRegion() {
        return region;
    }

    public boolean isLoyaltyMember () {
        return loyaltyMember;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CustomerProfile that = (CustomerProfile) o;
        return loyaltyMember == that.loyaltyMember && Objects.equals(customerId, that.customerId) && Objects.equals(region, that.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, loyaltyMember, region);
    }

    @Override
    public String toString() {
        return "CustomerProfile{" +
                "customerId='" + customerId + '\'' +
                ", loyaltyMember=" + loyaltyMember +
                ", region='" + region + '\'' +
                '}';
    }
}
