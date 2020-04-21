/**
 * 
 */
package com.alstradocs.empicus.diseasecase.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.alstradocs.empicus.refdata.model.ClinicalFeature;
import com.alstradocs.empicus.refdata.model.DiseasePhase;
import com.cloderia.enterprise.core.model.ArtifactData;
import com.cloderia.enterprise.core.model.ArtifactFieldData;
import com.cloderia.enterprise.core.model.BaseEntity;
import com.cloderia.enterprise.core.model.EntityStatus;

/**
 * @author Edward Banfa
 */
@Entity
@Table(name="DISEASE_CASE_STATUS")
public class DiseaseCaseStatus extends BaseEntity {

	private static final long serialVersionUID = 1L;
    public static final String ARTIFACT_NAME = "DiseaseCaseStatus";
    private ClinicalFeature featureId;
    private DiseasePhase phaseId;
    private EntityStatus statusId;
    private DiseaseCase caseId;
	@NotNull(message="The description is required.")
	private String description;
	@NotNull(message="The statusDt is required.")
	private Date statusDt;

    public DiseaseCaseStatus() {
    }
	
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FEATURE_ID", nullable=false)
    public ClinicalFeature getFeatureId() {
        return this.featureId;
    }
    
    public void setFeatureId(ClinicalFeature featureId) {
        this.featureId = featureId;
    }
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PHASE_ID", nullable=true)
    public DiseasePhase getPhaseId() {
        return this.phaseId;
    }
    
    public void setPhaseId(DiseasePhase phaseId) {
        this.phaseId = phaseId;
    }
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="STATUS_ID", nullable=false)
    public EntityStatus getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(EntityStatus statusId) {
        this.statusId = statusId;
    }
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CASE_ID", nullable=true)
    public DiseaseCase getCaseId() {
        return this.caseId;
    }
    
    public void setCaseId(DiseaseCase caseId) {
        this.caseId = caseId;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getDescription()
     */
    @Column(name="DESCRIPTION", nullable=false, length=255)
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
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getStatusDt()
     */
    @Column(name="STATUS_DT", nullable=false, length=26)
    public Date getStatusDt() {
        return this.statusDt;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setStatusDt(java.util.Date)
     */
    public void setStatusDt(Date statusDt) {
        this.statusDt = statusDt;
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
		entityDataInstance.getFieldData().put("featureId", new ArtifactFieldData("featureId", "ClinicalFeature", true, getFeatureId()));
		entityDataInstance.getFieldData().put("phaseId", new ArtifactFieldData("phaseId", "DiseasePhase", true, getPhaseId()));
		entityDataInstance.getFieldData().put("statusId", new ArtifactFieldData("statusId", "EntityStatus", true, getStatusId()));
		entityDataInstance.getFieldData().put("caseId", new ArtifactFieldData("caseId", "DiseaseCase", true, getCaseId()));
		entityDataInstance.getFieldData().put("code", new ArtifactFieldData("code", "Code", false, getCode()));
		entityDataInstance.getFieldData().put("name", new ArtifactFieldData("name", "String", false, getName()));
		entityDataInstance.getFieldData().put("description", new ArtifactFieldData("description", "Text", false, getDescription()));
		entityDataInstance.getFieldData().put("status", new ArtifactFieldData("status", "String", false, getStatus()));
		entityDataInstance.getFieldData().put("statusDt", new ArtifactFieldData("statusDt", "Date", false, getStatusDt()));
		entityDataInstance.getFieldData().put("createdDt", new ArtifactFieldData("createdDt", "Date", false, getCreatedDt()));
		entityDataInstance.getFieldData().put("createdByUsr", new ArtifactFieldData("createdByUsr", "Code", false, getCreatedByUsr()));
		entityDataInstance.getFieldData().put("lastModifiedDt", new ArtifactFieldData("lastModifiedDt", "Date", false, getLastModifiedDt()));
		entityDataInstance.getFieldData().put("lastModifiedUsr", new ArtifactFieldData("lastModifiedUsr", "Code", false, getLastModifiedUsr()));

		return entityDataInstance;
	}
}


