/**
 * 
 */
package com.alstradocs.empicus.contact.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.alstradocs.empicus.diseasecase.model.DiseaseCase;
import com.alstradocs.empicus.refdata.model.GeoLocation;
import com.cloderia.enterprise.core.model.ArtifactData;
import com.cloderia.enterprise.core.model.ArtifactFieldData;
import com.cloderia.enterprise.core.model.BaseEntity;
import com.cloderia.enterprise.core.model.EntityStatus;
import com.cloderia.enterprise.core.util.IntegerUtil;

/**
 * @author Edward Banfa
 */
@Entity
@Table(name="DISEASE_CASE_CONTACT")
public class DiseaseCaseContact extends BaseEntity {

	private static final long serialVersionUID = 1L;
    public static final String ARTIFACT_NAME = "DiseaseCaseContact";
    private DiseaseCase caseId;
    private GeoLocation locationId;
    private EntityStatus statusId;
	@NotNull(message="The description is required.")
	private BigDecimal description;
	@NotNull(message="The gender is required.")
	private String gender;
	@NotNull(message="The age is required.")
	private Integer age;
	@NotNull(message="The contactDt is required.")
	private Date contactDt;

    public DiseaseCaseContact() {
    }
	
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CASE_ID", nullable=false)
    public DiseaseCase getCaseId() {
        return this.caseId;
    }
    
    public void setCaseId(DiseaseCase caseId) {
        this.caseId = caseId;
    }
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="LOCATION_ID", nullable=false)
    public GeoLocation getLocationId() {
        return this.locationId;
    }
    
    public void setLocationId(GeoLocation locationId) {
        this.locationId = locationId;
    }
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="STATUS_ID", nullable=false)
    public EntityStatus getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(EntityStatus statusId) {
        this.statusId = statusId;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getDescription()
     */
    @Column(name="DESCRIPTION", nullable=false, length=65535)
    public BigDecimal getDescription() {
        return this.description;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setDescription(java.math.BigDecimal)
     */
    public void setDescription(BigDecimal description) {
        this.description = description;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getGender()
     */
    @Column(name="GENDER", nullable=false, length=7)
    public String getGender() {
        return this.gender;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setGender(java.lang.String)
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getAge()
     */
    @Column(name="AGE", nullable=false, length=10)
    public Integer getAge() {
        return this.age;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setAge(java.lang.Integer)
     */
    public void setAge(Integer age) {
        this.age = age;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getContactDt()
     */
    @Column(name="CONTACT_DT", nullable=false, length=26)
    public Date getContactDt() {
        return this.contactDt;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setContactDt(java.util.Date)
     */
    public void setContactDt(Date contactDt) {
        this.contactDt = contactDt;
    }

	@Transient
	public String getArtifactName() {
		return ARTIFACT_NAME;
	}
	
	/**
	 * @return
	 */
	public ArtifactData toEntityData(){
		ArtifactData entityDataInstance = new ArtifactData();
		entityDataInstance.setArtifactName(ARTIFACT_NAME);
		entityDataInstance.getFieldData().put("id", new ArtifactFieldData("id", "java.long.String", false, getId()));
		entityDataInstance.getFieldData().put("caseId", new ArtifactFieldData("caseId", "DiseaseCase", true, getCaseId()));
		entityDataInstance.getFieldData().put("locationId", new ArtifactFieldData("locationId", "GeoLocation", true, getLocationId()));
		entityDataInstance.getFieldData().put("statusId", new ArtifactFieldData("statusId", "EntityStatus", true, getStatusId()));
		entityDataInstance.getFieldData().put("code", new ArtifactFieldData("code", "Code", false, getCode()));
		entityDataInstance.getFieldData().put("name", new ArtifactFieldData("name", "String", false, getName()));
		entityDataInstance.getFieldData().put("description", new ArtifactFieldData("description", "BigNumber", false, IntegerUtil.bigDecimalToString(getDescription())));
		entityDataInstance.getFieldData().put("status", new ArtifactFieldData("status", "String", false, getStatus()));
		entityDataInstance.getFieldData().put("gender", new ArtifactFieldData("gender", "String", false, getGender()));
		entityDataInstance.getFieldData().put("age", new ArtifactFieldData("age", "Number", false, getAge()));
		entityDataInstance.getFieldData().put("contactDt", new ArtifactFieldData("contactDt", "Date", false, getContactDt()));
		entityDataInstance.getFieldData().put("createdDt", new ArtifactFieldData("createdDt", "Date", false, getCreatedDt()));
		entityDataInstance.getFieldData().put("createdByUsr", new ArtifactFieldData("createdByUsr", "Code", false, getCreatedByUsr()));
		entityDataInstance.getFieldData().put("lastModifiedDt", new ArtifactFieldData("lastModifiedDt", "Date", false, getLastModifiedDt()));
		entityDataInstance.getFieldData().put("lastModifiedUsr", new ArtifactFieldData("lastModifiedUsr", "Code", false, getLastModifiedUsr()));

		return entityDataInstance;
	}
}


