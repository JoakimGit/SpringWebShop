package dk.kea.products_mvc.springmvc.Model;

import javax.persistence.*;

@Entity
@Table(name = "company_description")
public class CompanyDescription {

    @Id
    private Long companyDesc_id;

    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "company_id")
    private Company company;

    public CompanyDescription() {
    }

    public CompanyDescription(String description) {
        this.description = description;
    }

    public Long getCompanyDesc_id() {
        return companyDesc_id;
    }

    public void setCompanyDesc_id(Long companyDesc_id) {
        this.companyDesc_id = companyDesc_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "CompanyDescription{" +
                "companyDesc_id=" + companyDesc_id +
                ", description='" + description + '\'' +
                ", company=" + company +
                '}';
    }
}
