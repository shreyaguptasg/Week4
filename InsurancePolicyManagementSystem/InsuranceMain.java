package Day2.InsurancePolicyManagementSystem;
import java.util.*;
import java.text.*;

 class InsurancePolicy implements Comparable<InsurancePolicy> {
    private final String policyNumber;
    private final String policyholderName;
    private final Date expiryDate;
    private final String coverageType;
    private final double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyholderName; }
    public Date getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    public double getPremiumAmount() { return premiumAmount; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) obj;
        return Objects.equals(policyNumber, that.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" + "Number='" + policyNumber + '\'' + ", Holder='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate + ", Coverage='" + coverageType + '\'' + ", Premium=" + premiumAmount + '}';
    }
}

 class InsurancePolicyManager {
    private final Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private final Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private final Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public Set<InsurancePolicy> getAllPolicies() {
        return new HashSet<>(hashSetPolicies);
    }

    public Set<InsurancePolicy> getExpiringSoon() {
        Set<InsurancePolicy> expiringSoon = new TreeSet<>();
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date thresholdDate = calendar.getTime();

        for (InsurancePolicy policy : treeSetPolicies) {
            if (policy.getExpiryDate().before(thresholdDate)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    public Set<InsurancePolicy> getPoliciesByCoverageType(String coverageType) {
        Set<InsurancePolicy> filteredPolicies = new HashSet<>();
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                filteredPolicies.add(policy);
            }
        }
        return filteredPolicies;
    }

    public Set<String> findDuplicatePolicies() {
        Set<String> duplicatePolicyNumbers = new HashSet<>();
        Set<String> seenPolicyNumbers = new HashSet<>();

        for (InsurancePolicy policy : hashSetPolicies) {
            if (!seenPolicyNumbers.add(policy.getPolicyNumber())) {
                duplicatePolicyNumbers.add(policy.getPolicyNumber());
            }
        }
        return duplicatePolicyNumbers;
    }
}

class PerformanceTester {
    public static void comparePerformance() {
        int numPolicies = 100000;
        Set<InsurancePolicy> hashSet = new HashSet<>();
        Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
        Set<InsurancePolicy> treeSet = new TreeSet<>();

        List<Set<InsurancePolicy>> sets = Arrays.asList(hashSet, linkedHashSet, treeSet);
        String[] setNames = {"HashSet", "LinkedHashSet", "TreeSet"};

        for (int i = 0; i < sets.size(); i++) {
            Set<InsurancePolicy> set = sets.get(i);
            String setName = setNames[i];

            long startTime = System.nanoTime();
            for (int j = 0; j < numPolicies; j++) {
                set.add(new InsurancePolicy("P" + j, "Holder" + j, new Date(), "Auto", 500.0));
            }
            long endTime = System.nanoTime();
            System.out.println(setName + " Insert Time: " + (endTime - startTime) / 1e6 + " ms");

            startTime = System.nanoTime();
            set.contains(new InsurancePolicy("P50000", "Holder50000", new Date(), "Auto", 500.0));
            endTime = System.nanoTime();
            System.out.println(setName + " Search Time: " + (endTime - startTime) / 1e6 + " ms");

            startTime = System.nanoTime();
            set.remove(new InsurancePolicy("P50000", "Holder50000", new Date(), "Auto", 500.0));
            endTime = System.nanoTime();
            System.out.println(setName + " Remove Time: " + (endTime - startTime) / 1e6 + " ms");

            System.out.println();
        }
    }
}

public class InsuranceMain {
    public static void main(String[] args) throws ParseException {
        InsurancePolicyManager manager = new InsurancePolicyManager();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Add sample policies
        manager.addPolicy(new InsurancePolicy("P1001", "Alice", sdf.parse("2025-06-10"), "Health", 1000.0));
        manager.addPolicy(new InsurancePolicy("P1002", "Bob", sdf.parse("2024-03-15"), "Auto", 1500.0));
        manager.addPolicy(new InsurancePolicy("P1003", "Carol", sdf.parse("2024-04-05"), "Home", 1200.0));

        // Display all policies
        System.out.println("All Policies:");
        manager.getAllPolicies().forEach(System.out::println);

        // Policies expiring soon
        System.out.println("\nExpiring Soon:");
        manager.getExpiringSoon().forEach(System.out::println);

        // Filter policies by coverage type
        System.out.println("\nAuto Policies:");
        manager.getPoliciesByCoverageType("Auto").forEach(System.out::println);

        // Find duplicate policies
        System.out.println("\nDuplicate Policies:");
        manager.findDuplicatePolicies().forEach(System.out::println);

        // Performance test
        System.out.println("\nPerformance Comparison:");
        PerformanceTester.comparePerformance();
    }
}
