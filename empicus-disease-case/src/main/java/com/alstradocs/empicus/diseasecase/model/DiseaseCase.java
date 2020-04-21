/**
 * 
 */
package com.alstradocs.empicus.diseasecase.model;

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

import com.alstradocs.empicus.refdata.model.GeoLocation;
import com.cloderia.enterprise.core.model.ArtifactData;
import com.cloderia.enterprise.core.model.ArtifactFieldData;
import com.cloderia.enterprise.core.model.BaseEntity;
import com.cloderia.enterprise.core.util.IntegerUtil;

/**
 * @author Edward Banfa
 */
@Entity
@Table(name="DISEASE_CASE")
public class DiseaseCase extends BaseEntity {

	private static final long serialVersionUID = 1L;
    public static final String ARTIFACT_NAME = "DiseaseCase";
    private PathogenStrain strainId;
    private GeoLocation locationId;
	@NotNull(message="The infectedDt is required.")
	private Date infectedDt;
	@NotNull(message="The dobDt is required.")
	private Date dobDt;
	@NotNull(message="The height is required.")
	private BigDecimal height;
	@NotNull(message="The weight is required.")
	private BigDecimal weight;
	@NotNull(message="The gender is required.")
	private String gender;
	private String description;
	private String observations;

    public DiseaseCase() {
    }
	
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="STRAIN_ID", nullable=false)
    public PathogenStrain getStrainId() {
        return this.strainId;
    }
    
    public void setStrainId(PathogenStrain strainId) {
        this.strainId = strainId;
    }
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="LOCATION_ID", nullable=false)
    public GeoLocation getLocationId() {
        return this.locationId;
    }
    
    public void setLocationId(GeoLocation locationId) {
        this.locationId = locationId;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getInfectedDt()
     */
    @Column(name="INFECTED_DT", nullable=false, length=10)
    public Date getInfectedDt() {
        return this.infectedDt;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setInfectedDt(java.util.Date)
     */
    public void setInfectedDt(Date infectedDt) {
        this.infectedDt = infectedDt;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getDobDt()
     */
    @Column(name="DOB_DT", nullable=false, length=10)
    public Date getDobDt() {
        return this.dobDt;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setDobDt(java.util.Date)
     */
    public void setDobDt(Date dobDt) {
        this.dobDt = dobDt;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getHeight()
     */
    @Column(name="HEIGHT", nullable=false, length=3)
    public BigDecimal getHeight() {
        return this.height;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setHeight(java.math.BigDecimal)
     */
    public void setHeight(BigDecimal height) {
        this.height = height;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getWeight()
     */
    @Column(name="WEIGHT", nullable=false, length=3)
    public BigDecimal getWeight() {
        return this.weight;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setWeight(java.math.BigDecimal)
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
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
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getDescription()
     */
    @Column(name="DESCRIPTION", nullable=true, length=150)
    public String getDescription() {
        return this.description;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setDescription(java.lang.String)
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getObservations()
     */
    @Column(name="OBSERVATIONS", nullable=true, length=150)
    public String getObservations() {
        return this.observations;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setObservations(java.lang.String)
     */
    public void setObservations(String observations) {
        this.observations = observations;
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
		entityDataInstance.getFieldData().put("strainId", new ArtifactFieldData("strainId", "PathogenStrain", true, getStrainId()));
		entityDataInstance.getFieldData().put("locationId", new ArtifactFieldData("locationId", "GeoLocation", true, getLocationId()));
		entityDataInstance.getFieldData().put("code", new ArtifactFieldData("code", "Code", false, getCode()));
		entityDataInstance.getFieldData().put("name", new ArtifactFieldData("name", "String", false, getName()));
		entityDataInstance.getFieldData().put("infectedDt", new ArtifactFieldData("infectedDt", "Date", false, getInfectedDt()));
		entityDataInstance.getFieldData().put("dobDt", new ArtifactFieldData("dobDt", "Date", false, getDobDt()));
		entityDataInstance.getFieldData().put("height", new ArtifactFieldData("height", "Money", false, IntegerUtil.bigDecimalToString(getHeight())));
		entityDataInstance.getFieldData().put("weight", new ArtifactFieldData("weight", "Money", false, IntegerUtil.bigDecimalToString(getWeight())));
		entityDataInstance.getFieldData().put("gender", new ArtifactFieldData("gender", "String", false, getGender()));
		entityDataInstance.getFieldData().put("description", new ArtifactFieldData("description", "Text", false, getDescription()));
		entityDataInstance.getFieldData().put("observations", new ArtifactFieldData("observations", "String", false, getObservations()));
		entityDataInstance.getFieldData().put("status", new ArtifactFieldData("status", "String", false, getStatus()));
		entityDataInstance.getFieldData().put("createdDt", new ArtifactFieldData("createdDt", "Date", false, getCreatedDt()));
		entityDataInstance.getFieldData().put("createdByUsr", new ArtifactFieldData("createdByUsr", "Code", false, getCreatedByUsr()));
		entityDataInstance.getFieldData().put("lastModifiedDt", new ArtifactFieldData("lastModifiedDt", "Date", false, getLastModifiedDt()));
		entityDataInstance.getFieldData().put("lastModifiedUsr", new ArtifactFieldData("lastModifiedUsr", "Code", false, getLastModifiedUsr()));

		return entityDataInstance;
	}
}


